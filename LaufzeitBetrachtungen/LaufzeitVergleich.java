
package LaufzeitBetrachtungen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class LaufzeitVergleich
{
    private  ArrayList<Sortierverfahren> sortierverfahren;
    private  int[] feldgroessen;
    private HashMap<Sortierverfahren, long[]> laufzeiten;

    public LaufzeitVergleich()    
    {
        sortierverfahren = new ArrayList<Sortierverfahren>();
        sortierverfahren.add(new BubbleSort(null));
        sortierverfahren.add(new GnomeSort(null));
        sortierverfahren.add(new InsertSort(null));

        feldgroessen = new int[] { 10, 31, 100, 316, 1000, 3162, 10000,  31622 };  // 100000 };

        laufzeiten = new HashMap<Sortierverfahren, long[]>();

        for(Sortierverfahren s : sortierverfahren) {
            laufzeiten.put(s, new long[feldgroessen.length]);
        }

        for(int i = 0; i < feldgroessen.length; i++) {
            int size = feldgroessen[i];
            int range = size * 2;
            int[] field = getRandomField(size, range);            

            for(Sortierverfahren s : sortierverfahren) {
                s.setFeld(field);
                s.zeitmessungErstellen();
                laufzeiten.get(s)[i] = s.getDauer();
            }
        }
    }

    public void showResults() {
        for(Sortierverfahren s : sortierverfahren) {
            System.out.println(s);
            long[] zeiten = laufzeiten.get(s);
            for(int i = 0; i < feldgroessen.length; i++) {
                System.out.format("%12d", feldgroessen[i]);
            }
            System.out.println();
            for(int i = 0; i < feldgroessen.length; i++) {
                System.out.format("%12d", zeiten[i]);
            }
            System.out.println();
            for(int i = 0; i < feldgroessen.length; i++) {
                System.out.format("%12f", Math.log(zeiten[i]));
            }
            System.out.println();

        }
    }

    public static int[] getRandomField(int size, int range) {
        Random r = new Random();
        int[] field = new int[size];
        for(int i = 0; i < size; i++) {
            field[i] = r.nextInt(range);
        }
        return field;   
    }

}
