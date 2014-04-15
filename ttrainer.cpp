#include <vector>
#include <random>
#include <chrono>

#include "ttrainer.h"
#include "perceptron.h"
#include "data_struct.h"

TTrainer::TTrainer(std::vector<TTTDatum> data) {
    trainingSet.assign(data.begin(), data.end());

    int size = data.size();
    int numTest = (int) (size * 0.1);
    unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
    std::mt19937 rand(seed);

    for (int i = 0; i < numTest; i++) {
        int ri = rand() % size;
        testingSet.push_back(trainingSet[ri]);
        trainingSet.erase(trainingSet.begin() + ri);
    }

    p = makePerceptron(9);
}

float TTrainer::test() {
    float tests = testingSet.size();
    int passed = 0;

    for (TTTDatum datum : testingSet) {
        if (f(p, datum.features) == datum.xWins) {
            passed++;
        }
    }

    return passed / tests;
}

float TTrainer::train() {
    for (TTTDatum datum : trainingSet) {
        update(p, datum.features, datum.xWins);
    }

    return test();
}
