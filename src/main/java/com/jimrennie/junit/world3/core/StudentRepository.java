package com.jimrennie.junit.world3.core;

import com.jimrennie.junit.world3.core.Student;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends ListCrudRepository<Student, Long> {
	List<Student> findAllByGraduationYear(Integer year);
}
