/**
 * Abstrakte Oberklasse fuer die Sortierverfahren
 * 
 * Unterklassen muessen die Methode sortieren implementieren, welche die feldkopie sortiert
 * @author ts12345
 * @version 1.0
 */
public abstract class Sortierverfahren {
    protected int[] feld;
    protected int[] feldkopie;
    protected long dauer;

    /**
     * Kopie des feldes anlegen
     */
    public void kopieVonFeldErstellen() {
        if(feldkopie == null) feldkopie = new int[feld.length];

        for(int i = 0; i < feld.length; i++) { feldkopie[i] = feld[i]; }
    } 

    /**
     * Die Kopie des feldes soll sortiert werden
     */
    public abstract void sortieren(); 

    /**
     * Zeitmessung erstellen
     */
    public void zeitmessungErstellen() {
        int nrIterations = 10;
        long[] zeiten = new long[nrIterations];

        long startzeit, endzeit;

        // Sortieren mehrmals wiederholen, um aeussere Einfluesse zu reduzieren
        for(int i = 0; i < nrIterations; i++) {
            kopieVonFeldErstellen();
            startzeit = System.nanoTime();
            sortieren();
            endzeit = System.nanoTime();
            zeiten[i] = endzeit - startzeit;
        }        

        // Minimal benötigte Zeit ermitteln
        dauer = zeiten[0];               
        for(int i = 1; i < nrIterations; i++) {
            if(dauer > zeiten[i]) dauer = zeiten[i];        
        }
    }

    /**
     * gibt dauer zurueck
     */
    public long getDauer() { return dauer; }   

    public void setFeld(int[] feld) {
        this.feld = feld;
        feldkopie = null;
    }

    public void printField() {
        for(int i = 0; i < feld.length; i++) { System.out.println(feld[i]); }
    } 
}