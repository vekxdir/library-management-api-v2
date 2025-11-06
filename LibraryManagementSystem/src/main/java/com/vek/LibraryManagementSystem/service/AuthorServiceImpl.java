package com.vek.LibraryManagementSystem.service;

import com.vek.LibraryManagementSystem.dto.AuthorRequestDTO;
import com.vek.LibraryManagementSystem.dto.AuthorResponseDTO;
import com.vek.LibraryManagementSystem.exception.AuthorNotFoundException;
import com.vek.LibraryManagementSystem.model.AuthorEntity;
import com.vek.LibraryManagementSystem.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepo aRepo;

    //get all
    @Override
    public List<AuthorResponseDTO> getAllAuthors() {
        List<AuthorEntity> aEntity = aRepo.findAll();

        List<AuthorResponseDTO> list = new ArrayList<>();
        for (AuthorEntity db : aEntity) {
            list.add(AuthorResponseDTO.builder()
                    .id(db.getId())
                    .name(db.getName())
                    .email(db.getEmail())
                    .build());


        }
        return list;
    }

    //get by id
    @Override
    public AuthorResponseDTO getAuthorById(Long id) {
        AuthorEntity aEntity = aRepo.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));

        return AuthorResponseDTO.builder()
                .id(aEntity.getId())
                .name(aEntity.getName())
                .email(aEntity.getEmail())
                .build();
    }

    //create author
    @Override
    public AuthorResponseDTO createAuthors(AuthorRequestDTO dto) {
        AuthorEntity aEntity = AuthorEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();

        AuthorEntity saved = aRepo.save(aEntity);

        return AuthorResponseDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .email(saved.getEmail())
                .build();
    }

    //    update author by id
    @Override
    public AuthorResponseDTO updateAuthorById(Long id, AuthorRequestDTO dto) {
        AuthorEntity aEntity = aRepo.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        aEntity.setName(dto.getName());
        aEntity.setEmail(dto.getEmail());

        AuthorEntity updateSaved = aRepo.save(aEntity);

        return AuthorResponseDTO.builder()
                .id(updateSaved.getId())
                .name(updateSaved.getName())
                .email(updateSaved.getEmail())
                .build();
    }

    //delete the author by id
    public void deleteAuthorById(Long id) {
        AuthorEntity aEntity = aRepo.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        aRepo.delete(aEntity);
    }
}
