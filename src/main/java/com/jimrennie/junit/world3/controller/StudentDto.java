package com.jimrennie.junit.world3.controller;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StudentDto {
	private Long studentId;
	private String name;
	private String email;
	private Boolean emailVerified;
	private Integer graduationYear;
}
