package com.example.tokenservice.model;

public class Author {

	private String name;
	private String bio;
	
	private String firstSurname;

	public Author() {}
	
	public Author(String name, String firstSurname, String bio) {
		this.name = name;
		this.firstSurname = firstSurname;
		this.bio = bio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

}
