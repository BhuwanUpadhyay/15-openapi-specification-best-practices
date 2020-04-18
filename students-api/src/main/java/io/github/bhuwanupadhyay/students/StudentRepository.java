package io.github.bhuwanupadhyay.students;

import io.github.bhuwanupadhyay.students.openapi.StudentResource;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StudentRepository extends ReactiveCrudRepository<StudentResource, String> {
}
