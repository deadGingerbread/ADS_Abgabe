package src.main;

import de.medieninf.ads.ADSTool;

/**
 * Aufgabe2 demonstrates the implementation of the Shell Sort algorithm.
 * It extends the ADSTool.Sort class and provides sorting functionality
 * for integer arrays.
 */
public class Aufgabe2 extends ADSTool.Sort {

    /**
     * The main method serves as the entry point for the program.
     * It initializes an integer array, sorts it using the Shell Sort algorithm,
     * and prints the array before and after sorting.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[] a = { 98, 23, 77, 33, 76, 24, 95, 18, 76, 23, 66, 11 };
        Aufgabe2 aufgabe2 = new Aufgabe2();

        System.out.println("Feld vor dem Sortieren.");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

        aufgabe2.sort(a);
        System.out.println();
        System.out.println("Small problem:");
        aufgabe2.runSmall();
        System.out.println();
        System.out.println("Large problem:");
        aufgabe2.runLarge();

        System.out.println("Feld nach dem Sortieren.");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    /**
     * Sorts the given integer array using the Shell Sort algorithm.
     * Shell Sort is an optimization of insertion sort that allows the exchange
     * of far apart elements to reduce the number of swaps.
     *
     * @param a The array to be sorted.
     */
    @Override
    public void sort(int[] a) {
        int n = a.length;

        // Start with a gap and reduce it each iteration
        // Perform sorting while the gap is greater than 0
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Perform insertion sort for elements separated by the gap
            for (int i = gap; i < n; i++) {
                int temp = a[i]; // Current value to be inserted at the correct position
                int j = i;      // Start index for comparison and shifting

                // Shift elements that are greater than temp
                while (j >= gap && a[j - gap] > temp) {
                    a[j] = a[j - gap];  // Move larger element to the right
                    j -= gap;  // Move back to compare further
                }

                // Place temp at its correct position
                a[j] = temp;  
            }
        }
    }
}