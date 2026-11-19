public class Main {
    static void main() {

        int[] values = Sorts.initValues(50);

        System.out.println("Original Array:");
        Sorts.printValues(values);

        Sorts.mergeSort(values);

        System.out.println("\nSorted Array:");
        Sorts.printValues(values);

        System.out.println("\nVerification: " + Sorts.isSorted(values));
    }
}
