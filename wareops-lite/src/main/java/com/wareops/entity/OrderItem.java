package com.wareops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderItem")
public class OrderItem {

    @Id
    private int orderItemId;  // PK
    private int orderId;       // FK to SalesOrder
    private int productId;     // FK to Product
    private int qty;
    private double sellingPrice;

    public OrderItem() {}

    public OrderItem(int orderItemId, int orderId, int productId, int qty, double sellingPrice) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.productId = productId;
        this.qty = qty;
        this.sellingPrice = sellingPrice;
    }

    // Getters & Setters
    public int getOrderItemId() { return orderItemId; }
    public void setOrderItemId(int orderItemId) { this.orderItemId = orderItemId; }
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }
    public double getSellingPrice() { return sellingPrice; }
    public void setSellingPrice(double sellingPrice) { this.sellingPrice = sellingPrice; }
}
