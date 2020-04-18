package io.github.bhuwanupadhyay.students;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = App.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = { WebApiIntegrationTests.Initializer.class })
@Testcontainers
class WebApiIntegrationTests {

	@Container
	private static final PostgreSQLContainer SQL_CONTAINER = new PostgreSQLContainer()
			.withDatabaseName("students").withUsername("repl_user")
			.withPassword("repl_password");

	static class Initializer
			implements ApplicationContextInitializer<ConfigurableApplicationContext> {

		public void initialize(
				ConfigurableApplicationContext configurableApplicationContext) {
			TestPropertyValues
					.of("spring.datasource.url=" + SQL_CONTAINER.getJdbcUrl(),
							"spring.datasource.username=" + SQL_CONTAINER.getUsername(),
							"spring.datasource.password=" + SQL_CONTAINER.getPassword())
					.applyTo(configurableApplicationContext.getEnvironment());
		}

	}

}