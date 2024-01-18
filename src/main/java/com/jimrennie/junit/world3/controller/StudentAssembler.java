package com.jimrennie.junit.world3.controller;

import com.jimrennie.junit.world3.core.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentAssembler {

	public Student assemble(StudentDto studentDto) {
		return new Student()
				.setName(studentDto.getName())
				.setEmail(studentDto.getEmail())
				.setEmailVerified(false)
				.setEmailVerificationCode(null);
	}

	public List<StudentDto> disassemble(List<Student> students) {
		return students
				.stream()
				.map(this::disassemble)
				.toList();
	}

	public StudentDto disassemble(Student student) {
		return new StudentDto()
				.setStudentId(student.getStudentId())
				.setName(student.getName())
				.setEmail(student.getEmail())
				.setEmailVerified(student.getEmailVerified());
	}

}
