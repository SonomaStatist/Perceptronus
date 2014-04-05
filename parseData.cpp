#include <iostream>
#include "csv_parser.hpp"
#include "enum.h"
#include "data_struct.h"
#include <stdlib.h>

using namespace std;

owner charToOwner (const char * character) {
    if (character == "x")
        return X;
    else if (character == "b")
        return B;
    else if (character == "0")
        return O;
}

int main()
{
    TTTDatum * TTTData = new TTTDatum[958];
    CancerDatum * CancerData = new CancerDatum[300];
    int TTTDataCount = 0;
    int CancerDataCount = 0;

    /* Declare the variables to be used */
    const char * TTTFilename = "tictactoe.data";
    const char * CancerFilename = "cancer.data";
    const char field_terminator = ',';
    const char line_terminator  = '\n';
    
    csv_parser file_parser;
    file_parser.init(TTTFilename);
    file_parser.set_field_term_char(field_terminator);
    file_parser.set_line_term_char(line_terminator);
    
    while(file_parser.has_more_rows())
    {
	TTTDatum datum;
	datum.features = new owner[9];
	
	csv_row row = file_parser.get_row();
	for (int i = 0; i < row.size() - 1; i++)
	{
	    datum.features[i] = charToOwner(row[i].c_str()); 
	    printf("COLUMN %02d : %s\n", i + 1U, row[i].c_str());
	}
	datum.xWins = row[9].c_str() == "positive" ? true : false;
	
	printf("====================================================================\n");
	printf("END OF ROW %02d\n", TTTDataCount);
	printf("====================================================================\n");
	
	TTTData[TTTDataCount] = datum;
	TTTDataCount++;
    }

    file_parser.init(CancerFilename);

    while(file_parser.has_more_rows())
    {
        csv_row row = file_parser.get_row();
        CancerDatum datum;
	datum.features = new float[row.size() - 2];

	for (int i = 2; i < row.size(); i++)
	{
	    datum.features[i] = atof(row[i].c_str());
	    printf("COLUMN %02d : %s\n", i + 1U, row[i].c_str());
        }
	datum.malignant = row[1].c_str() == "M" ? true : false;

	printf("====================================================================\n");
	printf("END OF ROW %02d\n", CancerDataCount);
	printf("====================================================================\n");

	CancerData[CancerDataCount] = datum;
	CancerDataCount++;
    }
    
    return 0;
}

