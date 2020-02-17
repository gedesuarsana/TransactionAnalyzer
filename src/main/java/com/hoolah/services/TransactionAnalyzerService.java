package com.hoolah.services;

import com.hoolah.models.SummaryData;

import java.sql.Timestamp;

public interface TransactionAnalyzerService {
    public SummaryData calculateSummary(String filePath,String fromDate, String toDate, String merchant);
}
