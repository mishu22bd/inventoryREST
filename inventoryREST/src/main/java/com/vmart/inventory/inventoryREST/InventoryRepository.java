package com.vmart.inventory.inventoryREST;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	
	

}
