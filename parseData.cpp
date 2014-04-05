#include <iostream>
#include "csv_parser.hpp"
using namespace std;

int main()
{
  /* Declare the variables to be used */
  const char * filename = "tictactoe.data";
  const char field_terminator = ',';
  const char line_terminator  = '\n';

  csv_parser file_parser;
  file_parser.init(filename);

  file_parser.set_field_term_char(field_terminator);

  file_parser.set_line_term_char(line_terminator);

  unsigned int row_count = 1U;

  /* Check to see if there are more records, then grab each row one at a time */
  while(file_parser.has_more_rows())
    {
      unsigned int i = 0;

      /* Get the record */
      csv_row row = file_parser.get_row();

      /* Print out each column in the row */
      for (i = 0; i < row.size(); i++)
	{
	  printf("COLUMN %02d : %s\n", i + 1U, row[i].c_str());
	}

      printf("====================================================================\n");
      printf("END OF ROW %02d\n", row_count);
      printf("====================================================================\n");

      row_count++;
    }

  return 0;
}
