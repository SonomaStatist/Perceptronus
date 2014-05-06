package com.gilljanssen.perceptronus;

/**
 * Connects the individual perceptrons into a neural network
 *
 * @author Amandeep Gill
 */
public class NeuralNetwork {
    private final Perceptron[] hiddenLayer;
    private final Perceptron outerLayer;

    public NeuralNetwork(int numHidden, int numInputs) {
        this.hiddenLayer = new Perceptron[numHidden];
        this.outerLayer = new Perceptron(numHidden);

        for (Perceptron p : hiddenLayer) {
            p = new Perceptron(numInputs);
        }
    }

    public boolean test() {
        return false;
    }
}
