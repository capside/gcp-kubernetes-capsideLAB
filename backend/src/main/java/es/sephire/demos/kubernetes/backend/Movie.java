package es.sephire.demos.kubernetes.backend;

import java.util.Date;

/**
 * The movie model DTO
 */
public class Movie {
	private Long id;
	private String name;
	private Date publishedDate;
	private String description;

	public Movie(Long id, String name, Date publishedDate, String description) {
		this.id = id;
		this.name = name;
		this.publishedDate = publishedDate;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
