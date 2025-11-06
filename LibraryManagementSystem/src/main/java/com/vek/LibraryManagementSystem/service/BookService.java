package com.vek.LibraryManagementSystem.service;

import com.vek.LibraryManagementSystem.dto.BookRequestDTO;
import com.vek.LibraryManagementSystem.dto.BookResponseDTO;

import java.util.List;

public interface BookService {
    List<BookResponseDTO> getAllBooks();

    BookResponseDTO getBookById(Long id);

    BookResponseDTO createBook(BookRequestDTO reqDTO);

    BookResponseDTO updateBookById(BookRequestDTO reqDTO, Long id);

    BookResponseDTO deleteById(Long id);
}
