package com.hoolah.services;

import com.hoolah.TransactionAnalyzer;
import com.hoolah.adapters.CSVReader;
import com.hoolah.adapters.impl.CSVReaderPlainImpl;
import com.hoolah.models.SummaryData;
import com.hoolah.models.TransactionData;
import com.hoolah.services.impl.TransactionAnalyzerImpl;
import com.hoolah.util.Util;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class TransactionAnalyzerServiceTest {

    @Test
    public void transactionAnalyerService_summaryData1_Test(){

        TransactionAnalyzerService ta = new TransactionAnalyzerImpl();
        String pathFile = getClass().getClassLoader().getResource("InputData.csv").getPath();
        try {
                       SummaryData result =  ta.calculateSummary(pathFile,"20/08/2018 12:00:00","20/08/2018 13:00:00","Kwik-E-Mart");
                       Assert.assertNotNull(result);
                       Assert.assertTrue(result.getTransactionNumber()==1);
                       Assert.assertTrue(result.getAverageTransactionValue()==59.99);
                       System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
