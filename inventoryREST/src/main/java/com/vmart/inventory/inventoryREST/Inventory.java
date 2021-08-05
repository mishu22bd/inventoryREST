package com.vmart.inventory.inventoryREST;


public class Inventory {
	private Integer id;
	private String name;
	private float price;
	private String full_description;
	private byte[] main_image;
	
	
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(Integer id, String name, float price, String full_description, byte[] main_image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.full_description = full_description;
		this.main_image = main_image;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getFull_description() {
		return full_description;
	}
	public void setFull_description(String full_description) {
		this.full_description = full_description;
	}
	public byte[] getMain_image() {
		return main_image;
	}
	public void setMain_image(byte[] main_image) {
		this.main_image = main_image;
	}


}