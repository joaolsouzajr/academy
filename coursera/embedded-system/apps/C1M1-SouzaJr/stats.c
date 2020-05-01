/******************************************************************************
 * Copyright (C) 2017 by Alex Fosdick - University of Colorado
 *
 * Redistribution, modification or use of this software in source or binary
 * forms is permitted as long as the files maintain this copyright. Users are 
 * permitted to modify this and use it to learn about the field of embedded
 * software. Alex Fosdick and the University of Colorado are not liable for any
 * misuse of this material. 
 *
 *****************************************************************************/
/**
 * @file stats.c
 * @brief Funcions implmentations to produces analytic report with statistics of an array
 *
 * Functions that can analyze an array of unsigned char data items and report analytics 
 * on the maximum, minimum, mean, and median of the data set.
 *
 * @author Joao Souza Jr
 * @date 2019-05-05
 *
 */


#include <stdio.h>
#include "stats.h"

/* Size of the Data Set */
#define SIZE (40)

void main() {

  unsigned char test[SIZE] = { 34, 201, 190, 154,   8, 194,   2,   6,
                              114, 88,   45,  76, 123,  87,  25,  23,
                              200, 122, 150, 90,   92,  87, 177, 244,
                              201,   6,  12,  60,   8,   2,   5,  67,
                                7,  87, 250, 230,  99,   3, 100,  90};

  /* Other Variable Declarations Go Here */
  /* Statistics and Printing Functions Go Here */
  print_statistics(test, SIZE);
}

/* Add other Implementation File Code Here */

void print_statistics(unsigned char * data, unsigned int length)
{
  printf("Statistics \n");
  sort_array(data, length);
  printf("Sorted ");
  print_array(data, length);
  printf("Mean = %d; Median = %d; Maximum = %d; Minimum = %d;",
     find_mean(data, length),
     find_median(data, length),
     find_maximum(data, length),
     find_minimum(data, length)
  );
}

void print_array(unsigned char * data, unsigned int length)
{
  unsigned int i;
  printf("Array: ");
  for(i = 0; i < length; i++)
  {
    printf("%d ", (data[i]));
  }
  printf("\n");
}

unsigned char find_median(unsigned char * data, unsigned int length)
{
  sort_array(data, length);
  if(length % 2 == 0) {
    // if there is an even number of elements, 
    //return mean of the two elements in the middle
    return ((data[length/2] + data[length/2 - 1]) / 2);
  } else {
    // else return the element in the middle
    return data[length/2];
  }
  return 0;
}

unsigned char find_mean(unsigned char * data, unsigned int length)
{
  unsigned int i;
  unsigned int sum;
  sum = 0;
  if ( data == NULL)
  {
    return 0;
  }
  for(i = 0; i < length; i++)
  {
    sum = sum + *data;
    data++;
  }
  if ( length <= 0 ) 
  {
    length = 1;
  }
  return (sum/length);
}

unsigned char find_maximum(unsigned char * data, unsigned int length)
{
  sort_array(data, length);
  return data[0];
}

unsigned char find_minimum(unsigned char * data, unsigned int length)
{
  sort_array(data, length);
  return data[length - 1];
}

void sort_array(unsigned char * data, unsigned int length)
{
  unsigned char temp;
  unsigned char i, j;
  for(i = 0; i < length - 1; i++) {
    for(j = i + 1; j < length; j++) {
        if(data[j] > data[i]) {
            // swap elements
            temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }
  }
}
