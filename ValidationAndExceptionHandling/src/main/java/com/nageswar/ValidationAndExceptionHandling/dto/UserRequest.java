package com.nageswar.ValidationAndExceptionHandling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class UserRequest {

    @NotNull(message = "User name should not be null")
    private String name;
    //@NotNull(message = "Invalid mobile number")
    @Pattern(regexp="^\\d{10}$", message = "Invalid mobile number")
    private String mobile;
    private String gender;
    @Email(message = "Invalid email")
    private String email;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
