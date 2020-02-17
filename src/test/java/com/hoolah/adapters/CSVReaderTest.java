package com.hoolah.adapters;

import com.hoolah.adapters.impl.CSVReaderPlainImpl;
import com.hoolah.models.TransactionData;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CSVReaderTest {

@Test
public void csvReader_readAllData_Test(){
    CSVReader reader = new CSVReaderPlainImpl();
    String pathFile = getClass().getClassLoader().getResource("InputData.csv").getPath();
    try {
        Map<String, TransactionData> records = reader.readAll(pathFile);
        Assert.assertTrue("Record number must be greater than 0 !",records.size()>0);
    } catch (Exception e) {
        e.printStackTrace();
    }
}


}
