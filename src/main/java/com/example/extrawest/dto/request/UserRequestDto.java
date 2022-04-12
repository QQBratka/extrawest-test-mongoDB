package com.example.extrawest.dto.request;

import javax.validation.constraints.Size;
import com.example.extrawest.security.validate.FieldsValueMatch;
import com.example.extrawest.security.validate.ValidEmail;
import lombok.Getter;

@FieldsValueMatch(field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!")
@Getter
public class UserRequestDto {
    @ValidEmail
    private String email;
    @Size(min = 6, max = 12)
    private String password;
    private String repeatPassword;
}
