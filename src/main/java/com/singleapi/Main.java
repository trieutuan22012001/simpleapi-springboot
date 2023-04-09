package com.singleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
}
