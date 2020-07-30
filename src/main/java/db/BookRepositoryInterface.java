package db;

import java.util.ArrayList;
import java.util.List;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Author;
import domain.Book;
import domain.Genre;

@Repository
public interface BookRepositoryInterface extends CrudRepository<Book, Long> {
	
	//@Override
	default Iterable<Book> findAll(Iterable<Author> authorsInterface, Iterable<Genre> genresInterface) {
			
		List <Author> authors = (List<Author>) authorsInterface;
		List<Genre> genres = (List<Genre>) genresInterface;
		
		List<Book> books = new ArrayList<>();
		
		books.add(new Book("Как закалялась сталь", 1938, true, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQuocjZqbeTCT0l4VJGIZc_9VBtA9iOyp6HjA&usqp=CAU", genres.get(0), authors.get(0)));
		books.add(new Book("Маленький принц", 1958, true, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQdS5OdROIedW7Yg6NifgBCOmV9bVWcdCUb6g&usqp=CAU", genres.get(1), authors.get(1)));
		books.add(new Book("Тихий дон", 1948, false, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSgqbXzoa9GQAMuSwNcBUjI_RSq-HnwblwbyA&usqp=CAU\" class=", genres.get(2), authors.get(2)));
		books.add(new Book("Война и мир", 1888, true, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSFBD1YM1DIN7KWPIUdcSY4s8SfOEJyclPNOw&usqp=CAU", genres.get(3), authors.get(3)));
		
		return books;
	}
	
//	@Override
//	default <S extends Book> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	default <S extends Book> Iterable<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	default Optional<Book> findById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	default boolean existsById(Long id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	default Iterable<Book> findAllById(Iterable<Long> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	default long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	default void deleteById(Long id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	default void delete(Book entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	default void deleteAll(Iterable<? extends Book> entities) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	default void deleteAll() {
//		// TODO Auto-generated method stub
//		
//	}
	
}
