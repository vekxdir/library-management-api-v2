package com.vek.LibraryManagementSystem.repo;

import com.vek.LibraryManagementSystem.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<AuthorEntity, Long> {
}
