package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Setter // red for de ser
@Getter // getting email n pass
@ToString // only for dubbing

@Valid
public class AuthRequestDTO {
	@NotBlank(message = "email cant be blank")
	private String email;
	@NotBlank(message = "pass cnat be blank")
	private String password;
}
