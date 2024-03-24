package com.employee.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.book.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
