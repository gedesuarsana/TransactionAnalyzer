package com.hoolah.validators;

import com.hoolah.util.Util;

import java.io.File;
import java.sql.Time;
import java.sql.Timestamp;

public class InputValidator {
    public static boolean validate(String args[]){
        boolean output = true;
        if(args.length!=4){
            output=false;
        }

        if(args.length==4){
            File file = new File(args[0]);
            if(!file.exists()){
                output =false;
            }
            try{
               Timestamp fromDate = Util.convertStringToTimestamp(args[1]);
                Timestamp toDate = Util.convertStringToTimestamp(args[2]);
                if(toDate.getTime()<fromDate.getTime()){
                    output =false;
                }
            }catch (Exception e){
                output =false;
                return output;
            }
        }

        return output;
    }
}
