/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.*;

/**
 *
 * @author Nahuel Paroldo
 * @author Jonathan Garcia
 */

//Configuracion queda aca adentro  y partida tambien
public class Sistema {
    private ArrayList <Jugador> listaJugadores;
    
    public ArrayList <Jugador> getListaJugadores() {
        return listaJugadores;
    }
    
    public void registrarJugador(Jugador player) {
        this.listaJugadores.add(player);
    }
    
    public boolean esJugadorRegistrado(String nombre){
        return getListaJugadores() != null && getListaJugadores().contains(nombre);
    }
    
    public Sistema(){
        listaJugadores = new ArrayList<>();
    }
    
   
    public void ordenarScoreDec(){
        Collections.sort(listaJugadores, new CriterioScoreDecreciente());
    }
    
    private class CriterioScoreDecreciente implements Comparator<Jugador>{
    public int compare(Jugador p1, Jugador p2){
        return p2.getPuntaje()-p2.getPuntaje();
        }
    }
}

