/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whacamole;

import java.util.Timer;

/**
 *
 * @author ficarra.gabriele
 */
public class Talpa {

    TipoTalpa tipo;
    int punteggioValore;

    public Talpa(TipoTalpa tipo) {
        this.tipo = tipo;
        if (tipo == TipoTalpa.BIANCA) {
            this.punteggioValore = 4;
        } else {
            this.punteggioValore = 2;
        }
    }

    public int getPunteggioValore() {
        return punteggioValore;
    }

    public TipoTalpa getTipo() {
        return tipo;
    }

}
