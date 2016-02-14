# Find Sub-Matrix Sum
For a given matrix, find the sum of any sub-matrix in O(1)

## Example
Given the following matrix:

![Sample Matrix](images/matrix.png)

Calculate the following sub matrixes 

![Sample Sub-Matrixes](imagessub.matrix.png)

# The Output
The output of the code is:

```javascript
Started...
Building and processing matrix.
Matrix
    45     0    14     3     4    30     6    12
    34    14    22     9    34    56    17    34
     6    12    15     3    49    49     8    72
    16    78     5    42    63     1    48    18
     2    24    12    20    56    11    29    13
    32     9    33     2    33     6    19    21
    58    37    10    21    20    15    98    19
    17    55    19     1    13    20    17    43
Sum Matrix
    45    45    59    62    66    96   102   114
    79    93   129   141   179   265   288   334
    85   111   162   177   264   399   430   548
   101   205   261   318   468   604   683   819
   103   231   299   376   582   729   837   986
   135   272   373   452   691   844   971  1141
   193   367   478   578   837  1005  1230  1419
   210   439   569   670   942  1130  1372  1604

Red rectangle [1,1 => 1,4] sum is 128
Blue rectangle [1,4 => 2,6] sum is 125
Purple rectangle [3,4 => 7,6] sum is 383
Completed.
```