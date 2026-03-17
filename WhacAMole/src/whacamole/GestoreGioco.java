/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whacamole;

import java.util.*;

/**
 *
 * @author ficarra.gabriele
 */
public class GestoreGioco implements Runnable {

    private List<Buca> buche;
    private Giocatore giocatore;
    private Classifica registro;
    private Random random = new Random();
    private boolean inCorso = false;

    public GestoreGioco(int nBuche) {
        this.buche = new ArrayList<>();
        for (int i = 0; i < nBuche; i++) {
            buche.add(new Buca(i));
        }
        this.giocatore = new Giocatore();
        this.registro = new Classifica();
    }

    public void setInCorso(boolean stato) {
        this.inCorso = stato;
    }

    @Override
    public void run() {
        while (inCorso) {
            selezionaBucaLibera();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void selezionaBucaLibera() {
        for (Buca b : buche) {
            b.svuota();
        }
        int ind = random.nextInt(buche.size());
        TipoTalpa tipoScelto = (random.nextDouble() > 0.8) ? TipoTalpa.BIANCA : TipoTalpa.NORMALE;
        buche.get(ind).setTalpa(new Talpa(tipoScelto));
    }

    public int calcolaPunteggio(int idBuca) {
        Buca b = buche.get(idBuca);
        if (b.isOccupata()) {
            Talpa t = b.prendiTalpa();
            int punti = t.getPunteggioValore();
            giocatore.aggiungiPunti(punti);
            return punti;
        } else {
            giocatore.aggiungiPunti(-2);
            return -2;
        }
    }

    public List<Buca> getBuche() {
        return buche;
    }

    public int getPunteggioTotale() {
        return giocatore.getPunteggio();
    }

    public void registraRisultato(String nome) {
        registro.salvaPunteggio(nome, giocatore.getPunteggio());
    }
}