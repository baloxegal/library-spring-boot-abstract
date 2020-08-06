package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @RequiredArgsConstructor @Getter @Setter @ToString

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Column(unique = true, nullable = false)
	private String fullName;
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
	@ToString.Exclude
	//TODO Lombok smojet podobrati pravilinii toString() dlea List?
	private List<Book> books = new ArrayList<Book>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "authors", cascade = CascadeType.REFRESH)
	@ToString.Exclude
	private List<Genre> genres = new ArrayList<Genre>();

}