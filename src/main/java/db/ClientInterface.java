package db;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Client;

@Repository
public interface ClientInterface extends CrudRepository<Client, Long>  {

	@Override
	default Iterable<Client> findAll() {
		return null;
	}
	
//	@Override
//	default <S extends Client> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	default <S extends Client> Iterable<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	default Optional<Client> findById(Long id) {
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
//	default Iterable<Client> findAllById(Iterable<Long> ids) {
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
//	default void delete(Client entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	default void deleteAll(Iterable<? extends Client> entities) {
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
