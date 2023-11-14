import java.text.ParseException;

import org.xml.sax.helpers.ParserAdapter;

import java.util.Arrays;

public class ArrayGeneratorGeneral {

    public static void main(String[] args) {
        int dimension = 10;

        System.out.println("\nFor int arrays:");
        testing("int", dimension);
        System.out.println("\n");

        System.out.println("For String arrays:");
        testing("String", dimension);
        System.out.println("\n");

        System.out.println("For double arrays:");
        testing("double", dimension);
        System.out.println("\n");

        System.out.println("For float arrays:");
        testing("float", dimension);
        System.out.println("\n");

        System.out.println("For char arrays:");
        testing("char", dimension);
        System.out.println("\n");

        System.out.println("For Integer arrays:");
        testing("Integer", dimension);
        System.out.println("\n");

        System.out.println("For byte arrays:");
        testing("byte", dimension);
        System.out.println("\n");
    }

    public static void testing(String type, int dimension) {
        testArray(type, "random", dimension);

        // Test sorted type array
        testArray(type, "sorted", dimension);

        // Test partially sorted type array
        testArray(type, "partiallySorted", dimension);

        // Test reverse sorted type array
        testArray(type, "reverse", dimension);

        // Test type array with duplicates
        testArray(type, "duplicates", dimension);

        // Test type array without duplicates
        testArray(type, "noDuplicates", dimension);

        // Test equal type array
        testArray(type, "equal", dimension);
    }

    public static void testArray(String type, String natureChoice, int dimension) {
        Object result = arrayGeneratorGeneral(type, dimension, natureChoice);
        System.out.print(natureChoice + " " + type + " array:");
        
        // Check the type of the result and print accordingly
        if (result instanceof int[]) {
            System.out.println(Arrays.toString((int[]) result));
        } else if (result instanceof String[]) {
            System.out.println(Arrays.toString((String[]) result));
        } else if (result instanceof double[]) {
            System.out.println(Arrays.toString((double[]) result));
        } else if (result instanceof float[]) {
            System.out.println(Arrays.toString((float[]) result));
        } else if (result instanceof char[]) {
            System.out.println(Arrays.toString((char[]) result));
        } else if (result instanceof Integer[]) {
            System.out.println(Arrays.toString((Integer[]) result));
        } else if (result instanceof byte[]) {
            System.out.println(Arrays.toString((byte[]) result));
        } else {
            System.out.println("Unsupported array type");
        }
    }

    private static int getNatureChoice(String natureChoice) {
        switch (natureChoice) {
            case "random":
                return 1;
            case "sorted":
                return 2;
            case "partiallySorted":
                return 3;
            case "reverse":
                return 4;
            case "duplicates":
                return 5;
            case "noDuplicates":
                return 6;
            case "equal":
                return 7;
            default:
                throw new IllegalArgumentException("Invalid natureChoice: " + natureChoice);
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
