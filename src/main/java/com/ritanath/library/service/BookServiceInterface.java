package com.ritanath.library.service;

import java.util.List;

import com.ritanath.library.model.Book;


public interface BookServiceInterface {

    Book save(Book book);

    Book findById(Long id);

    List<Book> findAll();

    void deleteById(Long id);

    Book updateById(Long id, Book newBookInfoToUpdateWithIt);
}
