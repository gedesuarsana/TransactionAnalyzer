package com.hoolah.adapters.impl;

import com.hoolah.adapters.CSVReader;
import com.hoolah.models.TransactionData;
import com.hoolah.util.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class CSVReaderPlainImpl implements CSVReader {


    public Map<String, TransactionData> readAll(String filePath) throws FileNotFoundException, IOException, ParseException {
        Map<String,TransactionData> output = new HashMap<String,TransactionData>();
        BufferedReader bf = new BufferedReader(new FileReader(filePath));
        //ignoring header
        String line = bf.readLine();
        while((line=bf.readLine())!=null && !line.isEmpty() ) {
            TransactionData data = new TransactionData();
            String fields[] = line.split(",");
            data.setId(fields[0]);
            data.setDate(Util.convertStringToTimestamp(fields[1]));
            data.setAmount(Double.parseDouble(fields[2]));
            data.setMerchant(fields[3]);
            data.setType(fields[4]);

            if(fields.length>5) {
                data.setRelatedTransaction(fields[5]);
            }

            output.put(fields[0],data);
        }
        return  output;
    }






}
