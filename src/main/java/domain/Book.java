package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String title;
	//TODO warning na @NonNull dlea primitiviov?
	@NonNull
	private int year;
	@NonNull
	private boolean avaliable;
	
	@NonNull
	private String cover;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Genre genre;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Author author;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "books", cascade = CascadeType.REFRESH)
	@ToString.Exclude
	private List<Client> clients = new ArrayList<Client>();
	
	public void addClient(Client client) {
		clients.add(client);
		client.getBooks().add(this);
	}
	
	public void removeClient(Client client) {
		clients.remove(client);
		client.getBooks().remove(this);
	}
}