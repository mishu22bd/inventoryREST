package com.vmart.inventory.inventoryREST;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
	
	@Autowired
	private InventoryService service;
	
	
	@GetMapping("/inventory")
	public List<Inventory> list() {
		return service.ListAll();
		
	}
	
	@GetMapping("/inventory/{id}")
	public ResponseEntity<Inventory> get(@PathVariable Integer id) {
		try {
	   Inventory inventory = service.get(id);
	   return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			 return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
		}
		
	}

	@PostMapping("/inventory")
	public void add(@RequestBody Inventory inventory) {
		service.save(inventory);
	}
	
	@PutMapping("/inventory/{id}")
	public ResponseEntity<?> update(@RequestBody Inventory inventory, @PathVariable Integer id) {
		
		try {
		Inventory exisInventory = service.get(id);
		service.save(inventory);
		    return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/inventory/{id}")
	
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
}
