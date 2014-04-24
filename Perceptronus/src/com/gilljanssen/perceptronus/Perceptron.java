package com.gilljanssen.perceptronus;

public class Perceptron {

    // the learning rate of the perceptron
    final float rate;
    // the length of the weight vector
    final int len;
    // the bias factor
    float bias;
    // the weight vector
    final float[] weights;

    public Perceptron(int len) {
        this.rate = 0.01f;
        this.bias = 0.0f;
        this.len = len;
        this.weights = new float[len];

        for (float weight : weights) {
            weight = 0.0f;
        }
    }

    public float dotProduct(int[] features) {
        float dotp = bias;

        for (int i = 0; i < len; i++) {
            dotp += weights[i] * features[i];
        }

        return dotp;
    }

    public boolean fireNeuron(int[] features) {
        return dotProduct(features) > 0.0;
    }

    public void update(int[] features, boolean pass) {
        int d = pass ? 1 : -1;
        float dotp = dotProduct(features);

        for (int i = 0; i < len; i++) {
            weights[i] += rate * features[i] * (d - dotp);
        }

        bias += rate * (d - dotp);
    }
}
