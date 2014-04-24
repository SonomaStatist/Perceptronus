package com.gilljanssen.perceptronus;

import java.util.List;

/**
 * Trainer class for the tic tac toe perceptron
 *
 * @author Amandeep Gill
 */
public class TTrainer {
    private final Perceptron p = new Perceptron(9);
    private final List<Data.TDatum> trainingData;
    private final List<Data.TDatum> testData;
    public final int numTests;

    public TTrainer(List<Data.TDatum> trainingData, List<Data.TDatum> testData) {
        this.trainingData = trainingData;
        this.testData = testData;
        this.numTests = testData.size();

        System.out.println("size of training set: " + trainingData.size());
        System.out.println("size of testing set: " + testData.size());
    }

    public int test() {
        int passedTests = 0;

        for (Data.TDatum datum : testData) {
            float dotp = p.dotProduct(datum.features);
            //System.out.println(dotp + " : " + datum.pass);
            if (dotp > 0 && datum.pass || dotp <= 0 && !datum.pass) {
                passedTests++;
            }
        }

        return passedTests;
    }

    public void runEpoch() {
        for (Data.TDatum datum : trainingData) {
            p.update(datum.features, datum.pass);
        }
    }
}
