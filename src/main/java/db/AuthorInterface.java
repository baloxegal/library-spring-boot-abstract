package db;

import java.util.ArrayList;
import java.util.List;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Author;

@Repository
public interface AuthorInterface extends CrudRepository<Author, Long> {
    
	@Override
	default Iterable<Author> findAll() {
		
		List <Author> authors = new ArrayList<>();
		
		authors.add(new Author("Николай Островский"));
		authors.add(new Author("Антуан де Сент-Экзюпери"));
		authors.add(new Author("Михаил Шолохов"));
		authors.add(new Author("Лев Толстой"));
		
		return authors;
	}
	
//	@Override
//	default <S extends Author> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	default <S extends Author> Iterable<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	default Optional<Author> findById(Long id) {
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
//	default Iterable<Author> findAllById(Iterable<Long> ids) {
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
//	default void delete(Author entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	default void deleteAll(Iterable<? extends Author> entities) {
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
