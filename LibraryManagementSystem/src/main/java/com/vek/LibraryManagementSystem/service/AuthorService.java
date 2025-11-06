package com.vek.LibraryManagementSystem.service;

import com.vek.LibraryManagementSystem.dto.AuthorRequestDTO;
import com.vek.LibraryManagementSystem.dto.AuthorResponseDTO;

import java.util.List;

public interface AuthorService {
    List<AuthorResponseDTO> getAllAuthors();

    AuthorResponseDTO getAuthorById(Long id);

    AuthorResponseDTO createAuthors(AuthorRequestDTO dto);

    AuthorResponseDTO updateAuthorById(Long id, AuthorRequestDTO dto);

    void deleteAuthorById(Long id);

}
