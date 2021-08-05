package com.vmart.inventory.inventoryREST;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {


	 @Autowired
	 private CustomerService custservice;
	 
	 
	 @GetMapping("/customers")
	 public List<Customer> list() {
		 return custservice.listCust();
	 }
	 
	 @GetMapping("/customers/{id}")
     public ResponseEntity<Customer> get (@PathVariable Integer id){
       
		 try {
		 Customer customer = custservice.get(id);
		 return new ResponseEntity<Customer>(customer,HttpStatus.OK);
        } catch (NoSuchElementException e) {
        	return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
          
         }
        
	 }
	 
	 @PostMapping("/customers")
	 public void add(@RequestBody Customer customer) {
		 custservice.save(customer);
	 }
	 
	 
	 @PutMapping("/customers/{id}")
	 public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id) {
		 
		 try {
		 Customer existCustomer = custservice.get(id);
		 custservice.save(customer);
		 return new ResponseEntity<>(HttpStatus.OK);
		 } catch (NoSuchElementException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }


}
