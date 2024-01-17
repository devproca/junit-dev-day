package com.jimrennie.junit.world3.core;

import com.jimrennie.junit.world3.integration.EmailServer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;
	private final EmailServer emailServer;

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public List<Student> findByYear(Integer year) {
		return studentRepository.findAllByGraduationYear(year);
	}


	public Student get(long studentId) {
		return studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException(studentId));
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void sentEmailVerificationCode(long studentId) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException(studentId));

		save(student.setEmailVerificationCode(RandomCodeGenerator.generate()));

		emailServer.send(student.getEmail(), student.getEmailVerificationCode());
	}

	public void verifyEmail(long studentId, String verificationCode) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException(studentId));

		if (verificationCode == null || !verificationCode.equals(student.getEmailVerificationCode())) {
			throw new InvalidVerificationCodeException();
		}

		save(student.setEmailVerificationCode(null).setEmailVerified(true));
	}

	public void delete(long studentId) {
		studentRepository.deleteById(studentId);
	}

}
