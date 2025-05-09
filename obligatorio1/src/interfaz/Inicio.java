/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaz;

import dominio.Jugador;
import dominio.Sistema;
import dominio.Tablero;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Nahuel Paroldo
 * @author Jonathan Garcia
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema sys = new Sistema();
        Interfaz.menu(sys);
        sys.registrarJugador(new Jugador("Roberto",18));
        //mostrarTablero();        
        //Interfaz.fuegosArtificiales();

    }
    
    public static void mostrarTablero(){
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
            Interfaz.mostrarTablero();
        } catch (java.io.UnsupportedEncodingException e) {
            System.err.println("Encoding no soportado: " + e.getMessage());
        }

    }
    
}
