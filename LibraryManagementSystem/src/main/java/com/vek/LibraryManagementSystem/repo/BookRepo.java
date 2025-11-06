package com.vek.LibraryManagementSystem.repo;

import com.vek.LibraryManagementSystem.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long> {
}
