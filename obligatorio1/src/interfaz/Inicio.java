/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaz;

import dominio.Tablero;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Jona
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Interfaz.menu();
        mostrarTablero();
        //Interfaz.fuegosArtificiales();

    }
    
    public static void mostrarTablero(){
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (java.io.UnsupportedEncodingException e) {
            System.err.println("Encoding no soportado: " + e.getMessage());
        }
        /*Tablero t = new Tablero();
        t.mostrarTablero();*/
    }
    
}
