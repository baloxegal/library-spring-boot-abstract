package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @RequiredArgsConstructor @Getter @Setter @ToString

@Entity
@Table(name = "users")
public class User extends BaseEntity {
		
	@NonNull
	@Column(unique = true)
	private String email;
	
	@NonNull
	private String password;
	
	private String role;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.REFRESH)
	@ToString.Exclude
	private List<Book> books = new ArrayList<Book>();

}