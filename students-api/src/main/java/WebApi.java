import io.github.bhuwanupadhyay.students.openapi.StudentPageList;
import io.github.bhuwanupadhyay.students.openapi.StudentsApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import com.google.common.flogger.FluentLogger;

@RestController
@Slf4j
public class WebApi implements StudentsApi {

	private static final FluentLogger logger = FluentLogger.forEnclosingClass();

	@Override
	public Mono<ResponseEntity<StudentPageList>> getStudents(ServerWebExchange exchange) {
		return null;
	}

}
