package com.vek.LibraryManagementSystem.service;

import com.vek.LibraryManagementSystem.dto.AuthorResponseDTO;
import com.vek.LibraryManagementSystem.dto.BookRequestDTO;
import com.vek.LibraryManagementSystem.dto.BookResponseDTO;
import com.vek.LibraryManagementSystem.exception.AuthorNotFoundException;
import com.vek.LibraryManagementSystem.exception.BookNotFoundException;
import com.vek.LibraryManagementSystem.model.AuthorEntity;
import com.vek.LibraryManagementSystem.model.BookEntity;
import com.vek.LibraryManagementSystem.repo.AuthorRepo;
import com.vek.LibraryManagementSystem.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bRepo;
    @Autowired
    private AuthorRepo aRepo;

    //getAllBooks
    @Override
    public List<BookResponseDTO> getAllBooks() {

        List<BookEntity> bookDB = bRepo.findAll();

        List<BookResponseDTO> bookDTO = new ArrayList<>();
        for (BookEntity s : bookDB) {
            AuthorEntity ae = s.getAuthor();

            AuthorResponseDTO authorDTO = AuthorResponseDTO.builder()
                    .id(ae.getId())
                    .name(ae.getName())
                    .email(ae.getEmail())
                    .build();

            BookResponseDTO bDTO = BookResponseDTO.builder()
                    .id(s.getId())
                    .title(s.getTitle())
                    .price(s.getPrice())
                    .author(authorDTO)
                    .build();

            bookDTO.add(bDTO);

        }
        return bookDTO;
    }

    //get Book By Id
    @Override
    public BookResponseDTO getBookById(Long id) {
        BookEntity bEntity = bRepo.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        AuthorEntity aEntity = bEntity.getAuthor();

        AuthorResponseDTO aDTO = AuthorResponseDTO.builder()
                .id(aEntity.getId())
                .name(aEntity.getName())
                .email(aEntity.getEmail())
                .build();

        return BookResponseDTO.builder()
                .id(bEntity.getId())
                .title(bEntity.getTitle())
                .price(bEntity.getPrice())
                .author(aDTO)
                .build();

    }

    //create
    @Override
    public BookResponseDTO createBook(BookRequestDTO reqDTO) {
        AuthorEntity aEntity = aRepo.findById(reqDTO.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(reqDTO.getAuthorId()));
        BookEntity bEntity = BookEntity.builder()
                .title(reqDTO.getTitle())
                .price(reqDTO.getPrice())
                .author(aEntity)
                .build();

        BookEntity saved = bRepo.save(bEntity);

        AuthorResponseDTO aDTO = AuthorResponseDTO.builder()
                .id(saved.getAuthor().getId())
                .name(saved.getAuthor().getName())
                .email(saved.getAuthor().getEmail())
                .build();

        return BookResponseDTO.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .price(saved.getPrice())
                .author(aDTO)
                .build();
    }

    //update
    @Override
    public BookResponseDTO updateBookById(BookRequestDTO reqDTO, Long id) {
        BookEntity bEntity = bRepo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        bEntity.setTitle(reqDTO.getTitle());
        bEntity.setPrice(reqDTO.getPrice());

        AuthorResponseDTO aDTO = AuthorResponseDTO.builder()
                .id(bEntity.getAuthor().getId())
                .name(bEntity.getAuthor().getName())
                .email(bEntity.getAuthor().getEmail())
                .build();

        return BookResponseDTO.builder()
                .id(bEntity.getId())
                .title(bEntity.getTitle())
                .price(bEntity.getPrice())
                .author(aDTO)
                .build();

    }
    //delete

    @Override
    public BookResponseDTO deleteById(Long id) {
        BookEntity bEntity = bRepo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        bRepo.delete(bEntity);

        return BookResponseDTO.builder()
                .id(bEntity.getId())
                .title(bEntity.getTitle())
                .price(bEntity.getPrice())
                .build();

    }

}
