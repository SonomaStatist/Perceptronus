#ifndef PERCEPTRON_H
#define PERCEPTRON_H

typedef struct {
    // the learning rate of the perceptron
    float a;
    // the length of the weight vector
    int len;
    // the bias factor
    float b;
    // the weight vector
    float * w;
} Perceptron;

// create a new perceptron with a randomized weight vector of length len
Perceptron * makePerceptron(int len);
// returns the value of the dot product of the weights and input vectors
float y(Perceptron * p, const int * i);
// returns true if the dot product of the input and weight vectors is greater than 0
bool f(Perceptron * p, const int * i);
// update the weight values of the perceptron with the given input and the desired output
void update(Perceptron * p, const int * i, bool out);

#endif // PERCEPTRON_H
