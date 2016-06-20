package com.example.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

public interface PricesListDao extends CrudRepository<PricesList, Long>{
		
	@Transactional
	public PricesList findByIdSap(Integer idSap);
	

}
