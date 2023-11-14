import java.util.Random;

public class ByteArrayGenerator{

    public static void main(String[] args) {
      
    }
    public static byte[] byteArrayGenerator(int dimension, int natureChoice){
        switch (natureChoice) {
            case 1:
                return generateRandomByteArray(dimension);
            case 2:
                return generateSortedByteArray(dimension);
            case 3:
                return generatePartiallySortedByteArray(dimension);
            case 4:
                return generateReverseSortedByteArray(dimension);
            case 5:
                return generateEqualByteArray(dimension, (byte) 0);
        }
        return null;
    }
    private static byte[] generateRandomByteArray(int length) {
        byte[] array = new byte[length];
        Random random = new Random();
        random.nextBytes(array); // Fills the array with random bytes
        return array;
    }

    private static byte[] generateSortedByteArray(int length) {
        byte[] array = new byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = (byte) i; // Assuming you want to generate bytes in sequence
        }
        return array;
    }

    private static byte[] generateReverseSortedByteArray(int length) {
        byte[] array = new byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = (byte) (length - i - 1); // Generating bytes in reverse order
        }
        return array;
    }

    private static byte[] generatePartiallySortedByteArray(int length) {
        byte[] array = new byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = (byte) i;
        }

        // Shuffle a portion of the array to make it partially sorted
        Random random = new Random();
        for (int i = 0; i < length / 3; i++) {
            int index1 = random.nextInt(length);
            int index2 = random.nextInt(length);
            byte temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }

        return array;
    }

    private static byte[] generateEqualByteArray(int length, byte value) {
        byte[] array = new byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = value;
        }
        return array;
    }
}