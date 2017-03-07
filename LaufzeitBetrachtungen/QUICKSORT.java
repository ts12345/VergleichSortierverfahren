/**
 * Implementation von Quicksort
 * nach https://de.wikipedia.org/wiki/Quicksort
 * 
 * @author SFr682k
 * @version 2017-03-07
 */

public class QUICKSORT extends Sortierverfahren {
    int[] array;
    int cache1, cache2;
    
    public QUICKSORT(int[] feld) { this.feld = feld; }

    public void sortieren() {
        array = feldkopie;
        
        int links = 0;
        int rechts = array.length - 1;
        
        quicksort(links, rechts);
    }
    
    private void quicksort(int links, int rechts) {
        if (links < rechts) {
            int teiler = teile(links, rechts);
            quicksort(links, teiler - 1);
            quicksort(teiler + 1, rechts);
        }
    }
    
    private int teile(int links, int rechts) {
        int i = links;
        int j = rechts;
        int pivot = array[rechts];
        
        do {
            while ( (array[i] <= pivot) && (i < rechts) ) { i = i + 1; }
            while ( (array[j] >= pivot) && (j > links) )  { j = j - 1; }
        
            if ( i < j ) {
                cache1 = array[i];
                cache2 = array[j];
                array[i] = cache2;
                array[j] = cache1;
            }
        } while (i < j);
        
        if ( array[i] > pivot ) {
            cache1 = array[i];
            cache2 = array[rechts];
            array[i] = cache2;
            array[rechts] = cache1;
        }
        
        return i;
    }
    
    public int[] getArray() { return array; }
}