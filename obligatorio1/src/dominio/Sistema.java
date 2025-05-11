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
    private final ArrayList <Jugador> listaJugadores;
    private boolean requiereContacto = false;
    private boolean largoFijo = true;
    private int largoDefault = 4;
    private int minLargo = 1;
    private int maxLargo = 4;
    private int maximoBandas = 10;
    private int numTableros = 1;

    public boolean isRequiereContacto() {
        return requiereContacto;
    }

    public void setRequiereContacto(boolean requiereContacto) {
        this.requiereContacto = requiereContacto;
    }

    public boolean isLargoFijo() {
        return largoFijo;
    }

    public void setLargoFijo(boolean largoFijo) {
        this.largoFijo = largoFijo;
    }

    public int getLargoDefault() {
        return largoDefault;
    }

    public void setLargoDefault(int largoDefault) {
        this.largoDefault = largoDefault;
    }

    public int getMinLargo() {
        return minLargo;
    }

    public void setMinLargo(int minLargo) {
        this.minLargo = minLargo;
    }

    public int getMaxLargo() {
        return maxLargo;
    }

    public void setMaxLargo(int maxLargo) {
        this.maxLargo = maxLargo;
    }

    public int getMaximoBandas() {
        return maximoBandas;
    }

    public void setMaximoBandas(int maximoBandas) {
        this.maximoBandas = maximoBandas;
    }

    public int getNumTableros() {
        return numTableros;
    }

    public void setNumTableros(int numTableros) {
        this.numTableros = numTableros;
    }

    public ArrayList <Jugador> getListaJugadores() {
        return listaJugadores;
    }
    
    public void registrarJugador(Jugador player) {
        this.listaJugadores.add(player);
    }
    
    
    public Sistema(){
        listaJugadores = new ArrayList<>();
    }
    
   
    public void ordenarScoreDec(){
        Collections.sort(listaJugadores, new CriterioScoreDecreciente());
    }
    
    private class CriterioScoreDecreciente implements Comparator<Jugador>{
    @Override
    public int compare(Jugador p1, Jugador p2){
        return p2.getPuntaje()-p2.getPuntaje();
        }
    }
}

