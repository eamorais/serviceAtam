package com.example.tokenservice.service;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.tokenservice.model.Book;
import com.example.tokenservice.model.BookDate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookService {

	private final ObjectMapper objectMapper = new ObjectMapper();

	public Optional<BookDate> filter(String filter, List<Book> books) {
		// Leer los libros del archivo JSON
		List<Book> filteredBooks = new ArrayList<>();

		// Mostrar los libros que no tienen fecha de publicación
		books.forEach(book -> {
			if (book.getPublicationTimestamp() == null || book.getPublicationTimestamp().equals("")) {
				System.out.println("Libro sin fecha de publicación: " + book.getTitle());
			}
		});

		// Filtrar libros que contienen la cadena de búsqueda en nombre, resumen o
		// biografía
		filteredBooks = books.stream().filter(book -> book.getTitle().contains(filter)
				|| book.getSummary().contains(filter) || book.getAuthor().getBio().contains(filter))
				.sorted((b1, b2) -> {
					Long t1 = b1.getPublicationTimestamp();
					Long t2 = b2.getPublicationTimestamp();

					if (t1 == null && t2 == null)
						return 0;
					if (t1 == null)
						return 1;
					if (t2 == null)
						return -1;

					return t1.compareTo(t2);
				}) // Ordenar por fecha de publicación
				.collect(Collectors.toList());

		// Si no hay libros que coincidan, devolver un Optional vacío
		if (filteredBooks.isEmpty()) {
			return Optional.empty();
		}

		// Crear lista para devolver
		List<BookDate> bookDates = filteredBooks.stream().map(book -> new BookDate(book)).collect(Collectors.toList());

		// Agrupar por fecha de publicación y luego ordenar por biografía más corta
		bookDates
				.sort(Comparator.comparing(BookDate::getPublicationTimestamp, Comparator.nullsLast(Long::compareTo))
						.thenComparing(b -> b.getAuthor() != null && b.getAuthor().getBio() != null
								? b.getAuthor().getBio().length()
								: 0));

		// Retornar el primer libro con la fecha
		return Optional.of(bookDates.get(0));
	}

	public List<Book> readBooksFromJson() throws IOException {
		// Leer los libros desde el archivo JSON
		return Arrays.asList(objectMapper.readValue(new File("books.json"), Book[].class));
	}
}