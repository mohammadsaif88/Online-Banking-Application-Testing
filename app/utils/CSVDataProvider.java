package com.example.onlinebanking.utils;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVDataProvider {
    @DataProvider(name="transferData")
    public static Iterator<Object[]> getTransferData() throws Exception {
        String path = System.getProperty("user.dir") + "/data/transfer_data.csv";
        CSVReader reader = new CSVReader(new FileReader(path));
        List<Object[]> list = new ArrayList<>();
        String[] next;
        reader.readNext(); // header
        while((next=reader.readNext()) != null){
            list.add(new Object[]{ next[0], next[1], next[2] }); // toAccount, amount, expectedMsg
        }
        reader.close();
        return list.iterator();
    }
}
