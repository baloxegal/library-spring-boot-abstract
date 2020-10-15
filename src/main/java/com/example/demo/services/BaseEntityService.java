package com.example.demo.services;

import java.util.Optional;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.example.demo.db.BaseEntityRepositoryInterface;
import com.example.demo.domain.BaseEntity;

@Service
public class BaseEntityService {

	public BaseEntityService() {
	}
		
	@Inject
	private BaseEntityRepositoryInterface<? extends BaseEntity> baseEntityRepository;
		
	public Iterable<? extends BaseEntity> findAll(String entities){
				
		return baseEntityRepository.findAll();
	}
		
	public Optional<? extends BaseEntity> findById(Long baseEntityId){
		
		return baseEntityRepository.findById(baseEntityId);
	}
	
//	public void save(BaseEntity baseEntity){
//		
//		baseEntityRepository.save(baseEntity);
//	}
	
}
