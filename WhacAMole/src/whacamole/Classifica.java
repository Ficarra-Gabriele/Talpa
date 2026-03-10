/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whacamole;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ficarra.gabriele
 */
public class Classifica {

    private String filePath = "classifica.txt";

    public void salvaPunteggio(String nome, int punteggio) {
        List<String> record = leggiClassifica();
        record.add(nome + ":" + punteggio);

        record.sort((a, b) -> {
            int puntiA = Integer.parseInt(a.split(":")[1]);
            int puntiB = Integer.parseInt(b.split(":")[1]);
            return Integer.compare(puntiB, puntiA);
        });

        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            for (String r : record) {
                out.println(r);
            }
        } catch (IOException e) {
            System.err.println("Errore nel salvataggio: " + e.getMessage());
        }
    }

    public List<String> leggiClassifica() {
        List<String> righe = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                righe.add(linea);
            }
        } catch (IOException e) {
            
              System.err.println("Errore nella lettura: " + e.getMessage());
        }
        return righe;
    }
}