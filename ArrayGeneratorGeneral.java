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
            Integer[] integerArrayCopy = Arrays.copyOf(integerArray, integerArray.length);
            Integer[] integerArrayCopy2 = Arrays.copyOf(integerArray, integerArray.length);
            
            for (int i = 0; i < 150; i++) {
                //int
                analyzeSortingPerformance(bubbleSortPassPerItem, integerArray, "bubbleSortPassPerItem", "int", type, i);
            }
            System.out.println(Arrays.toString(integerArrayCopy));
            for (int i = 0; i < 150; i++) {
                analyzeSortingPerformance(bubbleSortUntilNoChange, integerArrayCopy, "bubbleSortUntilNoChange", "int", type, i);
            }
            for (int i = 0; i < 150; i++) {
                analyzeSortingPerformance(bubbleSortWhileNeeded, integerArrayCopy2, "bubbleSortWhileNeeded", "int", type, i);
            }

        }

        // FOR INTEGER
        for (String type : typeOfTheArray) {
            Integer[] integerArray = (Integer[]) arrayGeneratorGeneral("Integer", dimension, type);
            Integer[] integerArrayCopy = integerArray;
            Integer[] integerArrayCopy2 = integerArray;

            // for (int i = 0; i < 150; i++) {
            //     //Integer
            //     analyzeSortingPerformance(bubbleSortPassPerItem, integerArray, "bubbleSortPassPerItem", "Integer", type, i);
            // }
            // for (int i = 0; i < 150; i++) {
            //     analyzeSortingPerformance(bubbleSortUntilNoChange, integerArrayCopy, "bubbleSortUntilNoChange", "Integer", type, i);
            // }
            // for (int i = 0; i < 150; i++) {
            //     analyzeSortingPerformance(bubbleSortWhileNeeded, integerArrayCopy2, "bubbleSortWhileNeeded", "Integer", type, i);
            // }
        }

        // FOR STRING
        for (String type : typeOfTheArray) {
            String[] stringArray = (String[]) arrayGeneratorGeneral("String", dimension, type);
            String[] stringArrayCopy = stringArray;
            String[] stringArrayCopy2 = stringArray;

            // for (int i = 0; i < 150; i++) {
            //     //String
            //     analyzeSortingPerformance(bubbleSortPassPerItem, stringArray, "bubbleSortPassPerItem", "String", type, i);
            // }
            // for (int i = 0; i < 150; i++) {
            //     analyzeSortingPerformance(bubbleSortUntilNoChange, stringArrayCopy, "bubbleSortUntilNoChange", "String", type, i);
            // }
            // for (int i = 0; i < 150; i++) {
            //     analyzeSortingPerformance(bubbleSortWhileNeeded, stringArrayCopy2, "bubbleSortWhileNeeded", "String", type, i);
            // }
        }

        // FOR DOUBLE
        for (String type : typeOfTheArray) {
            double[] doubleArray = (double[]) arrayGeneratorGeneral("double", dimension, type);
            // Convert double[] to Double[]
            Double[] doubleArray2 = Arrays.stream(doubleArray).boxed().toArray(Double[]::new);
            Double[] doubleArrayCopy = Arrays.stream(doubleArray).boxed().toArray(Double[]::new);
            Double[] doubleArrayCopy2 = Arrays.stream(doubleArray).boxed().toArray(Double[]::new);
            
            // for (int i = 0; i < 150; i++) {
            //     //Double
            //     analyzeSortingPerformance(bubbleSortPassPerItem, doubleArray2, "bubbleSortPassPerItem", "Double", type, i);
            // }
            // for (int i = 0; i < 150; i++) {
            //     analyzeSortingPerformance(bubbleSortUntilNoChange, doubleArrayCopy, "bubbleSortUntilNoChange", "Double", type, i);
            // }
            // for (int i = 0; i < 150; i++) {
            //     analyzeSortingPerformance(bubbleSortWhileNeeded, doubleArrayCopy2, "bubbleSortWhileNeeded", "Double", type, i);            
            // }
        }

        // FOR CHAR
        for (String type : typeOfTheArray) {
            char[] charArray = (char[]) arrayGeneratorGeneral("char", dimension, type);
            // Convert char[] to Character[]
            Character[] charArray2 = new Character[charArray.length];
            Character[] charArrayCopy = new Character[charArray.length];
            Character[] charArrayCopy2 = new Character[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                charArray2[i] = charArray[i];
            }
            for (int i = 0; i < charArray.length; i++) {
                charArrayCopy[i] = charArray[i];
            }
            for (int i = 0; i < charArray.length; i++) {
                charArrayCopy2[i] = charArray[i];
            }
            
            // for (int i = 0; i < 150; i++) {
            //     //Character
            //     analyzeSortingPerformance(bubbleSortPassPerItem, charArray2, "bubbleSortPassPerItem", "Character", type, i);
            // }
            // for (int i = 0; i < 150; i++) {
            //     analyzeSortingPerformance(bubbleSortUntilNoChange, charArrayCopy, "bubbleSortUntilNoChange", "Character", type, i);
            // }
            // for (int i = 0; i < 150; i++) {
            //     analyzeSortingPerformance(bubbleSortWhileNeeded, charArrayCopy2, "bubbleSortWhileNeeded", "Character", type, i);
            // }
        }

        // FOR BYTE
        for (String type : typeOfTheArray) {
            byte[] byteArray = (byte[]) arrayGeneratorGeneral("byte", dimension, type);
            // Convert byte[] to Byte[]
            Byte[] byteArray2 = new Byte[byteArray.length];
            Byte[] byteArrayCopy = new Byte[byteArray.length];
            Byte[] byteArrayCopy2 = new Byte[byteArray.length];

            for (int i = 0; i < byteArray.length; i++) {
                byteArray2[i] = byteArray[i];
            }
            for (int i = 0; i < byteArray.length; i++) {
                byteArrayCopy[i] = byteArray[i];
            }
            for (int i = 0; i < byteArray.length; i++) {
                byteArrayCopy2[i] = byteArray[i];
            }

            // for (int i = 0; i < 150; i++) {
            //     //Byte
            //     analyzeSortingPerformance(bubbleSortPassPerItem, byteArray2, "bubbleSortPassPerItem", "Byte", type, i);
            // }
            // for (int i = 0; i < 150; i++) {
            //     analyzeSortingPerformance(bubbleSortUntilNoChange, byteArrayCopy, "bubbleSortUntilNoChange", "Byte", type, i);
            // }
            // for (int i = 0; i < 150; i++) {
            //     analyzeSortingPerformance(bubbleSortWhileNeeded, byteArrayCopy2, "bubbleSortWhileNeeded", "Byte", type, i);
            // }
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
        String csvFilename = "resultInt1000.csv";
        try (FileWriter writer = new FileWriter(csvFilename, true)) {
            writer.append(funcName)
                    .append(",")
                    .append(type)
                    .append(",")
                    .append(typeOfTheArray)
                    .append(",")
                    .append(String.valueOf(startTime))
                    .append(",")
                    .append(String.valueOf(endTime))
                    .append(",")
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
