/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Nahuel Paroldo
 * @author Jonathan Garcia
 */
public class Partida {
    private Jugador j1;
    private Jugador j2;
    private Jugador turno;
    private Tablero tablero;

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    

    public Jugador getJ1() {
        return j1;
    }

    public void setJ1(Jugador j1) {
        this.j1 = j1;
    }

    public Jugador getJ2() {
        return j2;
    }

    public void setJ2(Jugador j2) {
        this.j2 = j2;
    }

    public Jugador getTurno() {
        return turno;
    }

    public void setTurno(Jugador turno) {
        this.turno = turno;
    }
    
    public Partida(){
        tablero = new Tablero(13,25);
    }
    
    // Cambiar el turno al siguiente jugador
    public void cambiarTurno() {
        if (turno == j1) {
            turno = j2;
        } else {
            turno = j1;
        }
    }

    
    public boolean realizarJugada(int fila, int columna) {
        if (tablero.esMovimientoValido(fila, columna, turno)) {
            tablero.realizarMovimiento(fila, columna, turno);
            return true;
        }
        return false;
    }

    
    public Jugador verificarGanador() {
        return tablero.determinarGanador();
    }

    
    public void reiniciarPartida() {
        tablero = new Tablero(13, 25);
        turno = j1;
    }
    
}
