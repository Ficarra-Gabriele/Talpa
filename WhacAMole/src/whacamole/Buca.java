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
    
    String idBuca;
    boolean occupata;
    
    public int  colpita(){
        if (occupata == false){
            return -2;
        }
        else{
            return +2;
        }
    }
}
