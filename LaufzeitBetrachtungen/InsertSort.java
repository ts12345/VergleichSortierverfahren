
/**
 * Implementation von InsertSort
 * 
 */
public class InsertSort extends Sortierverfahren
{
    public InsertSort(int[] feld)
    {
        this.feld = feld;
    }
    
    public void sortieren(){
        for (int i = 1; i<feld.length; i++){
            int aktuell = feld[i];
            int compareto = i-1;
            while((compareto>=0)&&(aktuell < feld[compareto])){
                feld[compareto+1]=feld[compareto];
                compareto--;
            }
            feld[compareto+1]=aktuell;
        }
    }
}
