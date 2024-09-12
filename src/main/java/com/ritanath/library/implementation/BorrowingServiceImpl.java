package com.ritanath.library.implementation;

import com.ritanath.library.model.Book;
import com.ritanath.library.model.Borrowing;
import com.ritanath.library.model.AppUser;
import com.ritanath.library.repo.BorrowingRepo;
import com.ritanath.library.service.BookServiceInterface;
import com.ritanath.library.service.BorrowingServiceInterface;
import com.ritanath.library.service.UserServiceInterface;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.Period;


@Service
@AllArgsConstructor
@Transactional
public class BorrowingServiceImpl implements BorrowingServiceInterface {

    private final BorrowingRepo borrowingRepo;

    private final UserServiceInterface appUserServiceInterface;

    private final BookServiceInterface bookServiceInterface;

    private static final int BOOK_DELIVERY_FEES_PER_DAY = 10;

    @Override
    public Borrowing borrowBook(Long bookId, Long userId, LocalDate dateMustReturnIn) {
        Book book = bookServiceInterface.findById(bookId);
        AppUser appUser = appUserServiceInterface.findById(userId);

        Borrowing borrowing = Borrowing.builder()
                .book(book)
                .appUser(appUser)
                .borrowingDate(LocalDate.now())
                .dateMustReturnIn(dateMustReturnIn)
                .actualReturnDate(null)
                .build();

        return borrowingRepo.save(borrowing);
    }

    @Override
    public Borrowing returnBook(Long bookId, Long userId, LocalDate actualReturnDate) {
        Book book = bookServiceInterface.findById(bookId);
        AppUser appUser = appUserServiceInterface.findById(userId);

        Borrowing borrowing = borrowingRepo.findBorrowingByAppUserAndBook(appUser,book)
                        .orElseThrow();

        borrowing.setActualReturnDate(actualReturnDate);
        borrowingRepo.save(borrowing);


        int delayFeesMustBePaid = 0;
        if(actualReturnDate.isAfter(borrowing.getDateMustReturnIn())) {
            int delayDays = Period.between(borrowing.getDateMustReturnIn(), actualReturnDate).getDays();
            delayFeesMustBePaid = delayDays * BOOK_DELIVERY_FEES_PER_DAY;
        }

        borrowing.setPaidFeesAmount(delayFeesMustBePaid);
        borrowing = borrowingRepo.save(borrowing);

        return borrowing;
    }
}
