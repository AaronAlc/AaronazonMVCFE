package com.aaronazon.mvcfe.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aaronazon.mvcfe.view.ItemView;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemManagerImpl implements ItemManager {

	private static final Logger logger = LogManager.getLogger(ItemManagerImpl.class);
	private static final String BACKEND_REST_ITEM_URI = "http://localhost:8080/AaronazonRestAPI/item/";
	private static final String DEFAULT_IMAGE_LOC = "items/default.png";

	@Autowired
	private RestTemplate restTemplate;

	public ItemView findById(long id) {
		logger.debug("Find by ID: " + id);
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);

		ResponseEntity<ItemView> resp = restTemplate.getForEntity(BACKEND_REST_ITEM_URI + id, ItemView.class, params);

		return resp.getBody();
	}

	public ItemView findByName(String name) {
		logger.debug("Find by Name: " + name);
		Map<String, String> params = new HashMap<String, String>();
		params.put("itemName", name);
		ResponseEntity<ItemView> resp = restTemplate.getForEntity(BACKEND_REST_ITEM_URI, ItemView.class, params);
		//ItemDTO currentItem = findAllItems().stream().filter(item -> item.getItemName().equalsIgnoreCase(name))
		//		.findAny().orElse(null);
		return resp.getBody();
	}

	public ItemView saveItem(ItemView item) {
		if(item.getImageLoc() == null || item.getImageLoc().equals("")) {
			item.setImageLoc(DEFAULT_IMAGE_LOC);
		}
		HttpEntity<ItemView> entity = new HttpEntity<>(item);
		ItemView currentItem = restTemplate.postForEntity(BACKEND_REST_ITEM_URI, entity, ItemView.class).getBody();
		return currentItem;
	}

	public ItemView updateItem(ItemView item) {
		HttpEntity<ItemView> entity = new HttpEntity<ItemView>(item);
		logger.debug("Updating item " + item + " id " + item.getId());
		restTemplate.put(BACKEND_REST_ITEM_URI + item.getId(), entity);
		return item;
	}

	public boolean deleteItemById(long id) {
		System.out.println("Manager id: " + id);
		restTemplate.delete(BACKEND_REST_ITEM_URI + id);
		return true;
	}

	public List<ItemView> findAllItems() {
		ResponseEntity<List<ItemView>> resp = restTemplate.exchange(BACKEND_REST_ITEM_URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ItemView>>() {
				});
		logger.debug("Find all Items BODY: " + resp.getBody());
		return resp.getBody();
	}

	public boolean isItemExists(ItemView item) {
		return findByName(item.getItemName()) != null;
	}

}
