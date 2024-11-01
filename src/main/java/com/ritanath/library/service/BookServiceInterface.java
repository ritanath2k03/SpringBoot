package com.ritanath.library.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritanath.library.dto.BookDto;
import com.ritanath.library.model.Book;


public interface BookServiceInterface{

    Book save(Book book);

    Book findById(Long id);

    List<Book> findAll();
    List<Book> findSmallBooks();

    void deleteById(Long id);

    Book updateById(Long id, Book newBookInfoToUpdateWithIt);
}
