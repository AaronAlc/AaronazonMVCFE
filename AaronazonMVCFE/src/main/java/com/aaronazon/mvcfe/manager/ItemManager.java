package com.aaronazon.mvcfe.manager;

import java.util.List;

import com.aaronazon.mvcfe.view.ItemView;

public interface ItemManager {
	ItemView findById(long id);

	ItemView findByName(String name);

	ItemView saveItem(ItemView item);

	ItemView updateItem(ItemView item);

	boolean deleteItemById(long id);

	List<ItemView> findAllItems();

	boolean isItemExists(ItemView item);

}
