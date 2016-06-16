package com.example.model;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

public interface PricesListDao extends CrudRepository<PricesList, Long>{
		
	@Transactional
	public PricesList findByIdSap(Integer idSap);
	
//	@Transactional
//	public Collection<PricesList> findAll();
}
