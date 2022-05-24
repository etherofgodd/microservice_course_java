package com.etherofgodd.customerdal.repositories;

import com.etherofgodd.customerdal.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
