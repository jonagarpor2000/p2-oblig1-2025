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
    private int largoDefault = 4;
    private int maximoBandas = 10;
    private int numTableros = 1;

    public boolean isRequiereContacto() {
        return requiereContacto;
    }

    public void setRequiereContacto(boolean requiereContacto) {
        this.requiereContacto = requiereContacto;
    }

    public int getLargoDefault() {
        return largoDefault;
    }

    public void setLargoDefault(int largoDefault) {
        this.largoDefault = largoDefault;
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
    
    public void comprobarMinJugadores(){
    
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
    
    public void setConfiguraciones(int largoBandas, boolean contacto,int cantBandas,int cantTableros){
        this.setLargoDefault(largoBandas);
        this.setRequiereContacto(contacto);
        this.setMaximoBandas(cantBandas);
        this.setNumTableros(cantTableros);
    }
    
    
    
    public ArrayList <Jugador> ObtenerJugadoresExcluidos(String nombre, ArrayList<Jugador> playerexcluded){
        ArrayList <Jugador> res = new ArrayList<>();
        for (Jugador jugador : playerexcluded) {
            if (!(jugador.getNombre().equals(nombre))) {
                res.add(jugador);
            }
        }
        return res;
    }
    public Jugador obtenerJugador(String nombre){
        for (Jugador j : this.getListaJugadores()) {
          if (j.getNombre().equalsIgnoreCase(nombre)) {
              return j;
          }
      }
      return null;
    }
    
    public int[][] decodificarJugada(Partida game,String input){
        int[][] jugada = new int[1][1];
        boolean letraencontrada = false;
        try{
            char letra = input.charAt(0);
            int fila = Integer.parseInt(input.substring(1,2));
            char direccion = input.charAt(2);
            int largo=Integer.parseInt(input.substring(1,2));
            char[] abc = game.getTablero().getAbecedario();
            
            for (int i = 0; i < abc.length && !letraencontrada; i++) {
                if(letra == abc[i]){
                    jugada[0][0] = i;
                    letraencontrada=true;
                }
            }
            
            switch(direccion){
                case'Q':
                case 'q':
            }
        }catch(NumberFormatException e){
        
        }
        
        return jugada;
    }
    
    
}

