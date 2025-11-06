package com.vek.LibraryManagementSystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequestDTO {

    @NotBlank(message = "title required")
    private String title;
    @NotNull(message = "price require")
    private double price;

    private Long authorId;
}
