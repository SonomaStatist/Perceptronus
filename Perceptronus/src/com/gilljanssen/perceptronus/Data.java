package com.gilljanssen.perceptronus;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {

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

    public final List<TDatum> TData = new ArrayList<>();
    public final List<TDatum> TestTData = new ArrayList<>();
    public final List<CDatum> CancerData = new ArrayList<>();
    public final List<CDatum> TestCancerData = new ArrayList<>();

    public Data() {
        try {
            CSVReader reader = new CSVReader(new FileReader("data/tictactoe.data"));
            List<String[]> tttCsv = reader.readAll();

            reader = new CSVReader(new FileReader("data/cancer.data"));
            List<String[]> cancerCsv = reader.readAll();

            for (String[] features : tttCsv) {
                int[] intFeats = new int[features.length - 1];
                for (int i = 0; i < features.length - 1; i++) {
                    int feat = 0;
                    switch (features[i]) {
                        case "x":
                            feat = 1;
                            break;
                        case "o":
                            feat = -1;
                            break;
                        case "b":
                            feat = 0;
                            break;
                    }
                    intFeats[i] = feat;
                }
                boolean pass = features[features.length - 1].equals("positive");
                TData.add(new TDatum(intFeats, pass));
            }

            for (String[] features : cancerCsv) {
                float[] floatFeats = new float[features.length - 2];
                boolean pass = features[1].equals("M");
                for (int i = 2; i < features.length; i++) {
                    floatFeats[i - 2] = Float.parseFloat(features[i]);
                }
                CancerData.add(new CDatum(floatFeats, pass));
            }

            Random random = new Random();
            for (int i = (int)(TData.size() * 0.1); i > 0; i--) {
                TestTData.add(TData.remove(random.nextInt(TData.size())));
            }

            for (int i = (int)(CancerData.size() * 0.1); i > 0; i--) {
                TestCancerData.add(CancerData.remove(random.nextInt(CancerData.size())));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("IOException.");
        }
    }
}
