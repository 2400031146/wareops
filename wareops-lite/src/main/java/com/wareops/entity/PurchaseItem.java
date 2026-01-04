package com.wareops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PurchaseItem")
public class PurchaseItem {

    @Id
    private int purchaseItemId; // PK
    private int receiptId;      // FK to PurchaseReceipt
    private int productId;      // FK to Product
    private int qty;
    private double unitCost;

    public PurchaseItem() {}

    public PurchaseItem(int purchaseItemId, int receiptId, int productId, int qty, double unitCost) {
        this.purchaseItemId = purchaseItemId;
        this.receiptId = receiptId;
        this.productId = productId;
        this.qty = qty;
        this.unitCost = unitCost;
    }

    // Getters & Setters
    public int getPurchaseItemId() { return purchaseItemId; }
    public void setPurchaseItemId(int purchaseItemId) { this.purchaseItemId = purchaseItemId; }
    public int getReceiptId() { return receiptId; }
    public void setReceiptId(int receiptId) { this.receiptId = receiptId; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }
    public double getUnitCost() { return unitCost; }
    public void setUnitCost(double unitCost) { this.unitCost = unitCost; }
}
