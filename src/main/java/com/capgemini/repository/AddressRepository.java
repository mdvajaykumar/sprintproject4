package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entites.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	
}
