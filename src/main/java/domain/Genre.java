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
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String name;
			
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
	@ToString.Exclude
	private List<Book> books = new ArrayList<Book>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres", cascade = CascadeType.REFRESH)
	@ToString.Exclude
	private List<Author> authors = new ArrayList<Author>();
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void removeBook(Book book) {
		books.remove(book);
	}
	
	public void addAuthor(Author author) {
		authors.add(author);
		author.getGenres().add(this);
	}
	
	public void removeAuthor(Author author) {
		authors.remove(author);
		author.getGenres().remove(this);
	}
}