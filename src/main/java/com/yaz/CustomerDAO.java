package com.yaz;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer, Integer>{
	
}
