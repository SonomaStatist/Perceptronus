package com.gilljanssen.perceptronus;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataParser {

    List<String[]> TTTData;
    List<String[]> CancerData;
    List<String[]> TestTTTData;
    List<String[]> TestCancerData;

    public DataParser () {
        try {
            CSVReader reader = new CSVReader(new FileReader("data/tictactoe.data"));
            TTTData = reader.readAll();

            reader = new CSVReader(new FileReader("data/cancer.data"));
            CancerData = reader.readAll();

            Random random = new Random();
            TestTTTData = new ArrayList<String[]>();
            TestCancerData = new ArrayList<String[]>();

            for (int i = (int)(TTTData.size() * 0.1); i > 0; i--)
                TestTTTData.add(TTTData.remove(random.nextInt(TTTData.size())));

            for (int i = (int)(CancerData.size() * 0.1); i > 0; i--)
                TestCancerData.add(CancerData.remove(random.nextInt(CancerData.size())));

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("IOException.");
        }
    }
}
