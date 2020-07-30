package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	private String fullName;
		
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
	@ToString.Exclude
	//TODO Lombok smojet podobrati pravilinii toString() dlea List?
	private List<Book> books = new ArrayList<Book>();
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@ToString.Exclude
	private List<Genre> genres = new ArrayList<Genre>();
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void removeBook(Book book) {
		books.remove(book);
	}
	
	public void addGenre(Genre genre) {
		genres.add(genre);
		genre.getAuthors().add(this);
	}
	
	public void removeGenre(Genre genre) {
		genres.remove(genre);
		genre.getAuthors().remove(this);
	}
}