package com.aaronazon.mvcfe.view;

public class ItemView{

	private long id;
	
	private String itemName;

	private String description;
	
	private String imageLoc;

	public ItemView() {}
	
	public ItemView(Item item) {
		this.id = item.getId();
		this.itemName = item.getItemName();
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getImageLoc() {
		return imageLoc;
	}

	public void setImageLoc(String imageLoc) {
		this.imageLoc = imageLoc;
	}

	@Override
	public String toString() {
		return "ItemName: " + this.itemName + " ID: " + this.id +
				" Description: " + this.description;
	}
	
}