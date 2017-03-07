/**
 * Implementation von InsertSort
 */
public class InsertSort extends Sortierverfahren {
    public InsertSort(int[] feld) { this.feld = feld; }
    
    public void sortieren() {
        for (int i = 1; i<feldkopie.length; i++) {
            int aktuell = feldkopie[i];
            int compareto = i-1;
            
            while((compareto>=0)&&(aktuell < feldkopie[compareto])) {
                feldkopie[compareto+1]=feldkopie[compareto];
                compareto--;
            }
            
            feldkopie[compareto+1]=aktuell;
        }
    }
}