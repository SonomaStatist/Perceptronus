#ifndef DATA_STRUCT_H
#define DATA_STRUCT_H

struct TTTDatum {
    owner * features;
    bool xWins;
};

struct CancerDatum {
    char * patientID;
    float * features;
    bool malignant;
};

#endif
