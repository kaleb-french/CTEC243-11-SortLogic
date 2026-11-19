import java.util.Random;

public class Sorts {

    public static int[] initValues(int size) {
        Random random = new Random();
        int[] values = new int[size];

        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(1001);
        }

        return values;
    }
    public static boolean isSorted(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] > values[i + 1]) {
                return false;
            }
        }

        return true;
    }
    public static void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
    public static void printValues(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.printf("%5d", values[i]);

            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }
    public static int minIndex(int[] values, int start, int end) {
        int min = start;

        for (int i = start + 1; i <= end; i++) {
            if (values[i] < values[min]) {
                min = i;
            }
        }

        return min;
    }
    public static void mergeSort(int[] values) {
        int[] tempArray = new int[values.length];

        recMergeSort(values, tempArray, 0, values.length - 1);
    }
    public static void selectionSort(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {

            int min = minIndex(values, i, values.length - 1);

            swap(values, i, min);
        }
    }
    private static void merge(
            int[] values, int[] tempArray,
            int first, int middle, int last) {

        int left = first;
        int right = middle + 1;
        int index = first;

        while (left <= middle && right <= last) {
            if (values[left] <= values[right]) {
                tempArray[index++] = values[left++];
            } else {
                tempArray[index++] = values[right++];
            }
        }

        while (left <= middle) {
            tempArray[index++] = values[left++];
        }
        while (right <= last) {
            tempArray[index++] = values[right++];
        }

        for (int i = first; i <= last; i++) {
            values[i] = tempArray[i];
        }
    }
	private static void recMergeSort(int[] values, int[] tempArray, int first, int last) {

        if (first < last) {
            int middle = (first + last) / 2;

            recMergeSort(values, tempArray, first, middle);
            recMergeSort(values, tempArray, middle + 1, last);

            merge(values, tempArray, first, middle, last);
        }
    }
}
