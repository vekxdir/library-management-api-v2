package com.vek.LibraryManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponseDTO {

    private Long id;
    private String title;
    private double price;
    private AuthorResponseDTO author;
}
