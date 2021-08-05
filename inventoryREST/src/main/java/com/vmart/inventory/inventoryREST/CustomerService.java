package com.vmart.inventory.inventoryREST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerService {
  
   
    @Autowired
	private CustomerRepository custrepo;

	
    public List<Customer> listCust() {
		
		return custrepo.findAll();
	}
  public void save (Customer customer) {

    custrepo.save(customer);
 
  }

   public Customer get(Integer id) {
	return custrepo.findById(id).get();
		
}

  public void delete(Integer id) {
	custrepo.deleteById(id);
	
}


}
