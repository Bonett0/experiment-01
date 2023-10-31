public class StringArrayGenerator{

    public static void main(String[] args) {
      
    }
    public static String[] stringArrayGenerator(int dimension, int natureChoice){
        switch (natureChoice) {
            case 1:
                return generateRandomStringArray(dimension);
            case 2:
                return generateSortedStringArray(dimension);
            case 3:
                return generatePartiallySortedStringArray(dimension);
            case 4:
                return generateReverseSortedStringArray(dimension);
            case 5:
                return generateRandomStringArrayWithDuplicates(dimension);
            case 6:
                return generateRandomStringArrayWithoutDuplicates(dimension);
            case 7:
                return generateEqualStringArray(dimension);
        }
        return null;
    }
     private static String[] generateRandomStringArray(int length) {
        String[] array = new String[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = generateRandomString(random, 5); // Adjust the string generation as needed
        }
        return array;
    }

    // Generate a sorted string array
    private static String[] generateSortedStringArray(int length) {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = "String" + i;
        }
        return array;
    }

    // Generate a reverse sorted string array
    private static String[] generateReverseSortedStringArray(int length) {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = "String" + (length - i);
        }
        return array;
    }

    // Helper method to generate a random string
    private static String generateRandomString(Random random, int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }
        return sb.toString();
    }


    // Generate a partially sorted string array
    private static String[] generatePartiallySortedStringArray(int length) {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = "String" + i;
        }

        // Shuffle a portion of the array to make it partially sorted
        Random random = new Random();
        for (int i = 0; i < length / 3; i++) {
            int index1 = random.nextInt(length);
            int index2 = random.nextInt(length);
            String temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }

        return array;
    }
    private static int[] generateEqualStringArray(int length) {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = "String";
        }
        return array;
    }
}