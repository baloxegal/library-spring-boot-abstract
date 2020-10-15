package com.example.demo.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.BaseEntity;

@Repository
public interface BaseEntityRepositoryInterface <E extends BaseEntity> extends CrudRepository<E, Long> {

}
