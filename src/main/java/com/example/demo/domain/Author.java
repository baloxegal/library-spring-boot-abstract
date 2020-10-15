package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Author extends BaseEntity {
			
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
	private List<Book> books = new ArrayList<Book>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "authors", cascade = CascadeType.REFRESH)
	private List<Genre> genres = new ArrayList<Genre>();

}