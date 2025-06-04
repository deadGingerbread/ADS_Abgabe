package src.main;

import de.medieninf.ads.ADSTool;

public class Aufgabe1 extends ADSTool.Sort {

        public static void main(String[] args) {
        // Example array
        int[] a = { 5, 3, 4, 2, 0, 2, 1, 4, 2, 7, 3, 2 };
        int m = 10;
        Aufgabe1 Aufgabe1 = new Aufgabe1();

        System.out.println("Array vor dem sortieren");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

        Aufgabe1.sort(a);

        System.out.println();
        System.out.println("Small problem:");

        Aufgabe1.runSmall();

        System.out.println();
        System.out.println("Large problem:");

        Aufgabe1.runLarge();

        System.out.println("Array nach dem Sortieren:");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    /**
     * Sorts the array using the Counting Sort algorithm.
     * This method first determines the maximum value in the array and then
     * calls the overloaded sort method with the array and the maximum value.
     *
     * @param a The array to be sorted.
     */
    @Override
    public void sort(int[] a) {
        int m = findeMax(a) + 1;
        sort(a, m);
    }

    /**
     * Finds the maximum value in the given array.
     *
     * @param a The array to search for the maximum value.
     * @return The maximum value in the array.
     */
    private int findeMax(int[] a) {
        int max = a[0];
        for (int val : a) {
            if (val > max)
                max = val;
        }
        return max;
    }

    /**
     * Sorts the given integer array using the Counting Sort algorithm.
     *
     * @param a The array to be sorted.
     * @param m The upper bound (maximum value + 1) for the counting array.
     */
    public void sort(int[] a, int m) {
        int[] zaehler = new int[m];

        // Count occurrences of each element in the array
        for (int e : a) {
            zaehler[e]++;
        }

        // Reconstruct the array based on the counts
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < zaehler[i]; j++) {
                a[index] = i;
                index++;
            }
        }
    }
}