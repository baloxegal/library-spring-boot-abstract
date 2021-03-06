package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @RequiredArgsConstructor @Getter @Setter @ToString

@Entity
public class Book extends BaseEntity {
		
	@NonNull
	private Integer year;
	@NonNull
	private Boolean avaliable;
	
	@NonNull
	private String cover;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Genre genre;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Author author;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@ToString.Exclude
	private List<User> users = new ArrayList<User>();

}