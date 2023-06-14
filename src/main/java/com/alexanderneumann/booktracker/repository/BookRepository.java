package com.alexanderneumann.booktracker.repository;

import com.alexanderneumann.booktracker.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
