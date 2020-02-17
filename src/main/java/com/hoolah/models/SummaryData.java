package com.hoolah.models;

public class SummaryData {
    private int transactionNumber;
    private Double averageTransactionValue;

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Double getAverageTransactionValue() {
        return averageTransactionValue;
    }

    public void setAverageTransactionValue(Double averageTransactionValue) {
        this.averageTransactionValue = averageTransactionValue;
    }

    @Override
    public String toString() {
        return
                "Number of transactions = " + transactionNumber +"\n"+
                "Average Transaction Value = " + averageTransactionValue ;
    }
}
