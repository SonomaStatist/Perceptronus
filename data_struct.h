#ifndef DATA_STRUCT_H
#define DATA_STRUCT_H

struct TTTDatum {
    bool xWins;
    owner features[9];
};

struct CancerDatum {
    char * patientID;
    bool malignant;
    float features[30];
};

#endif
