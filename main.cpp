#include <iostream>
#include "csv_parser.hpp"
#include "enum.h"
#include "data_struct.h"
#include <vector>
#include <stdlib.h>
#include <string.h>

using namespace std;

owner charToOwner (const char * character) {
    if (strcmp(character, "x") == 0) {
        return X;
    } else if (strcmp(character, "0") == 0) {
        return O;
    } else {
        return B;
    }
}

int main() {
    //TTTDatum ** TTTData = new TTTDatum*[958];
    //CancerDatum ** CancerData = new CancerDatum*[300];
    vector<TTTDatum> TTTData;
    vector<CancerDatum> CancerData;
    int TTTDataCount = 0;
    int CancerDataCount = 0;

    /* Declare the variables to be used */
    const char * TTTFilename = "tictactoe.data";
    const char * CancerFilename = "cancer.data";
    const char field_terminator = ',';
    const char line_terminator  = '\n';

    csv_parser ttt_file_parser;
    ttt_file_parser.init(TTTFilename);
    ttt_file_parser.set_field_term_char(field_terminator);
    ttt_file_parser.set_line_term_char(line_terminator);

    while(ttt_file_parser.has_more_rows()) {
        TTTDataCount++;
        TTTDatum ttt_datum;
        //ttt_datum->features = new owner[9];

        csv_row row = ttt_file_parser.get_row();
        for (unsigned int i = 0; i < row.size() - 1; i++) {
            ttt_datum.features[i] = charToOwner(row[i].c_str()); 
            printf("COLUMN %02d : %s\n", i + 1U, row[i].c_str());
        }
        ttt_datum.xWins = strcmp(row[9].c_str(), "positive") == 0 ? true : false;

        printf("====================================================================\n");
        printf("END OF ROW %02d\n", TTTDataCount);
        printf("====================================================================\n");

        //TTTData[TTTDataCount] = ttt_datum;
        TTTData.push_back(ttt_datum);
    }

    csv_parser cancer_file_parser;
    cancer_file_parser.init(CancerFilename);
    cancer_file_parser.set_field_term_char(field_terminator);
    cancer_file_parser.set_line_term_char(line_terminator);

    while(cancer_file_parser.has_more_rows()) {
        CancerDataCount++;
        csv_row row = cancer_file_parser.get_row();
        CancerDatum cancer_datum;
        //cancer_datum->features = new float[row.size() - 2];

        for (unsigned int i = 2; i < row.size(); i++) {
            cancer_datum.features[i] = atof(row[i].c_str());
            printf("COLUMN %02d : %s\n", i + 1U, row[i].c_str());
        }
        cancer_datum.malignant = strcmp(row[1].c_str(), "M") == 0 ? true : false;

        printf("====================================================================\n");
        printf("END OF ROW %02d\n", CancerDataCount);
        printf("====================================================================\n");

        //CancerData[CancerDataCount] = cancer_datum;
        CancerData.push_back(cancer_datum);
    }

    return 0;
}

