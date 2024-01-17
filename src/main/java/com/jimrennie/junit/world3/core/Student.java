package com.jimrennie.junit.world3.core;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

@Data
@EqualsAndHashCode(of = "studentId")
@Accessors(chain = true)
public class Student {
	@Id
	private Long studentId;
	private String name;
	private String email;
	private String emailVerificationCode;
	private Boolean emailVerified;
	private Integer graduationYear;
}
