import java.util.Random;

public class FloatArrayGenerator{
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
    public static float[] floatArrayGenerator(int dimension, int natureChoice){
        switch (natureChoice) {
            case 1:
                return generateRandomFloatArray(dimension);
            case 2:
                return generateSortedFloatArray(dimension);
            case 3:
                return generatePartiallySortedFloatArray(dimension);
            case 4:
                return generateReverseSortedFloatArray(dimension);
            case 5:
                return generateRandomFloatArrayWithDuplicates(dimension);
            case 6:
                return generateRandomFloatArrayWithoutDuplicates(dimension);
            case 7:
                return generateEqualFloatArray(dimension);
        }
        return null;
    }
    private static float[] generateRandomFloatArray(int length) {
        float[] array = new float[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextFloat(); // Generates a random float between 0.0 (inclusive) and 1.0 (exclusive)
        }
        return array;
    }

    private static float[] generateSortedFloatArray(int length) {
        float[] array = new float[length];
        for (int i = 0; i < length; i++) {
            array[i] = (float) i; // Assuming you want to generate floats in sequence
        }
        return array;
    }

    private static float[] generatePartiallySortedFloatArray(int length) {
        float[] array = new float[length];
        for (int i = 0; i < length; i++) {
            array[i] = (float) i;
        }

        // Shuffle a portion of the array to make it partially sorted
        Random random = new Random();
        for (int i = 0; i < length / 3; i++) {
            int index1 = random.nextInt(length);
            int index2 = random.nextInt(length);
            float temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }

        return array;
    }

    private static float[] generateReverseSortedFloatArray(int length) {
        float[] array = new float[length];
        for (int i = 0; i < length; i++) {
            array[i] = (float) (length - i - 1); // Generating floats in reverse order
        }
        return array;
    }

    private static float[] generateRandomFloatArrayWithDuplicates(int length) {
        float[] array = new float[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextFloat(); // Generates a random float between 0.0 (inclusive) and 1.0 (exclusive)
        }
        return array;
    }

    private static float[] generateRandomFloatArrayWithoutDuplicates(int length) {
        float[] array = new float[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextFloat() * 10; // Adjust the range as needed
        }
        return array;
    }

    private static float[] generateEqualFloatArray(int length) {
        return generateEqualFloatArray(length, 1.0f);
    }

    private static float[] generateEqualFloatArray(int length, float value) {
        float[] array = new float[length];
        for (int i = 0; i < length; i++) {
            array[i] = value;
        }
        return array;
    }

}