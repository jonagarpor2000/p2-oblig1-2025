/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaz;

import dominio.Jugador;
import dominio.Sistema;

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
        Interfaz interfaz = new Interfaz(sys);
        
        //interfaz.mostrarTablero();
        //interfaz.fuegosArtificiales("Generico");
    }
    

    
}
