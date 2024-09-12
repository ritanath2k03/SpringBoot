package com.ritanath.library.repo;

import com.ritanath.library.model.Book;
import com.ritanath.library.model.Borrowing;
import com.ritanath.library.model.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRepo extends JpaRepository<Borrowing, Long> {

    Optional<Borrowing> findBorrowingByAppUserAndBook(AppUser appUser, Book book);
}
