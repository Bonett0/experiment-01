import java.text.ParseException;

import org.xml.sax.helpers.ParserAdapter;

import java.util.Arrays;

public class ArrayGeneratorGeneral {

    public static void main(String[] args) {
        int dimension = 10;

        // Test random int array
        testArray("int", "random", dimension);

        // Test sorted String array
        testArray("String", "sorted", dimension);

        // Test partially sorted double array
        testArray("double", "partSorted", dimension);

        // Test reverse float array
        testArray("float", "reverse", dimension);

        // Test array with duplicates char array
        testArray("char", "duplicates", dimension);

        // Test array without duplicates Integer array
        testArray("Integer", "noDuplicates", dimension);

        // Test equal byte array
        testArray("byte", "equal", dimension);
      
    }

    public static void testArray(String type, String typeOfTheArray, int dimension) {
        Object result = arrayGeneratorGeneral(type, dimension, typeOfTheArray);
        System.out.print(typeOfTheArray + " " + type + " array:");
        
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
