package com.ritanath.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ritanath.library.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
}
