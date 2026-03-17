/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whacamole;

/**
 *
 * @author ficarra.gabriele
 */
public class Giocatore {
    private int punteggioAttuale = 0;

    public synchronized void aggiungiPunti(int punti) {
        if (punteggioAttuale + punti >= 0) {
            this.punteggioAttuale += punti;
        } else {
            this.punteggioAttuale = 0;
        }
    }

    public synchronized int getPunteggio() {
        return punteggioAttuale;
    }
}