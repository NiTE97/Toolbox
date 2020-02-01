/**
 * Klasse mit verschiedenen Algorithmen
 * 
 * @author nterw
 */
public class Algorithmen {
    
    public static int linearSearch(int [] a, int k){
        for (int i= 0; i < a.length; i++){
            if (a[i] == k){ // k gefunden
                return i;
            }
        }
        return -1; // Ende erreicht
    }
    
    public static int binarySearch(int [] a, int k){
    int l = 0;              // linke Grenze
    int r = a.length - 1;   // rechte Grenze
    
    while (l <= r){
        int m = (l + r)/2;  // Mitte
        if (k < a[m]){      // k ist kleiner
            r = m - 1;
        }else if(k == a[m]){// k ist gleich
            return m;
        }else{              // k ist groesser
            l = m + 1;
        }
    }
    return -1;
}
    
    public static int [] selectionSort(int [] a){
        for(int i = 0; i < a.length; i++){
            // Position des Minimums bestimmen
            int minPos = i;
            for (int j = i; j < a.length; j++){
                if (a[j] < a[minPos]){
                    minPos = j;
                }
            }
            // Minimum an Beginn stellen
            int t = a[i];
            a[i] = a[minPos];
            a[minPos] = t;
        }
        return a;
    }
    
    public static int [] bubbleSort(int [] a){
        // Sortierter Bereich auf a[i] ... a[n-1]
        for (int i = a.length; i > 0; i--){
            // Unsortierter Bereich auf a[0] ... a[i-1]
            for (int j = 0; j < i -1; j++){
                // Werte a[j] und a[j+1] in falscher Reihenfolge?
                if (a[j] > a[j+1]){
                    // Werte vertauschen
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
        return a;
    }
    
    public static int [] insertionSort(int [] a){
        // Betrachte den Wert a[i]
        for (int i = 0; i < a.length; i++){
            // Füge a[i] in a[0] ... a[i-1] ein
            for (int j = i-1; j >= 0; j--){
                if (a[j] > a[j+1]){
                    // Werte vertauschen
                    int t = a[j];
                    a[j] = a [j+1];
                    a[j+1] = t;
                }
            }
        }
        return a;
    }
    
    /**
     * Methode zum Mischen von SORTIERTEN Arrays
     * @param left
     * @param right
     * @return 
     */
    public static int[] merge(int [] left, int [] right){
        // Gemischtes Array
        int [] merged = new int [left.length + right.length];
        
        // Indizes fuer linkes, rechtes und gemischtes Array
        int li = 0;
        int ri = 0;
        int mi = 0;
        
        // Mischen der Werte aus dem linken und rechten Array
        while (li < left.length && ri < right.length){
            if (left[li]  <= right[ri]){
                merged[mi] = left[li];
                li++;
            }else{
                merged[mi] = right[ri];
                ri++;
            }
            mi++;
        }
        
        // Kopieren der restlichen Werte aus dem linken Array
        while (li < left.length){
            merged[mi] = left[li];
            li++;
            mi++;
        }
        
        //Kopieren der restlichen Werte aus dem rechten Array
        while (ri < right.length){
            merged[mi] = right[ri];
            ri++;
            mi++;
        }
        
        //Gemischtes Array zurueckgeben
        return merged;
    }
    
    public static int [] mergeSort(int [] a){
        // Nichts zu tun, falls a hoechstens ein Element enthaelt
        if(a.length <= 1){
            return a;
        }
        
        // Bestimme die Mitte des Arrays
        int m = a.length / 2;
        
        // Kopiere linke Haelfte in ein neues Array
        int [] left = new int[m];
        for (int li = 0; li < left.length; li++){
            left[li] = a[li];
        }
        
        // Kopiere rechte Haelfte in ein neues Array
        int [] right = new int[a.length - m];
        for ( int ri = 0; ri < right.length; ri++){
            right[ri] = a[m + ri];
        }
        
        // Sortieren der beiden Haelften
        int [] leftSorted = mergeSort(left);
        int [] rightSorted = mergeSort(right);
        
        // Mische die beiden Haelften
        return merge(leftSorted, rightSorted);
    }
    
    
    /**
     * Methode zum Vertauschen von zwei Werten in einem Array
     * @param a
     * @param i
     * @param j
     */
    public static void swap ( int [] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    /**
     * Methode zum Partitionieren eines Arrays anhand eines Pivots
     * @param a
     * @param l
     * @param r
     * @param p
     * @return 
     */
    public static int partition (int [] a, int l, int r, int p){
        int pn = 1;
        int pv = a[p];
        
        // Stelle den Pivot ans Ende
        swap (a, p, r);
        
        // Stelle Wert kleiner als Pivot nach rechts
        for (int i = l; i < r; i++){
            if (a[i] <= pv){
                swap(a, pn, i);
                pn++;
            }
        }
        
        // Stelle Pivot an richtige Stelle
        swap (a, r, pn);
        
        return pn;
            }
    
    /**
     * Methode zum Sortieren eines gegebenen Teilbereichs
     * @param a
     * @param l
     * @param r
     * @return 
     */
    public static int [] qsort(int [] a, int l, int r){
        if ( r > l){
            int p = r;
            int pn = partition(a, l, r, p);
            qsort(a, l, pn -1);
            qsort(a, pn + 1, r);            
        }
        return a;
    }
    
    public static int [] quickSort (int [] a){
        return qsort(a, 0, a.length - 1);        
    }
    
    public static int [] countingSort (int [] a){
        // Maximum bestimmen
        int max = -1;
        for (int i = 0; i < a.length; i++){
            if (max < a[i]){
                max = a[i];
            }
        }
        
        // Werte zaehlen
        int [] counts = new int [max + 1];
        for (int i = 0; i < a.length; i++){
            counts[a[i]]++;
        }
        
        // Sortiertes Array erzeugen
        int i = 0;
        for (int j = 0; j < counts.length; j++){
            for ( int k = 0; k < counts[j]; k++){
                a[i] = j;
                i++;
            }
        }
        return a;
    }
    
    public static int fakultaet (int n){
        if (n == 1){
            return 1;
        }else{
            return n * fakultaet(n-1);
        }
    }
    
    public static double radius (double r){
        double PI = 3.14159265358979323846;
        double flaeche = r * r * PI;
        double umfang = 2 * PI * r;
        return flaeche + umfang;
    }
    
    public static long quersumme(long zahl) {
        long quersumme= 0;
        while (zahl> 0) {
            quersumme = quersumme + zahl% 10;
            zahl= zahl/ 10;
        }
        return quersumme;
    }
    
 /**   
  * pow berechnet die Potenz x hoch n für ein positives n
  * 
     * @param x
     * @param n
     * @return 
  */
    public static double pow (double x, int n) {
        assert n >= 0 : "n muss >= 0 sein!";
        double wert = 1.0;
        while (n > 0) {
            wert *= x;
            n--;
        }
        return wert;
    }
    
    /**
     * Testen ob eine uebergebene Zahl positiv ist
     * 
     * @param n
     * @return 
     */
    public static boolean even(int n) {
        return ( n % 2) == 0;
    }
    
    public static long GGT(long m, long n){
        m = Math.abs(m);
        n = Math.abs(n);
        long r = m % n;
        while (r > 0){
            m = n;
            n = r;
            r = m % n;
        }
        return n;
    }
    
    public static boolean isPrime(int candidate) {
        if (candidate <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(candidate); i++) {
            if (candidate % i == 0){
                return false;
            }
        }
        return true;
    }
    
}