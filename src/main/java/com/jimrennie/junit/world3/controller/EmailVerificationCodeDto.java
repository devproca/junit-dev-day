package com.jimrennie.junit.world3.controller;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmailVerificationCodeDto {
	private String code;
}
