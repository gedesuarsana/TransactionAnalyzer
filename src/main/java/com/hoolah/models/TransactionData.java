package com.hoolah.models;

import java.sql.Timestamp;

public class TransactionData {
    private String id;
    private Timestamp date;
    private Double amount;
    private String merchant;
    private String type;
    private String relatedTransaction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.trim();
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type.trim();
    }

    public String getRelatedTransaction() {
        return relatedTransaction;
    }

    public void setRelatedTransaction(String relatedTransaction) {
        this.relatedTransaction = relatedTransaction.trim();
    }

    @Override
    public String toString() {
        return "TransactionData{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", merchant='" + merchant + '\'' +
                ", type='" + type + '\'' +
                ", relatedTransaction='" + relatedTransaction + '\'' +
                '}';
    }
}
