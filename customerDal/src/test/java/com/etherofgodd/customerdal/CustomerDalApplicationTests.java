package com.etherofgodd.customerdal;

import com.etherofgodd.customerdal.entities.Customer;
import com.etherofgodd.customerdal.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerDalApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer();

        customer.setEmail("deadGuy@slack.com");
        customer.setName("Dead Guy");

        customerRepository.save(customer);
    }

    @Test
    void testFindCustomerById() {
        Customer customer = customerRepository.findById(1L).get();
        System.out.println(customer);
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = customerRepository.findById(1L).get();
        customer.setName("Maybe Alive");
        customer.setEmail("aliveGuy@slack.com");

        customerRepository.save(customer);
    }

    @Test
    void testDeleteCustomer(){
        customerRepository.deleteById(1L);
    }


}
