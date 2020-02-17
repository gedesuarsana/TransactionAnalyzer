package com.hoolah;

import com.hoolah.models.SummaryData;
import com.hoolah.services.TransactionAnalyzerService;
import com.hoolah.services.impl.TransactionAnalyzerImpl;
import com.hoolah.validators.InputValidator;

public class TransactionAnalyzer {


    public static void main(String args[]){
       boolean isValid = InputValidator.validate(args);
       if(isValid){

               TransactionAnalyzerService ta = new TransactionAnalyzerImpl();
               SummaryData  summary = ta.calculateSummary(args[0],args[1],args[2],args[3]);
               System.out.println(summary);

       }else{
           System.out.println("Input Is Not valid!!!!");
       }
    }


}
