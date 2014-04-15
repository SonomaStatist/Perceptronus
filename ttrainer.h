#ifndef TTRAINER_H
#define TTRAINER_H

#include <vector>
#include <chrono>
#include <random>

#include "data_struct.h"
#include "perceptron.h"

class TTrainer {
    private:
        std::vector<TTTDatum> trainingSet;
        std::vector<TTTDatum> testingSet;

        Perceptron * p;

    public:
        TTrainer(std::vector<TTTDatum> data);
        float test();
        float train();
};

#endif // TTRAINER_H
