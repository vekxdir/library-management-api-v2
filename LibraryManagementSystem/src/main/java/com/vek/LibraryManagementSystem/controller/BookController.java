package com.vek.LibraryManagementSystem.controller;

import com.vek.LibraryManagementSystem.dto.BookRequestDTO;
import com.vek.LibraryManagementSystem.dto.BookResponseDTO;
import com.vek.LibraryManagementSystem.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class BookController {

    @Autowired
    private BookService service;

    //get all
    @GetMapping("/books")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
        List<BookResponseDTO> bookDTO = service.getAllBooks();
        return ResponseEntity.ok(bookDTO);
    }

    //get by id
    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id) {
        BookResponseDTO bookDTO = service.getBookById(id);
        return ResponseEntity.ok(bookDTO);
    }

    //create
    @PostMapping("/books")
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody @Valid BookRequestDTO reqDTO) {
        BookResponseDTO bookDTO = service.createBook(reqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDTO);
    }

    //update by id
    @PatchMapping("/books/{id}")
    public ResponseEntity<BookResponseDTO> updateBookById(@RequestBody BookRequestDTO reqDTO, @PathVariable Long id) {
        BookResponseDTO bookDTO = service.updateBookById(reqDTO, id);
        return ResponseEntity.ok(bookDTO);
    }

    //    delete by id
    @DeleteMapping("/books/{id}")
    public ResponseEntity<BookResponseDTO> deleteById(@PathVariable Long id) {
        BookResponseDTO bookDTO = service.deleteById(id);
        return ResponseEntity.ok(bookDTO);
    }

}
