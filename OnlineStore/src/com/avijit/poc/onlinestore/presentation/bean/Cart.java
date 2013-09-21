package com.avijit.poc.onlinestore.presentation.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.avijit.poc.onlinestore.business.entity.Part;

public class Cart {
	private final Map<String, CartItem> itemMap = Collections
			.synchronizedMap(new HashMap<String, CartItem>());

	public void addItem(Part part, int qty) {
		CartItem cartItem = (CartItem) itemMap.get(part.getModelNumber());
		if (cartItem == null) {
			cartItem = new CartItem();
			cartItem.setPart(part);
			cartItem.setQuantity(qty);
			itemMap.put(Long.toString(part.getId()), cartItem);
		} else {
			cartItem.incrementQuantity();
		}
	}

	public CartItem getCartItem(String key) {
		return (CartItem) itemMap.get(key);
	}

	public Part removeItemById(String itemId) {
		CartItem cartItem = (CartItem) itemMap.remove(itemId);
		if (cartItem == null) {
			return null;
		} else {
			return cartItem.getPart();
		}
	}

	public void removeAll() {
		itemMap.clear();
	}

	public void incrementQuantityByItemId(String itemId) {
		CartItem cartItem = (CartItem) itemMap.get(itemId);
		cartItem.incrementQuantity();
	}

	public void setQuantityByItemId(String itemId, int quantity) {
		CartItem cartItem = (CartItem) itemMap.get(itemId);
		cartItem.setQuantity(quantity);
	}

	public List<CartItem> getCartItems() {
		List<CartItem> cartItemList = new ArrayList<CartItem>();
		Iterator<CartItem> iterator = itemMap.values().iterator();
		while (iterator.hasNext()) {
			cartItemList.add(iterator.next());
		}

		return cartItemList;
	}

	public double getLineItemsTotal() {
		Part part;
		int quantity;
		double listPrice;
		double subTotal = 0;

		List<CartItem> cartItems = getCartItems();

		for (CartItem cartItem : cartItems) {
			part = cartItem.getPart();
			listPrice = part.getUnitPrice();
			quantity = cartItem.getQuantity();
			subTotal += listPrice * quantity;
		}

		return subTotal;
	}

	public boolean isCartEmpty() {
		return itemMap.isEmpty();
	}
}
