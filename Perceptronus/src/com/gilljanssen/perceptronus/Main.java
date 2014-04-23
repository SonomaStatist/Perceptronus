package com.gilljanssen.perceptronus;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataParser dataParser = new DataParser();
        List<String[]> TTTData = dataParser.TTTData;
        List<String[]> CancerData = dataParser.CancerData;
        List<String[]> TestTTTData = dataParser.TestTTTData;
        List<String[]> TestCancerData = dataParser.TestCancerData;

    }
}
