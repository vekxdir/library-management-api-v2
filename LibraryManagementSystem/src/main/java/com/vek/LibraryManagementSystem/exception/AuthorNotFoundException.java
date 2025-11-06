package com.vek.LibraryManagementSystem.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id) {
        super("Author Not Found by id " + id);
    }
}
