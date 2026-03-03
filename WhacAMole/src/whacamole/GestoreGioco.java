/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whacamole;

import java.util.*;
import javax.swing.Timer;

/**
 *
 * @author ficarra.gabriele
 */
public class GestoreGioco {

    private List<Buca> buche;
    private Giocatore giocatore;
    private Classifica registro;
    private Random random = new Random();

    public GestoreGioco(int nBuche) {
        this.buche = new ArrayList<>();
        for (int i = 0; i < nBuche; i++) {
            buche.add(new Buca(i));
        }
        this.giocatore = new Giocatore();
        this.registro = new Classifica();
    }

    public void selezionaBucaLibera() {
        for (Buca singolaBuca : buche) {
            singolaBuca.svuota();
        }
        int ind = random.nextInt(buche.size());
        TipoTalpa tipoScelto;
        double probabilita = random.nextDouble();
        if (probabilita > 0.8) {
            tipoScelto = TipoTalpa.BIANCA;
        } else {
            tipoScelto = TipoTalpa.NORMALE;
        }

        Talpa nuovaTalpa = new Talpa(tipoScelto);
    }

    public int calcolaPunteggio(int idBuca) {

        Buca b = buche.get(idBuca);
        if (b.isOccupata()) {
            int punti = b.getTalpa().getPunteggioValore();
            giocatore.aggiungiPunti(punti);
            b.svuota();
            return punti;
        } else {
            giocatore.talpaMancata();
            return -2;
        }
    }

    public List<Buca> getBuche() {
        return buche;
    }

    public int getPunteggioTotale() {
        return giocatore.getPunteggio();
    }
}
