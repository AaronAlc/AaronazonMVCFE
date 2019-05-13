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

import com.aaronazon.mvcfe.manager.ItemManager;
import com.aaronazon.mvcfe.view.ItemView;

@RestController
@RequestMapping("item")
public class ItemRestController {
	
	private static Logger logger = LogManager.getLogger(ItemRestController.class);

	@Autowired
	private ItemManager itemManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ItemView>> listAllItems(){
		List<ItemView> items = itemManager.findAllItems();
		logger.debug("Item list " + items);
		if(items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ItemView> deleteItem(@PathVariable("id") long id){
		boolean isDeleted = itemManager.deleteItemById(id);
		if(!isDeleted) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<ItemView> getItem(@PathVariable("id") long id, @RequestBody ItemView item){
		ItemView currentItem = itemManager.findById(id);
		if(currentItem == null) {
			return new ResponseEntity<>(currentItem, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(currentItem, HttpStatus.OK);
	}
	
	@RequestMapping(value="{name}", method=RequestMethod.GET)
	public ResponseEntity<ItemView> getItem(@PathVariable("name") String name){
		ItemView currentItem = itemManager.findByName(name);
		if(currentItem == null) {
			return new ResponseEntity<>(currentItem, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(currentItem, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<ItemView> createItem(@RequestBody ItemView item){
		logger.debug("Creating item " + item);
		ItemView createdItem = itemManager.saveItem(item);
		if(createdItem == null) {
			return new ResponseEntity<>(createdItem, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ItemView>(createdItem, HttpStatus.OK);
	}

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public ResponseEntity<ItemView> updateItem(@PathVariable("id") long id, @RequestBody ItemView item){
		logger.debug("Updating item " + id);
		ItemView updatedItem = itemManager.updateItem(item);
		return new ResponseEntity<>(updatedItem, HttpStatus.OK);
	}
		
}