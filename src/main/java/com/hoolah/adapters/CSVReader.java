package com.hoolah.adapters;

import com.hoolah.models.TransactionData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

public interface CSVReader {
 public Map<String, TransactionData> readAll(String filePath) throws FileNotFoundException, IOException, ParseException;
}
