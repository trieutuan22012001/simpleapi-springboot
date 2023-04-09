package com.singleapi;

import com.singleapi.Repository.CustomerRepository;
import com.singleapi.model.Customer;
import com.singleapi.model.ResponseObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@SpringBootApplication
@RequestMapping("api/v1/customers")
@RestController

public class Main {
    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
    @GetMapping
    public List<Customer> getCutomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id){
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        return foundCustomer.isPresent() ?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query Customer Successfully", foundCustomer)
            ):
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed","cannot find customer with id = " + id, "")
                );
    }
}
