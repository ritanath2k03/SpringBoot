package com.ritanath.library.mapper;

import com.ritanath.library.dto.BorrowingDto;
import com.ritanath.library.model.Borrowing;

public class BorrowingMapper {
    public static BorrowingDto toDto(Borrowing borrowing) {
        return BorrowingDto.builder()
                .id(borrowing.getId())
                .user(UserMapper.toDto(borrowing.getAppUser()))
                .book(BookMapper.toDto(borrowing.getBook()))
                .borrowingDate(borrowing.getBorrowingDate())
                .dateMustReturnIn(borrowing.getDateMustReturnIn())
                .actualReturnDate(borrowing.getActualReturnDate())
                .paidFeesAmount(borrowing.getPaidFeesAmount())
                .build();
    }

    public static Borrowing toEntity(BorrowingDto borrowingDto) {
        return Borrowing.builder()
                .id(borrowingDto.getId())
                .appUser(UserMapper.toEntity(borrowingDto.getUser()))
                .book(BookMapper.toEntity(borrowingDto.getBook()))
                .borrowingDate(borrowingDto.getBorrowingDate())
                .dateMustReturnIn(borrowingDto.getDateMustReturnIn())
                .actualReturnDate(borrowingDto.getActualReturnDate())
                .paidFeesAmount(borrowingDto.getPaidFeesAmount())
                .build();
    }
}
