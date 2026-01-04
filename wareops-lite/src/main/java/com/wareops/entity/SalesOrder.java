package com.wareops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "SalesOrder")
public class SalesOrder {

    @Id
    private int orderId;       // PK
    private int warehouseId;   // FK
    private int customerId;    // FK
    private Date orderDate;
    private Date promisedDate;
    private String status;     // NEW / PACKED / DISPATCHED / CANCELLED

    public SalesOrder() {}

    public SalesOrder(int orderId, int warehouseId, int customerId, Date orderDate, Date promisedDate, String status) {
        this.orderId = orderId;
        this.warehouseId = warehouseId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.promisedDate = promisedDate;
        this.status = status;
    }

    // Getters & Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public int getWarehouseId() { return warehouseId; }
    public void setWarehouseId(int warehouseId) { this.warehouseId = warehouseId; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
    public Date getPromisedDate() { return promisedDate; }
    public void setPromisedDate(Date promisedDate) { this.promisedDate = promisedDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
