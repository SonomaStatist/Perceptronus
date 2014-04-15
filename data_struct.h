#ifndef DATA_STRUCT_H
#define DATA_STRUCT_H

struct TTTDatum {
    bool xWins;
    int features[9];
};

struct CancerDatum {
    bool malignant;
    float features[30];
};

#endif
