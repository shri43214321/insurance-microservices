package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	 @Query("SELECT a FROM Address a WHERE a.id = :id")
	    Address findAddressById(@Param("id") Long id);
}

