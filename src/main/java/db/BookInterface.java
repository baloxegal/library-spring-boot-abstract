package db;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Book;

@Repository
public interface BookInterface extends CrudRepository<Book, Long>  {

	@Override
	default Iterable<Book> findAll() {
		return null;
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
