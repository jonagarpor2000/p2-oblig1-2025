/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Nahuel Paroldo
 * @author Jonathan Garcia
 */
public class Jugador implements Comparable<Jugador>{
    private int puntaje;
    private String nombre;
    private int edad;
    private int racha;
    private List<Jugador> listaJugadores;
    
    public Jugador (String nombre,int edad){
        this.nombre = nombre;
        this.edad = edad;
        this.puntaje = 0;
        this.racha = 0;
    }
    
    public int getRacha() {
        return racha;
    }

    public void setRacha(int racha) {
        this.racha = racha;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    public void reiniciarRacha() {
        this.racha = 0;
        setRacha(0);
    }
    
    public void anotarVictoria() {
        this.puntaje++;
        this.racha++;
    }
    
    public Jugador buscarJugadorPorNombre(String nombre) {
        for (Jugador jugador : listaJugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                return jugador;
            }
        }
        return null;
    }
    
    @Override
    public int compareTo(Jugador otro) {
        return otro.puntaje - this.getPuntaje();
    }
    
    @Override
    public String toString() {
        return String.format("%s (edad: %d) - Ganadas: %d, Racha: %d", nombre, edad, puntaje, racha);
    }
    
    @Override
    public boolean equals(Object obj){
        Jugador player = (Jugador)obj;
        return this.getNombre()== player.getNombre();
    }
    


    
    
}
