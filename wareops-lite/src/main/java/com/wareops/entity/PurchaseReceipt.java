package com.wareops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PurchaseReceipt")
public class PurchaseReceipt {

    @Id
    private int receiptId;      // PK
    private int warehouseId;    // FK reference
    private int supplierId;     // FK reference
    private Date receiptDate;
    private String invoiceNo;
    private double totalAmount;

    public PurchaseReceipt() {}

    public PurchaseReceipt(int receiptId, int warehouseId, int supplierId, Date receiptDate, String invoiceNo, double totalAmount) {
        this.receiptId = receiptId;
        this.warehouseId = warehouseId;
        this.supplierId = supplierId;
        this.receiptDate = receiptDate;
        this.invoiceNo = invoiceNo;
        this.totalAmount = totalAmount;
    }

    // Getters & Setters
    public int getReceiptId() { return receiptId; }
    public void setReceiptId(int receiptId) { this.receiptId = receiptId; }
    public int getWarehouseId() { return warehouseId; }
    public void setWarehouseId(int warehouseId) { this.warehouseId = warehouseId; }
    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
    public Date getReceiptDate() { return receiptDate; }
    public void setReceiptDate(Date receiptDate) { this.receiptDate = receiptDate; }
    public String getInvoiceNo() { return invoiceNo; }
    public void setInvoiceNo(String invoiceNo) { this.invoiceNo = invoiceNo; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
