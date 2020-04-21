package io.github.bhuwanupadhyay.students;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface StudentRepository extends ReactiveCrudRepository<StudentEntity, Long>,
		ReactiveSortingRepository<StudentEntity, Long> {

}
