package com.gilljanssen.perceptronus;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String[]> TTTData;
        List<String[]> CancerData;

        try {
            CSVReader reader = new CSVReader(new FileReader("data/tictactoe.data"));
            TTTData = reader.readAll();

            reader = new CSVReader(new FileReader("data/cancer.data"));
            CancerData = reader.readAll();

            for (int i = 0; i < TTTData.size(); i++) {

                System.out.print("TTT " + (i + 1) + ": ");

                for (int j = 0; j < TTTData.get(i).length; j++) {
                    System.out.print(TTTData.get(i)[j] + " ");
                }

                System.out.print("\n");
            }

            for (int i = 0; i < CancerData.size(); i++) {

                System.out.print("Cancer " + (i + 1) + ": ");

                for (int j = 0; j < CancerData.get(i).length; j++) {
                    System.out.print(CancerData.get(i)[j] + " ");
                }

                System.out.print("\n");
            }





        } catch (FileNotFoundException e) {
        } catch (IOException e) {}
    }
}
