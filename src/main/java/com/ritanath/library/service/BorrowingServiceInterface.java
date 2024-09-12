package com.ritanath.library.service;

import java.time.LocalDate;

import com.ritanath.library.model.Borrowing;

public interface BorrowingServiceInterface {


    Borrowing borrowBook(Long bookId, Long userId, LocalDate dateMustReturnIn);

    Borrowing returnBook(Long bookId, Long userId, LocalDate actualReturnDate);
}
