package com.bookshelf.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookshelf.bookshelf.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
