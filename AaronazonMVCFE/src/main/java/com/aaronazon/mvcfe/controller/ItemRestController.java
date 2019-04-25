package com.aaronazon.mvcfe.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aaronazon.mvcfe.dto.ItemDTO;
import com.aaronazon.mvcfe.manager.ItemManager;

@RestController
@RequestMapping("item")
public class ItemRestController {
	
	private static Logger logger = LogManager.getLogger(ItemRestController.class);

	@Autowired
	private ItemManager itemManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ItemDTO>> listAllItems(){
		List<ItemDTO> items = itemManager.findAllItems();
		logger.debug("Item list " + items);
		if(items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ItemDTO> deleteItem(@PathVariable("id") long id){
		boolean isDeleted = itemManager.deleteItemById(id);
		if(!isDeleted) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<ItemDTO> getItem(@PathVariable("id") long id, @RequestBody ItemDTO item){
		ItemDTO currentItem = itemManager.findById(id);
		if(currentItem == null) {
			return new ResponseEntity<>(currentItem, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(currentItem, HttpStatus.OK);
	}
	
	@RequestMapping(value="{name}", method=RequestMethod.GET)
	public ResponseEntity<ItemDTO> getItem(@PathVariable("name") String name){
		ItemDTO currentItem = itemManager.findByName(name);
		if(currentItem == null) {
			return new ResponseEntity<>(currentItem, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(currentItem, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO item){
		ItemDTO createdItem = itemManager.saveItem(item);
		return new ResponseEntity<ItemDTO>(createdItem, HttpStatus.OK);
	}

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public ResponseEntity<ItemDTO> updateItem(@PathVariable("id") long id, @RequestBody ItemDTO item){
		logger.debug("Updating item " + id);
		ItemDTO currentItem = null;
		currentItem = itemManager.findById(id);
		if(currentItem == null) {
			logger.error("Item with id " + id + " is not found");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		ItemDTO updatedItem = itemManager.updateItem(item);
		return new ResponseEntity<>(updatedItem, HttpStatus.OK);
	}
		
}