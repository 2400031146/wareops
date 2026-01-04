package com.wareops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bin")
public class Bin {

    @Id
    private int binId;          // PK
    private int warehouseId;    // FK reference to Warehouse (numeric only)
    private String code;
    private String zone;
    private int capacity;
    private String status;      // ACTIVE / INACTIVE

    public Bin() {}

    public Bin(int binId, int warehouseId, String code, String zone, int capacity, String status) {
        this.binId = binId;
        this.warehouseId = warehouseId;
        this.code = code;
        this.zone = zone;
        this.capacity = capacity;
        this.status = status;
    }

    // Getters & Setters
    public int getBinId() { return binId; }
    public void setBinId(int binId) { this.binId = binId; }
    public int getWarehouseId() { return warehouseId; }
    public void setWarehouseId(int warehouseId) { this.warehouseId = warehouseId; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
