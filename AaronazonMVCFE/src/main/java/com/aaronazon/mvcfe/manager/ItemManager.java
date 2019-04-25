package com.aaronazon.mvcfe.manager;

import java.util.List;

import com.aaronazon.mvcfe.dto.ItemDTO;

public interface ItemManager {
	ItemDTO findById(long id);

	ItemDTO findByName(String name);

	ItemDTO saveItem(ItemDTO item);

	ItemDTO updateItem(ItemDTO item);

	boolean deleteItemById(long id);

	List<ItemDTO> findAllItems();

	boolean isItemExists(ItemDTO item);

}
