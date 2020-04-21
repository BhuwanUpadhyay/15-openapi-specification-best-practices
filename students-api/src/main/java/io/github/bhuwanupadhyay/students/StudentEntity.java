package io.github.bhuwanupadhyay.students;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.Auditable;

public class StudentEntity extends AbstractAggregateRoot<StudentEntity>
		implements Auditable<Operator, Long, LocalDateTime> {

	private Long id;

	private String name;

	private LocalDate birthDate;

	private StudentStatus status;

	private Operator createdBy;

	private LocalDateTime creationDate;

	private Operator lastModifiedBy;

	private LocalDateTime lastModifiedDate;

	private StudentEntity() {
	}

	@Override
	public Optional<Operator> getCreatedBy() {
		return Optional.ofNullable(this.createdBy);
	}

	@Override
	public void setCreatedBy(Operator createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public Optional<LocalDateTime> getCreatedDate() {
		return Optional.ofNullable(this.creationDate);
	}

	@Override
	public void setCreatedDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public Optional<Operator> getLastModifiedBy() {
		return Optional.ofNullable(this.lastModifiedBy);
	}

	@Override
	public void setLastModifiedBy(Operator lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	public Optional<LocalDateTime> getLastModifiedDate() {
		return Optional.ofNullable(this.lastModifiedDate);
	}

	@Override
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public boolean isNew() {
		return Objects.isNull(this.getId());
	}

}
