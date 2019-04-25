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

import org.springframework.transaction.annotation.Transactional;

import com.aaronazon.mvcfe.dto.ItemDTO;

@Service
@Transactional
public class ItemManagerImpl implements ItemManager {

	private static final Logger logger = LogManager.getLogger(ItemManagerImpl.class);
	private static final String BACKEND_REST_ITEM_URI = "http://localhost:8080/AaronazonRestAPI/item/";

	@Autowired
	private RestTemplate restTemplate;

	public ItemDTO findById(long id) {
		logger.debug("Find by ID: " + id);
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);

		ResponseEntity<ItemDTO> resp = restTemplate.getForEntity(BACKEND_REST_ITEM_URI + id, ItemDTO.class, params);

		return resp.getBody();
	}

	public ItemDTO findByName(String name) {
		logger.debug("Find by Name: " + name);
		Map<String, String> params = new HashMap<String, String>();
		params.put("itemName", name);
		ResponseEntity<ItemDTO> resp = restTemplate.getForEntity(BACKEND_REST_ITEM_URI, ItemDTO.class, params);
		//ItemDTO currentItem = findAllItems().stream().filter(item -> item.getItemName().equalsIgnoreCase(name))
		//		.findAny().orElse(null);
		return resp.getBody();
	}

	public ItemDTO saveItem(ItemDTO item) {
		HttpEntity<ItemDTO> entity = new HttpEntity<ItemDTO>(item);
		ItemDTO currentItem = restTemplate.postForEntity(BACKEND_REST_ITEM_URI, entity, ItemDTO.class).getBody();
		return currentItem;
	}

	public ItemDTO updateItem(ItemDTO item) {
		HttpEntity<ItemDTO> entity = new HttpEntity<ItemDTO>(item);
		restTemplate.put(BACKEND_REST_ITEM_URI + item.getId(), entity);
		return item;
	}

	public boolean deleteItemById(long id) {
		System.out.println("Manager id: " + id);
		restTemplate.delete(BACKEND_REST_ITEM_URI + id);
		//need to ask how to check if it's deleted
		//ItemDTO item = findById(id);
		//if (item == null) {
		//	return false;
		//}
		return true;
	}

	public List<ItemDTO> findAllItems() {
		ResponseEntity<List<ItemDTO>> resp = restTemplate.exchange(BACKEND_REST_ITEM_URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ItemDTO>>() {
				});
		logger.debug("Find all Items BODY: " + resp.getBody());
		return resp.getBody();
	}

	public boolean isItemExists(ItemDTO item) {
		return findByName(item.getItemName()) != null;
	}

}
