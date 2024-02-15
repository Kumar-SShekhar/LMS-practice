package com.shekhar.LmsPractice.controller;

import com.shekhar.LmsPractice.model.Book;
import com.shekhar.LmsPractice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/getByTitle/{title}")
    public ResponseEntity<List<Book>> getByTitle(@PathVariable String title){
        List<Book> book=bookService.findByTitle(title);
        return new ResponseEntity<>(book , HttpStatus.OK);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping("/borrowBook/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        Book borrowedBook = bookService.borrowBook(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/returnBook/{bookId}")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        Book returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
//            return ResponseEntity.ok(returnedBook);
            return new ResponseEntity<>(returnedBook, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getBorrowedBooks")
    public ResponseEntity<List<Book>> getBorrowedBooks() {
        List<Book> borrowedBooks = bookService.findBooksByBorrowed();
        return ResponseEntity.ok(borrowedBooks);
    }

    @GetMapping("/getAvailableBooks")
    public ResponseEntity<List<Book>> getAvailableBooks() {
        List<Book> availableBooks = bookService.findAvailableBooks();
        return ResponseEntity.ok(availableBooks);
    }

    @GetMapping("/getBookByStartingLetter")
    public ResponseEntity<List<Book>> getBookByStartingLetter(@RequestParam("title") char ch){
        List<Book> book = bookService.findBookByStartingLetter(ch);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/getAllBooksWithSorted/{field}")
    public List<Book> getAllBooksWithSorted(@PathVariable String field){
        return bookService.findAllBooksWithSorted(field);
    }

    @GetMapping("/getAllBooksWithPagination/{pageNumber}/{pageSize}")
    public Page<Book> getAllBooksWithPagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize)
    {
        return bookService.findAllBooksWithPagination(pageNumber,pageSize);
    }

    @GetMapping("/getAllBooksWithPaginationAndSorting/{pageNumber}/{pageSize}/{field}")
    public Page<Book> getAllBooksWithPaginationAndSorting(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, @PathVariable String field)
    {
        return bookService.findAllBooksWithPaginationAndSorting(pageNumber,pageSize,field);
    }
}