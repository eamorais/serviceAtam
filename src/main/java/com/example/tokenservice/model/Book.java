package com.example.tokenservice.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

	private int id;
	private String title;
	private int pages;
	private String summary;
	private Author author;

	@JsonProperty("publicationTimestamp")
	private Long publicationTimestamp;

	public Book() {
	}

	/*
	 * public Book(int id, String title, int pages, String summary, Author author,
	 * Long publicationTimestamp) { super(); this.id = id; this.title = title;
	 * this.pages = pages; this.summary = summary; this.author = author;
	 * this.publicationTimestamp = publicationTimestamp; }
	 */

	@JsonCreator
	public Book(@JsonProperty("id") int id, @JsonProperty("title") String title, @JsonProperty("pages") int pages,
			@JsonProperty("summary") String summary, @JsonProperty("author") Author author,
			@JsonProperty("publicationTimestamp") Long publicationTimestamp) {
		this.id = id;
		this.title = title;
		this.pages = pages;
		this.summary = summary;
		this.author = author;
		this.publicationTimestamp = publicationTimestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Long getPublicationTimestamp() {
		return publicationTimestamp;
	}

	public void setPublicationTimestamp(Long publicationTimestamp) {
		this.publicationTimestamp = publicationTimestamp;
	}

}
