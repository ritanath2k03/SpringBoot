package com.ritanath.library.mapper;

import com.ritanath.library.dto.BookDto;
import com.ritanath.library.model.Book;

public class BookMapper {

    public static Book toEntity(BookDto bookDto) {
        return Book.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .description(bookDto.getDescription())
                .publicationYear(bookDto.getPublicationYear())
                .isbn(bookDto.getIsbn())
                .author(bookDto.getAuthor())
                .build();
    }

    public static BookDto toDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .description(book.getDescription())
                .publicationYear(book.getPublicationYear())
                .isbn(book.getIsbn())
                .author(book.getAuthor())
                .build();
    }
}