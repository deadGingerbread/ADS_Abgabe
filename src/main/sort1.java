package src.main;

import de.medieninf.ads.ADSTool;

public class sort1 extends ADSTool.Sort {

    public static void main(String[] args) {
        // beispiel array
        int[] a = { 5, 3, 4, 2, 0, 2, 1, 4, 2, 7, 3, 2 };
        int m = 10;
        sort1 sort1 = new sort1();

        System.out.println("Array vor dem sortieren");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

        sort1.sort(a);
        sort1.runSmall();
        //sort1.runLarge();

        System.out.println("Array nach dem Sortieren:");
        for (int i : a) {
           // System.out.print(i + " ");
        }
    }

    @Override
    public void sort(int[] a) {
      
        int m = findeMax(a) + 1;
        sort(a, m); 
    }

    // Hilfsmethode, um das Maximum zu finden
    private int findeMax(int[] a) {
        int max = a[0];
        for (int val : a) {
            if (val > max)
                max = val;
        }
        return max;
    }

    /**
     * 
     * @param m Oberere Grenze
     *          in zaehler wird die jeweilige häufigkeit gespeicher
     *          e = der stelle im array
     *          k = wert der akt. stelle e
     *          m =
     */
    public void sort(int[] a, int m) {
        int[] zaehler = new int[m];

        // Für jedes Element e in a: zaehler[e] um 1 erhöhen
        for (int e : a) {
            zaehler[e]++;
        }
        // fürs zurückgeben -> für jeden Index i, zaehler[i] mal i ins Array schreiben
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < zaehler[i]; j++) {
                a[index] = i;
                index++;

            }
        }

    }

}