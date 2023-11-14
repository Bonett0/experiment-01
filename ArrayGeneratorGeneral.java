import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ArrayGeneratorGeneral {

    public static void main(String[] args) {
        int dimension = 1000;

        BubbleSortPassPerItem bubbleSortPassPerItem = new BubbleSortPassPerItem();
        BubbleSortUntilNoChange bubbleSortUntilNoChange = new BubbleSortUntilNoChange();
        BubbleSortWhileNeeded bubbleSortWhileNeeded = new BubbleSortWhileNeeded();   
        
        //FOR INT
        int[] intArray = (int[]) arrayGeneratorGeneral("int", dimension, "equal");
        // Convert int[] to Integer[]
        Integer[] integerArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);

        //FOR INTEGER
        // Integer[] integerArray2 = (Integer[]) arrayGeneratorGeneral("Integer", dimension, "random");

        int counter = 0;
        // loop 125 times + 25 warm-up times 
        for (int i = 0; i < 150; i++) {
            //int 
            analyzeSortingPerformance(bubbleSortPassPerItem, integerArray, "bubbleSortPassPerItem", "int", "random", i);
            analyzeSortingPerformance(bubbleSortPassPerItem, integerArray, "bubbleSortPassPerItem", "int", "sorted", i);
            analyzeSortingPerformance(bubbleSortPassPerItem, integerArray, "bubbleSortPassPerItem", "int", "partSorted", i);
            analyzeSortingPerformance(bubbleSortPassPerItem, integerArray, "bubbleSortPassPerItem", "int", "reverse", i);
            analyzeSortingPerformance(bubbleSortPassPerItem, integerArray, "bubbleSortPassPerItem", "int", "duplicates", i);
            analyzeSortingPerformance(bubbleSortPassPerItem, integerArray, "bubbleSortPassPerItem", "int", "noDuplicates", i);
            analyzeSortingPerformance(bubbleSortPassPerItem, integerArray, "bubbleSortPassPerItem", "int", "equal", i);
        }

        for (int i = 0; i < 150; i++) {
            //int
            analyzeSortingPerformance(bubbleSortUntilNoChange, integerArray, "BubbleSortUntilNoChange", "int", "random", i);
            analyzeSortingPerformance(bubbleSortUntilNoChange, integerArray, "BubbleSortUntilNoChange", "int", "sorted", i);
            analyzeSortingPerformance(bubbleSortUntilNoChange, integerArray, "BubbleSortUntilNoChange", "int", "partSorted", i);
            analyzeSortingPerformance(bubbleSortUntilNoChange, integerArray, "BubbleSortUntilNoChange", "int", "reverse", i);
            analyzeSortingPerformance(bubbleSortUntilNoChange, integerArray, "BubbleSortUntilNoChange", "int", "duplicates", i);
            analyzeSortingPerformance(bubbleSortUntilNoChange, integerArray, "BubbleSortUntilNoChange", "int", "noDuplicates", i);
            analyzeSortingPerformance(bubbleSortUntilNoChange, integerArray, "BubbleSortUntilNoChange", "int", "equal", i);
        }

        for (int i = 0; i < 150; i++) {
            //int
            analyzeSortingPerformance(bubbleSortWhileNeeded, integerArray, "BubbleSortWhileNeeded", "int", "random", i);
            analyzeSortingPerformance(bubbleSortWhileNeeded, integerArray, "BubbleSortWhileNeeded", "int", "sorted", i);
            analyzeSortingPerformance(bubbleSortWhileNeeded, integerArray, "BubbleSortWhileNeeded", "int", "partSorted", i);
            analyzeSortingPerformance(bubbleSortWhileNeeded, integerArray, "BubbleSortWhileNeeded", "int", "reverse", i);
            analyzeSortingPerformance(bubbleSortWhileNeeded, integerArray, "BubbleSortWhileNeeded", "int", "duplicates", i);
            analyzeSortingPerformance(bubbleSortWhileNeeded, integerArray, "BubbleSortWhileNeeded", "int", "noDuplicates", i);
            analyzeSortingPerformance(bubbleSortWhileNeeded, integerArray, "BubbleSortWhileNeeded", "int", "equal", i);
        }

        // for (int i = 0; i < 150; i++) {
        //     //Integer
        //     analyzeSortingPerformance(bubbleSortPassPerItem, integerArray2, "BubbleSortPassPerItem", "Integer", "random");
        //     analyzeSortingPerformance(bubbleSortUntilNoChange, integerArray2, "BubbleSortUntilNoChange", "Integer", "random");
        //     analyzeSortingPerformance(bubbleSortWhileNeeded, integerArray2, "BubbleSortWhileNeeded", "Integer", "random");
        // }  
    }

    public static <T extends Comparable<T>> void analyzeSortingPerformance(Sorter<T> sorter, T[] array, String funcName, String type, String typeOfTheArray, int counter) {
        long startTime = System.nanoTime();
        sorter.sort(array);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        
        if (counter >= 25) {
            writeResultToCSV(funcName, type, typeOfTheArray, startTime, endTime, executionTime);
        }
    }

    public static void writeResultToCSV(String funcName, String type, String typeOfTheArray, long startTime, long endTime, long executionTime) {
        String csvFilename = "result.csv";
        try (FileWriter writer = new FileWriter(csvFilename, true)) {
            writer.append(funcName)
                    .append(", ")
                    .append(type)
                    .append(", ")
                    .append(typeOfTheArray)
                    .append(", ")
                    .append(String.valueOf(startTime))
                    .append(", ")
                    .append(String.valueOf(endTime))
                    .append(", ")
                    .append(String.valueOf(executionTime))
                    .append("\n");                    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object arrayGeneratorGeneral(String type, int dimension, String typeOfTheArray){
        int choice = 0;
        switch (typeOfTheArray) {
            case "random":
                choice = 1;
                break;
            case "sorted":
                choice = 2;
                break;
            case "partSorted":
                choice = 3;
                break;
            case "reverse":
                choice = 4;
                break;
            case "duplicates":
                choice = 5;
                break;
            case "noDuplicates":
                choice = 6;
                break;
            case "equal":
                choice = 7;
                break;
        }

        Object result = null;

        switch (type) {
            case "int":
                result = IntArrayGenerator.intArrayGenerator(dimension, choice);
                break;
            case "String":
                result = StringArrayGenerator.stringArrayGenerator(dimension, choice);
                break;
            case "double":
                result = DoubleArrayGenerator.doubleArrayGenerator(dimension, choice);
                break;
            case "float":
                result = FloatArrayGenerator.floatArrayGenerator(dimension, choice);
                break;
            case "char":
                result = CharArrayGenerator.charArrayGenerator(dimension, choice);
                break;
            case "Integer":
                result = IntegerArrayGenerator.intArrayGenerator(dimension, choice);
                break;
            case "byte":
                result = ByteArrayGenerator.byteArrayGenerator(dimension, choice);
                break;
        }

        return result;
    }   
}
