package com.vmart.inventory.inventoryREST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inv;

    
	public List<Inventory> ListAll() {
       return inv.findAll();		
		
	}
	
   public void save(Inventory inventory) {
   		inv.save(inventory);

   	}
   
 public Inventory get(Integer id) {
	 return inv.findById(id).get();
	 	 
    }
 
 public void delete(Integer id) {
	 inv.deleteById(id);
	 
   }
   
   
   
}
