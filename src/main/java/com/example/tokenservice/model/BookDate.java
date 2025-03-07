package com.example.tokenservice.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookDate extends Book {

	private String date;

	public BookDate(Book book) {
		super(book.getId(), book.getTitle(), book.getPages(), book.getSummary(), book.getAuthor(),
				book.getPublicationTimestamp());

		if (book.getPublicationTimestamp() != null) {
			Timestamp t = new Timestamp(book.getPublicationTimestamp());
			LocalDateTime dateTime = t.toLocalDateTime();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm-dd-yyyy");
			this.date = dateTime.format(formatter);
		}

	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
