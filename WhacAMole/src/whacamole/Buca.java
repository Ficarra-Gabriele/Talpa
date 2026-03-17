/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whacamole;

/**
 *
 * @author ficarra.gabriele
 */
public class Buca {

    private int idBuca;
    private Talpa talpaContenuta;

    public Buca(int idBuca) {
        this.idBuca = idBuca;
    }

    public synchronized boolean isOccupata() {
        return talpaContenuta != null;
    }

    public synchronized void setTalpa(Talpa t) {
        while (talpaContenuta != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.talpaContenuta = t;
        notifyAll();
    }

    public synchronized Talpa prendiTalpa() {
        while (talpaContenuta == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Talpa t = talpaContenuta;
        this.talpaContenuta = null;
        notifyAll();
        return t;
    }
    
    public synchronized void svuota() {
        this.talpaContenuta = null;
        notifyAll();
    }

    public int getIdBuca() {
        return idBuca;
    }
}