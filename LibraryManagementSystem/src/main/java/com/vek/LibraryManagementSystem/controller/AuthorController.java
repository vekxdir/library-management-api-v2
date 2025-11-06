package com.vek.LibraryManagementSystem.controller;

import com.vek.LibraryManagementSystem.dto.AuthorRequestDTO;
import com.vek.LibraryManagementSystem.dto.AuthorResponseDTO;
import com.vek.LibraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    private AuthorService service;

    //    get all
    @GetMapping("/authors")
    public ResponseEntity<List<AuthorResponseDTO>> getAllAuthors() {
        List<AuthorResponseDTO> authorDTO = service.getAllAuthors();
        return ResponseEntity.ok(authorDTO);
    }

    //    get by id
    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Long id) {
        AuthorResponseDTO authorDTO = service.getAuthorById(id);
        return ResponseEntity.ok(authorDTO);
    }

    //    create author
    @PostMapping("/authors")
    public ResponseEntity<AuthorResponseDTO> createAuthors(@RequestBody AuthorRequestDTO dto) {
        AuthorResponseDTO authorDTO = service.createAuthors(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorDTO);

    }

    //update the authors by id
    @PatchMapping("/authors/{id}")
    public ResponseEntity<AuthorResponseDTO> updateAuthorById(@PathVariable Long id, @RequestBody AuthorRequestDTO dto) {
        AuthorResponseDTO authorDTO = service.updateAuthorById(id, dto);
        return ResponseEntity.ok(authorDTO);
    }

    //    delete author by id
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Void> deleteAuthorById(@PathVariable Long id) {
        service.deleteAuthorById(id);
        return ResponseEntity.noContent().build();
    }

}
