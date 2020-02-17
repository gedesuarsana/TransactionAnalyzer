package com.hoolah.services.impl;


import com.hoolah.adapters.CSVReader;
import com.hoolah.adapters.impl.CSVReaderPlainImpl;
import com.hoolah.models.SummaryData;
import com.hoolah.models.TransactionData;
import com.hoolah.services.TransactionAnalyzerService;
import com.hoolah.util.Util;
import java.sql.Timestamp;
import java.util.*;

public class TransactionAnalyzerImpl implements TransactionAnalyzerService {

    private CSVReader csvReader = new CSVReaderPlainImpl();

    public SummaryData calculateSummary(String filePath,String fromDateStr, String toDateStr, String merchant){

        SummaryData output = new SummaryData();
        try {
            Timestamp fromDate = Util.convertStringToTimestamp(fromDateStr);
            Timestamp toDate = Util.convertStringToTimestamp(toDateStr);

            Map<String, TransactionData> allRecords= csvReader.readAll(filePath);
            allRecords = sortRecordByDate(allRecords);
            Map<String,TransactionData> purifiedRecords=removingAllReversalRecords(allRecords);

            int transactionNumber=0;
            Double averageValue= new Double(0.0);
            Double totalValue= new Double(0.0);

            for(String transactionId: purifiedRecords.keySet()){
                TransactionData data = allRecords.get(transactionId);
                Timestamp dataTimestamp =data.getDate();
                if((fromDate.getTime()<=dataTimestamp.getTime()) && (dataTimestamp.getTime()<=toDate.getTime()) && merchant.equalsIgnoreCase(data.getMerchant())) {
                    totalValue = totalValue + data.getAmount();
                    transactionNumber++;
                }
            }
            averageValue = totalValue/transactionNumber;
            output.setTransactionNumber(transactionNumber);
            output.setAverageTransactionValue(averageValue);

        } catch (Exception e) {
            e.printStackTrace();
            return output;
        }
        return output;
    }

    private Map<String, TransactionData> sortRecordByDate(Map<String, TransactionData> allRecords){
        Map<String, TransactionData> output = new LinkedHashMap<String, TransactionData>();
        List<Map.Entry<String, TransactionData>> list = new LinkedList<Map.Entry<String, TransactionData>>(allRecords.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, TransactionData>>() {
            public int compare(Map.Entry<String, TransactionData> o1,
                               Map.Entry<String, TransactionData> o2) {
                TransactionData td1 = o1.getValue();
                TransactionData td2 = o2.getValue();
                int output =0;
                if(td1.getDate().getTime() > td2.getDate().getTime()){
                    output=1;
                }else if(td1.getDate().getTime() < td2.getDate().getTime()){
                    output =-1;
                }
                return output;
            }
        });

        for (Map.Entry<String, TransactionData> entry : list) {
            output.put(entry.getKey(), entry.getValue());
        }

        return output;
    }

    private Map<String, TransactionData> removingAllReversalRecords(Map<String, TransactionData> allRecords){
        Map<String, TransactionData> output = new HashMap<String, TransactionData>();
        for(String transactionId: allRecords.keySet()){
          TransactionData data = allRecords.get(transactionId);
            if(data!=null){
                if(data.getRelatedTransaction()!=null && !data.getRelatedTransaction().isEmpty()){
                    output.remove(data.getRelatedTransaction());
                }else{
                    output.put(transactionId,data);
                }
            }
        }
        return output;
    }


}
