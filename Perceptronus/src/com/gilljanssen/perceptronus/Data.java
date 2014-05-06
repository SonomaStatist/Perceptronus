package com.gilljanssen.perceptronus;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public final List<TDatum> TData = new ArrayList<>();
    public final List<TDatum> TestTData = new ArrayList<>();
    public final List<CDatum> CancerData = new ArrayList<>();
    public final List<CDatum> TestCancerData = new ArrayList<>();

    public Data() {
        try {
            CSVReader reader = new CSVReader(new FileReader("data/tictactoe.data"));
            List<String[]> tttCsv = reader.readAll();
            CSVWriter tttWriter = new CSVWriter(new FileWriter("data/tictactoe.num"));

            reader = new CSVReader(new FileReader("data/cancer.data"));
            List<String[]> cancerCsv = reader.readAll();
            CSVWriter cancerWriter = new CSVWriter(new FileWriter("data/cancer.num"));

            for (String[] features : tttCsv) {
                String[] outFeats = new String[features.length];
                for (int i = 0; i < features.length - 1; i++) {
                    String feat = "";
                    switch (features[i]) {
                        case "x":
                            feat = "1";
                            break;
                        case "o":
                            feat = "-1";
                            break;
                        case "b":
                            feat = "0";
                            break;
                    }
                    outFeats[i] = feat;
                }
                outFeats[features.length - 1] = features[features.length - 1].equals("positive") ? "1" : "0";

                tttWriter.writeNext(outFeats);
            }

            for (String[] features : cancerCsv) {
                String[] numFeats = new String[features.length - 1];
                numFeats[numFeats.length - 1] = features[1].equals("M") ? "1" : "0";
                System.arraycopy(features, 2, numFeats, 0, features.length - 2);

                cancerWriter.writeNext(numFeats);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("IOException.");
        }
    }

    class TDatum {
        final int[] features;
        final boolean pass;

        TDatum(int[] features, boolean pass) {
            this.features = features;
            this.pass = pass;
        }
    }

    class CDatum {
        final float[] features;
        final boolean pass;

        CDatum(float[] features, boolean pass) {
            this.features = features;
            this.pass = pass;
        }
    }
}
