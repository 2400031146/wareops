package com.wareops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "StockLedger")
public class StockLedger {

    @Id
    private int ledgerId;      // PK
    private int warehouseId;   // FK
    private int productId;     // FK
    private Date movementDate;
    private String movementType; // IN / OUT / ADJUST
    private int qty;
    private String refType;     // RECEIPT / ORDER / RETURN
    private int refId;          // Reference ID

    public StockLedger() {}

    public StockLedger(int ledgerId, int warehouseId, int productId, Date movementDate, String movementType, int qty, String refType, int refId) {
        this.ledgerId = ledgerId;
        this.warehouseId = warehouseId;
        this.productId = productId;
        this.movementDate = movementDate;
        this.movementType = movementType;
        this.qty = qty;
        this.refType = refType;
        this.refId = refId;
    }

    // Getters & Setters
    public int getLedgerId() { return ledgerId; }
    public void setLedgerId(int ledgerId) { this.ledgerId = ledgerId; }
    public int getWarehouseId() { return warehouseId; }
    public void setWarehouseId(int warehouseId) { this.warehouseId = warehouseId; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public Date getMovementDate() { return movementDate; }
    public void setMovementDate(Date movementDate) { this.movementDate = movementDate; }
    public String getMovementType() { return movementType; }
    public void setMovementType(String movementType) { this.movementType = movementType; }
    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }
    public String getRefType() { return refType; }
    public void setRefType(String refType) { this.refType = refType; }
    public int getRefId() { return refId; }
    public void setRefId(int refId) { this.refId = refId; }
}
