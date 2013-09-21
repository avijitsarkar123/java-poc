package com.avijit.poc.onlinestore.presentation.bean;

import com.avijit.poc.onlinestore.business.entity.Part;

public class CartItem {
    private String cartItemId;
    private Part part;
    private int quantity;
    private double totalPrice;

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        if (part != null) {
            totalPrice = part.getUnitPrice() * quantity;
            return totalPrice;
        } else {
            return 0;
        }
    }

    public double getUnitPrice() {
        if (part != null) {
            return part.getUnitPrice();
        } else {
            return 0;
        }
    }

    public void incrementQuantity() {
        quantity++;
    }

}
