package com.excelr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="book_restapi")
@Data
public class Book {

	@Id
	private Integer bookId;
	private String bookName;
	private Double bookPrice;
}
