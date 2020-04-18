package io.github.bhuwanupadhyay.students;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

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

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private WebTestClient client;

	@LocalServerPort
	private int serverPort;

	@Test
	void name() {
	}

}