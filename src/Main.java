public class Main {
    static void main() {

        int[] original = Sorts.initValues(50);

        int[] selectionValues = original.clone();
        int[] mergeValues = original.clone();

        benchmark(10_000, true);

        benchmark(1_000_000, false);

        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] reversed = {8, 7, 6, 5, 4, 3, 2, 1};

        int[] identical = {5, 5, 5, 5, 5, 5, 5, 5};

        testEdgeCase("Already Sorted", sorted);
        testEdgeCase("Reverse Sorted", reversed);
        testEdgeCase("Identical Elements", identical);
    }
    public static void benchmark(int size, boolean runSelection) {
        int[] original = Sorts.initValues(size);

        int[] selectionValues = original.clone();
        int[] mergeValues = original.clone();

        System.out.println("\nArray size: " + size);

        if (runSelection) {
            long start = System.nanoTime();

            Sorts.selectionSort(selectionValues);

            long end = System.nanoTime();

            System.out.printf("Selection Sort: %.3f ms%n",
                    (end - start) / 1_000_000.0);

            System.out.println("Selection verified: " +
                    Sorts.isSorted(selectionValues));
        } else {
            System.out.println("Selection Sort: Skipped (too expensive)");
        }

        long start = System.nanoTime();

        Sorts.mergeSort(mergeValues);

        long end = System.nanoTime();

        System.out.printf("Merge Sort: %.3f ms%n",
                (end - start) / 1_000_000.0);

        System.out.println("Merge verified: " +
                Sorts.isSorted(mergeValues));
    }
    public static void testEdgeCase(String description, int[] values) {
        int[] selectionValues = values.clone();
        int[] mergeValues = values.clone();

        Sorts.selectionSort(selectionValues);
        Sorts.mergeSort(mergeValues);

        System.out.println("\n" + description);

        System.out.println("Selection Sort: " +
                Sorts.isSorted(selectionValues));

        System.out.println("Merge Sort: " +
                Sorts.isSorted(mergeValues));
    }
}
