package com.employee.entity.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Book {
	@Id
	@GeneratedValue
	private int bookId;
	private String bookName;
}
