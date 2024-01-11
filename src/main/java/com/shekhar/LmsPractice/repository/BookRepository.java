package com.shekhar.LmsPractice.repository;

import com.shekhar.LmsPractice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book , Long> {
    List<Book> findByBorrowedIsTrue();

    List<Book> findByBorrowedIsFalse();

    public List<Book> findByTitleStartingWith(char ch);
}
