package com.phpteam.project.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {

    private Long id;
    @NotEmpty(message = "First name cannot be empty.")
    @Size(min = 5, max = 50)
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty.")
    @Size(min = 5, max = 50)
    private String lastName;
    @NotEmpty(message = "Email cannot be empty.")
    @Email
    private String email;
    @NotNull(message = "Phone  cannot be empty.")
    private String phone;
    private String password;
}
