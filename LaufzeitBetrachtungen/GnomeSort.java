package LaufzeitBetrachtungen;

/**
 * Implementation von GnomeSort
 * nach https://en.wikipedia.org/wiki/Gnome_sort
 * 
 * @author ts12345
 * @version 1.0
 */

public class GnomeSort extends Sortierverfahren
{
    public GnomeSort(int[] feld)
    {
        this.feld = feld;
    }

    public void sortieren() {
        // Umbenunng um Lesbarkeit zu erhoehen
        // a = array
        int[] a = feldkopie;

        int pos = 0;

        
        while(pos < a.length) {
            if(pos == 0 || a[pos] >= a[pos - 1]) {
                pos = pos + 1;                
            } 
            else {
                
                swap(pos, pos - 1);
                pos = pos - 1;
            }
        }

        
    }
    
    /**
     * vertauscht die Elemnte feldkopie[p1] und feldkopie[p2]
     */
    public void swap(int p1, int p2) {
        int tmp = feldkopie[p1];
        feldkopie[p1] = feldkopie[p2];
        feldkopie[p2] = tmp;
    }

}
