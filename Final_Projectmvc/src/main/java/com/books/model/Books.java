package com.books.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class Books {
	private int id;

	@Size(min = 10, message = "Enter at least 10 Characters.")
	private String bookName;
	private String description;
	private Date date;

	public Books() {
		super();
	}

	public Books(int id, String bookName, Date date, String Description) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.description = Description;
		this.date=date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {return bookName;}

	public void setBookName(String bookName) {this.bookName = bookName;}

	public Date getDate() {return date;}

	public void setDate(Date date) {this.date = date;}

	public String getDescription() {return description;}

	public void setDescription(String description) {
		this.description = description;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Todo [id=%s, bookName=%s, description=%s, date=%s]", id,
				bookName, description,date);
	}

}