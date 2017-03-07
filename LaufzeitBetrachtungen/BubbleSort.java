import java.util.Random;

/**
 * Implementation von BubbleSort
 * 
 * @author wor0r
 */
public class BubbleSort extends Sortierverfahren {
    public BubbleSort(int[] feld) { this.feld = feld; }

    public void sortieren() {
        int roundsCount = 0;
        while(roundsCount < feld.length-1) {
            roundsCount = 0;
            for(int j = 0; j <= feld.length; j++) {
                if(j+1<feld.length) {
                    if(feld[j] > feld[j+1]) {
                        int tausch = feld[j];
                        feld[j] = feld[j+1];
                        feld[j+1] = tausch; 
                    }else roundsCount++;
                }
            }   
        }
    }

    public void randTest() {
        feld = new int[20];
        Random rand = new Random(); 
        for(int i = 0; i < feld.length; i++) {
            feld[i]= rand.nextInt(feld.length)+1;
            System.out.println(feld[i]);
        }
    }
}