# experiment-01

Defining differe type of array that can test the diffeent algorithms: 



Lenght: Short , Medium, Long

Random Arrays:

    Unsorted arrays with random values: Test the algorithm's performance on typical unsorted data.
    Nearly sorted arrays: Slightly shuffle an already sorted array to test the algorithm's adaptability to nearly sorted data.
    Reverse sorted arrays: Sort an array in reverse order to test the algorithm's performance in the worst-case scenario.

    int[] randomArray = {5, 2, 9, 1, 5, 7, 3, 8, 4};
    int[] nearlySortedArray = {1, 2, 3, 5, 4, 7, 6, 8, 9};
    int[] reverseSortedArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};

Presorted Arrays:

    Already sorted arrays: Test how fast the algorithm is at recognizing and handling already sorted data.
    Arrays sorted in reverse order: These test the ability of the algorithm to deal with data sorted in the opposite order.

    int[] alreadySortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] reverseSortedArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    

Duplicate Values:

    Arrays with many duplicate values: Test the algorithm's handling of duplicate elements.
    Arrays with few or no duplicate values: Test the algorithm's performance when there are few or no duplicates.

    int[] arrayWithDuplicates = {3, 2, 5, 2, 7, 3, 9, 5, 7};
    int[] arrayWithoutDuplicates = {1, 2, 3, 4, 5, 6, 7, 8, 9};


Equal Values:

    Arrays where all elements are the same: Test how the algorithm handles data with no variation.

    int[] allEqualArray = {5, 5, 5, 5, 5, 5, 5, 5, 5};


Partially Sorted Arrays:

    Arrays where some subarrays are sorted and combined: Test how well the algorithm handles mixed data.

    int[] partiallySortedArray = {1, 2, 3, 9, 8, 7, 4, 5, 6};


Sparse Arrays:

    Arrays with many empty or null values: Test how the algorithm performs on data with missing elements.

    Integer[] sparseArray = {3, null, 8, null, 5, null, 2, null, 7};


Unique Values:

    Arrays with unique, non-repeating values: Test the algorithm on data with no duplicates.

    int[] uniqueArray = {5, 9, 2, 7, 1, 3, 6, 4, 8};


Data Distribution:
 
    Arrays with different data distributions (e.g., normal distribution, uniform distribution): Test how the algorithm handles various data patterns.

    int[] normalDistribution = {68, 72, 80, 85, 90, 92, 95, 100};
    int[] uniformDistribution = {10, 20, 30, 40, 50, 60, 70, 80, 90};


Data Range:

    Arrays with values within a specific range: Test how the algorithm performs with data constrained within certain value ranges.

    int[] rangeLimitedArray = {50, 30, 90, 20, 70, 40, 60, 80};

    
Unusual Characters or Data Types:

    If your library is sorting strings or objects, test with unusual characters, data types, or custom comparison functions.

    String[] stringArray = {"apple", "banana", "cherry", "date", "elderberry"};
    Integer[] arrayWithNulls = {3, null, 8, null, 5, null, 2, null, 7};
    double[] arrayWithNaN = {5.0, 2.0, Double.NaN, 1.0, 7.0, Double.NaN, 3.0, Double.POSITIVE_INFINITY};
    byte[] arrayByte
            
