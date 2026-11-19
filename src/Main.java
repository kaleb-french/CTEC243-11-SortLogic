public class Main {
    static void main() {

        int[] values = Sorts.initValues(50);

        System.out.println("Generated Array:");
        Sorts.printValues(values);

        System.out.println("Is sorted? " + Sorts.isSorted(values));
    }
}
