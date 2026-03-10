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

    private String nome;
    private int punteggioAttuale = 0;

    public void aggiungiPunti(int punti) {
        if (punteggioAttuale >= 0){
            
        this.punteggioAttuale += punti;
        
        }
        
        else{
            System.err.println("Non puoi andare sotto zero");
        }
    }

    public int getPunteggio() {
        return punteggioAttuale;
    }

    public void talpaMancata() {
        System.out.println("Hai mancato la talpa");
    }
}
