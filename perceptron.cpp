#include "perceptron.h"

Perceptron * makePerceptron(int len) {
    Perceptron * p = new Perceptron;
    p->len = len;
    p->b = 0.0;
    p->w = new float[len];
    p->a = 0.01;

    int i;
    for (i = 0; i < len; i++) {
        p->w[i] = 0.0;
    }

    return p;
}

float y(Perceptron * p, int * i) {
    float dot = 0.0;

    int j;
    for (j = 0; j < p->len; j++) {
        dot += p->w[j] * i[j];
    }

    dot += p->b;

    return dot > 0.0;
}

bool f(Perceptron * p, int * i) {
    return y(p, i) > 0.0;
}

void update(Perceptron * p, int * i, bool out) {
    int d = out ? 1 : 0;
    float yi = y(p, i);

    int j;
    for (j = 0; j < p->len; j++) {
        p->w[j] += (p->a) * (i[j]) * (d - yi);
    }

    p->b += (p->a) * (d - yi);
}
