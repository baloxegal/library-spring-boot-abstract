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

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @RequiredArgsConstructor @Getter @Setter @ToString

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String fullName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@ToString.Exclude
	private List<Book> books = new ArrayList<Book>();
	
	public void addBook(Book book) {
		books.add(book);
		book.getClients().add(this);
	}
	
	public void removeBook(Book book) {
		books.remove(book);
		book.getClients().remove(this);
	}
}