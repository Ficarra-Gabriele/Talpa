/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whacamole;

import javax.swing.JButton;

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

    public boolean isOccupata() {
        if (talpaContenuta != null) {
            return true;
        } else {
            return false;
        }
    }

    public void setTalpa(Talpa t) {
        this.talpaContenuta = t;
    }

    public Talpa getTalpa() {
        return talpaContenuta;
    }

    public void svuota() {
        this.talpaContenuta = null;
    }
}
