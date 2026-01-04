package com.wareops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Dispatch")
public class Dispatch {

    @Id
    private int dispatchId;    // PK
    private int warehouseId;   // FK
    private int orderId;       // FK to SalesOrder
    private Date dispatchDate;
    private String courier;
    private String trackingNo;
    private Date deliveredDate; // Nullable
    private String status;      // IN_TRANSIT / DELIVERED / FAILED

    public Dispatch() {}

    public Dispatch(int dispatchId, int warehouseId, int orderId, Date dispatchDate, String courier, String trackingNo, Date deliveredDate, String status) {
        this.dispatchId = dispatchId;
        this.warehouseId = warehouseId;
        this.orderId = orderId;
        this.dispatchDate = dispatchDate;
        this.courier = courier;
        this.trackingNo = trackingNo;
        this.deliveredDate = deliveredDate;
        this.status = status;
    }

    // Getters & Setters
    public int getDispatchId() { return dispatchId; }
    public void setDispatchId(int dispatchId) { this.dispatchId = dispatchId; }
    public int getWarehouseId() { return warehouseId; }
    public void setWarehouseId(int warehouseId) { this.warehouseId = warehouseId; }
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public Date getDispatchDate() { return dispatchDate; }
    public void setDispatchDate(Date dispatchDate) { this.dispatchDate = dispatchDate; }
    public String getCourier() { return courier; }
    public void setCourier(String courier) { this.courier = courier; }
    public String getTrackingNo() { return trackingNo; }
    public void setTrackingNo(String trackingNo) { this.trackingNo = trackingNo; }
    public Date getDeliveredDate() { return deliveredDate; }
    public void setDeliveredDate(Date deliveredDate) { this.deliveredDate = deliveredDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
