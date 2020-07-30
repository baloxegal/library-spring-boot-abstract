package db;

import java.util.ArrayList;
import java.util.List;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Genre;

@Repository
public interface GenreRepositoryInterface extends CrudRepository<Genre, Long>  {

	@Override
	default Iterable<Genre> findAll() {
		
		List<Genre> genres = new ArrayList<>();
		
		genres.add(new Genre("Революционное мясо"));
		genres.add(new Genre("Для покурить"));
		genres.add(new Genre("Революция Мексикана"));
		genres.add(new Genre("Мясо по французки"));
		
		return genres;
	}
	
//	@Override
//	default <S extends Genre> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	default <S extends Genre> Iterable<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	default Optional<Genre> findById(Long id) {
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
//	
//
//	@Override
//	default Iterable<Genre> findAllById(Iterable<Long> ids) {
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
//	default void delete(Genre entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	default void deleteAll(Iterable<? extends Genre> entities) {
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
