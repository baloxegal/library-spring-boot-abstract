package com.example.demo.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.BaseEntity;

@Repository
public interface BaseEntityRepositoryInterface <T extends BaseEntity> extends CrudRepository<T, Long> {
	
	@Query("select e from #{#entityName} e where e.name = ?1")
	public Optional<T> findByName(String name);
	
}
