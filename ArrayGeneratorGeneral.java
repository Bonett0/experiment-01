import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

public class ArrayGeneratorGeneral<T extends Comparable<T>> {

    public static void main(String[] args) {
        int dimension = 10;
        String type = "int";
        String natureChoice = "random";
        
        BubbleSortPassPerItem bubbleSortPassPerItem = new BubbleSortPassPerItem();
        BubbleSortWhileNeeded bubbleSortWhileNeeded = new BubbleSortWhileNeeded();
        BubbleSortUntilNoChange bubbleSortUntilNoChange = new BubbleSortUntilNoChange();


        Integer[] array = arrayGeneratorGeneral(type, dimension, natureChoice);
        
        // loopare 125 volte e 25 volte escludere pre warm up - tre sorting algorithm
            for (int i = 0; i < 1 ; i++) {
                test_algorithm(bubbleSortPassPerItem, array, "BubbleSortPassPerItem", natureChoice);

            }
        // mettere risultati su csv escudendo i primi 25
    }

    public void test_algorithm(Sorter<T> f, T[] items, String name_function,String natureChoice){
        double start_time = System.nanoTime();
        f.sort(items);
        double end_time = System.nanoTime();
        double difference = (end_time - start_time);

        String csvFilePath = "./data/"+ name_function +"."+items.getClass().getSimpleName()+"."+ natureChoice+".csv";


        String[] result = {name_function, String.valueOf(start_time), String.valueOf(end_time), String.valueOf(difference), items.getClass().getSimpleName()};
        
        StringBuilder csvData = new StringBuilder();
        csvData.append(String.join(",", result)).append("\n"); 
        
        try (FileWriter fileWriter = new FileWriter(csvFilePath)) {
            fileWriter.write(csvData.toString());

            System.out.println("Data has been written to " + csvFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // public static void tmp() {
        
    //     System.out.println("\nFor int arrays:");
    //     testing("int", dimension);
    //     System.out.println("\n");

    //     System.out.println("For String arrays:");
    //     testing("String", dimension);
    //     System.out.println("\n");

    //     System.out.println("For double arrays:");
    //     testing("double", dimension);
    //     System.out.println("\n");

    //     System.out.println("For float arrays:");
    //     testing("float", dimension);
    //     System.out.println("\n");

    //     System.out.println("For char arrays:");
    //     testing("char", dimension);
    //     System.out.println("\n");

    //     System.out.println("For Integer arrays:");
    //     testing("Integer", dimension);
    //     System.out.println("\n");

    //     System.out.println("For byte arrays:");
    //     testing("byte", dimension);
    //     System.out.println("\n");
    // }

    // public static void testing(String type, int dimension) {
    //     testArray(type, "random", dimension);

    //     // Test sorted type array
    //     testArray(type, "sorted", dimension);

    //     // Test partially sorted type array
    //     testArray(type, "partSorted", dimension);

    //     // Test reverse sorted type array
    //     testArray(type, "reverse", dimension);

    //     // Test type array with duplicates
    //     testArray(type, "duplicates", dimension);

    //     // Test type array without duplicates
    //     testArray(type, "noDuplicates", dimension);

    //     // Test equal type array
    //     testArray(type, "equal", dimension);
    // }

    // public static void testArray(String type, String natureChoice, int dimension) {
    //     Object result = arrayGeneratorGeneral(type, dimension, natureChoice);
    //     System.out.print(natureChoice + " " + type + " array:");
        
    //     // Check the type of the result and print accordingly
    //     if (result instanceof int[]) {
    //         System.out.println(Arrays.toString((int[]) result));
    //     } else if (result instanceof String[]) {
    //         System.out.println(Arrays.toString((String[]) result));
    //     } else if (result instanceof double[]) {
    //         System.out.println(Arrays.toString((double[]) result));
    //     } else if (result instanceof float[]) {
    //         System.out.println(Arrays.toString((float[]) result));
    //     } else if (result instanceof char[]) {
    //         System.out.println(Arrays.toString((char[]) result));
    //     } else if (result instanceof Integer[]) {
    //         System.out.println(Arrays.toString((Integer[]) result));
    //     } else if (result instanceof byte[]) {
    //         System.out.println(Arrays.toString((byte[]) result));
    //     } else {
    //         System.out.println("Unsupported array type");
    //     }
    // }
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> T[] arrayGeneratorGeneral(String type, int dimension, String typeOfTheArray){
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

        switch (type) {
        case "int":
            int[] intArray = IntArrayGenerator.intArrayGenerator(dimension, choice);
            Integer[] boxedIntArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
            return (T[]) boxedIntArray;
        case "String":
            return (T[]) StringArrayGenerator.stringArrayGenerator(dimension, choice);
        case "double":
            double[] doubleArray = DoubleArrayGenerator.doubleArrayGenerator(dimension, choice);
            Double[] boxedDoubleArray = Arrays.stream(doubleArray).boxed().toArray(Double[]::new);
            return (T[]) boxedDoubleArray;
        case "float":
            float[] floatArray = FloatArrayGenerator.floatArrayGenerator(dimension, choice);
            Float[] boxedFloatArray = Arrays.stream(floatArray).boxed().toArray(Float[]::new);
            return (T[]) boxedFloatArray;
        case "char":
            char[] charArray = CharArrayGenerator.charArrayGenerator(dimension, choice);
            Character[] boxedCharArray = Arrays.stream(charArray).boxed().toArray(Character[]::new);
            return (T[]) boxedCharArray;
        case "Integer":
            return (T[]) IntegerArrayGenerator.intArrayGenerator(dimension, choice);
        case "byte":
            return (T[]) ByteArrayGenerator.byteArrayGenerator(dimension, choice);
        default:
            throw new IllegalArgumentException("Unsupported type: " + type);
    }
        return null;
    }   
}
