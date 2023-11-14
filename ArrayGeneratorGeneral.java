import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ArrayGeneratorGeneral {

    public static void main(String[] args) {
        int dimension = 1000;

        BubbleSortPassPerItem bubbleSortPassPerItem = new BubbleSortPassPerItem();
        BubbleSortUntilNoChange bubbleSortUntilNoChange = new BubbleSortUntilNoChange();
        BubbleSortWhileNeeded bubbleSortWhileNeeded = new BubbleSortWhileNeeded();   
        

        String[] typeOfTheArray = {"random", "sorted", "partSorted", "reverse", "duplicates", "noDuplicates", "equal"};

        //FOR INT
        for (String type : typeOfTheArray) {
            int[] intArray = (int[]) arrayGeneratorGeneral("int", dimension, type);
            // Convert int[] to Integer[]
            Integer[] integerArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
            for (int i = 0; i < 150; i++) {
                //int
                // analyzeSortingPerformance(bubbleSortPassPerItem, integerArray, "bubbleSortPassPerItem", "int", type, i);
                // analyzeSortingPerformance(bubbleSortUntilNoChange, integerArray, "bubbleSortUntilNoChange", "int", type, i);
                // analyzeSortingPerformance(bubbleSortWhileNeeded, integerArray, "bubbleSortWhileNeeded", "int", type, i);
            }

        }

        // FOR INTEGER
        for (String type : typeOfTheArray) {
            Integer[] integerArray = (Integer[]) arrayGeneratorGeneral("Integer", dimension, type);
            for (int i = 0; i < 150; i++) {
                //Integer
                // analyzeSortingPerformance(bubbleSortPassPerItem, integerArray, "bubbleSortPassPerItem", "Integer", type, i);
                // analyzeSortingPerformance(bubbleSortUntilNoChange, integerArray, "bubbleSortUntilNoChange", "Integer", type, i);
                // analyzeSortingPerformance(bubbleSortWhileNeeded, integerArray, "bubbleSortWhileNeeded", "Integer", type, i);
            }
        }

        // FOR STRING
        for (String type : typeOfTheArray) {
            String[] stringArray = (String[]) arrayGeneratorGeneral("String", dimension, type);
            for (int i = 0; i < 150; i++) {
                //String
                // analyzeSortingPerformance(bubbleSortPassPerItem, stringArray, "bubbleSortPassPerItem", "String", type, i);
                // analyzeSortingPerformance(bubbleSortUntilNoChange, stringArray, "bubbleSortUntilNoChange", "String", type, i);
                // analyzeSortingPerformance(bubbleSortWhileNeeded, stringArray, "bubbleSortWhileNeeded", "String", type, i);
            }
        }

        // FOR DOUBLE
        for (String type : typeOfTheArray) {
            double[] doubleArray = (double[]) arrayGeneratorGeneral("double", dimension, type);
            // Convert double[] to Double[]
            Double[] doubleArray2 = Arrays.stream(doubleArray).boxed().toArray(Double[]::new);
            for (int i = 0; i < 150; i++) {
                //Double
                // analyzeSortingPerformance(bubbleSortPassPerItem, doubleArray2, "bubbleSortPassPerItem", "Double", type, i);
                // analyzeSortingPerformance(bubbleSortUntilNoChange, doubleArray2, "bubbleSortUntilNoChange", "Double", type, i);
                // analyzeSortingPerformance(bubbleSortWhileNeeded, doubleArray2, "bubbleSortWhileNeeded", "Double", type, i);
            }
        }

        // // FOR FLOAT                     --> DOES NOT WORK
        // for (String type : typeOfTheArray) {
        //     float[] floatArray = (float[]) arrayGeneratorGeneral("float", dimension, type);
        //     // Convert float[] to Float[]
        //     Float[] floatArray2 = Arrays.stream(floatArray).boxed().toArray(Float[]::new);
        //     for (int i = 0; i < 150; i++) {
        //         //Float
        //         analyzeSortingPerformance(bubbleSortPassPerItem, floatArray2, "bubbleSortPassPerItem", "Float", type, i);
        //         // analyzeSortingPerformance(bubbleSortUntilNoChange, floatArray2, "bubbleSortUntilNoChange", "Float", type, i);
        //         // analyzeSortingPerformance(bubbleSortWhileNeeded, floatArray2, "bubbleSortWhileNeeded", "Float", type, i);
        //     }
        // }

        // FOR CHAR
        for (String type : typeOfTheArray) {
            char[] charArray = (char[]) arrayGeneratorGeneral("char", dimension, type);
            // Convert char[] to Character[]
            Character[] charArray2 = new Character[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                charArray2[i] = charArray[i];
            }
            for (int i = 0; i < 150; i++) {
                //Character
                // analyzeSortingPerformance(bubbleSortPassPerItem, charArray2, "bubbleSortPassPerItem", "Character", type, i);
                // analyzeSortingPerformance(bubbleSortUntilNoChange, charArray2, "bubbleSortUntilNoChange", "Character", type, i);
                // analyzeSortingPerformance(bubbleSortWhileNeeded, charArray2, "bubbleSortWhileNeeded", "Character", type, i);
            }
        }

        // FOR BYTE
        for (String type : typeOfTheArray) {
            byte[] byteArray = (byte[]) arrayGeneratorGeneral("byte", dimension, type);
            // Convert byte[] to Byte[]
            Byte[] byteArray2 = new Byte[byteArray.length];
            for (int i = 0; i < byteArray.length; i++) {
                byteArray2[i] = byteArray[i];
            }
            for (int i = 0; i < 150; i++) {
                //Byte
                // analyzeSortingPerformance(bubbleSortPassPerItem, byteArray2, "bubbleSortPassPerItem", "Byte", type, i);
                // analyzeSortingPerformance(bubbleSortUntilNoChange, byteArray2, "bubbleSortUntilNoChange", "Byte", type, i);
                analyzeSortingPerformance(bubbleSortWhileNeeded, byteArray2, "bubbleSortWhileNeeded", "Byte", type, i);
            }
        }
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
        String csvFilename = "resultByte1000.csv";
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
