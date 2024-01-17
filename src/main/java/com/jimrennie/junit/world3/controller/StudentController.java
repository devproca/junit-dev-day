package com.jimrennie.junit.world3.controller;

import com.jimrennie.junit.world3.core.Student;
import com.jimrennie.junit.world3.core.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

	private final StudentAssembler studentAssembler;
	private final StudentService studentService;

	@GetMapping
	public List<StudentDto> findAll() {
		return studentAssembler.disassemble(studentService.findAll());
	}

	@GetMapping(params = "year")
	public List<StudentDto> findByYear(@RequestParam("year") Integer year) {
		return studentAssembler.disassemble(studentService.findByYear(year));
	}

	@GetMapping("/{studentId}")
	public StudentDto get(@PathVariable("studentId") Long studentId) {
		return studentAssembler.disassemble(studentService.get(studentId));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public StudentDto create(@RequestBody StudentDto studentDto) {
		Student student = studentAssembler.assemble(studentDto);
		return studentAssembler.disassemble(studentService.save(student));
	}

	@PostMapping("/{studentId}/send-email-verification-code")
	public void sendEmailVerificationCode(@PathVariable("studentId") Long studentId) {
		studentService.sentEmailVerificationCode(studentId);
	}

	@PostMapping("/{studentId}/verify-email-verification-code")
	public void sendEmailVerificationCode(@PathVariable("studentId") Long studentId,
	                                      @RequestBody EmailVerificationCodeDto codeDto) {
		studentService.verifyEmail(studentId, codeDto.getCode());
	}

	@DeleteMapping("/{studentId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("studentId") Long studentId) {
		studentService.delete(studentId);
	}

}
