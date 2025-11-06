package com.vek.LibraryManagementSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorRequestDTO {

    @NotBlank(message = "name is required")
    private String name;
    @Email(message = "provide email in valid format")
    private String email;
}
