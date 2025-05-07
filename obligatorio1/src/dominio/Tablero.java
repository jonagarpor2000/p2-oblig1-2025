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
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Tablero {
 
    private int filas;
    private int columnas;

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    
    private char[][] tablero;

    public char[][] getTablero() {
        return tablero;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public Tablero(int filas, int columnas) {
        this.columnas = columnas;
        this.filas = filas;
        tablero = new char[filas][columnas];
        inicializarTablero();

    }

    private void inicializarTablero() {
        int ancho = 4;
        for (int i = 0; i < this.getFilas(); i++) {
            for (int j = 0; j < this.getColumnas(); j++) {
                tablero[i][j] = ' '; // Por defecto, no jugable
            }
        }

        int centro = this.getColumnas() / 2;
        for (int i = 0; i < this.getFilas(); i++) {
            int alcance = i <= this.getFilas() / 2 ? i : this.getFilas() - 1 - i;
            for (int j = centro - alcance; j <= centro + alcance; j += 2) {
                tablero[i][j] = '*'; // Casilla jugable
            }
        }
    }
    

    public boolean esCasillaValida(int fila, int columna) {
        return fila >= 0 && fila < this.getFilas()
                && columna >= 0 && columna < this.getColumnas()
                && tablero[fila][columna] == '.';
    }

    public boolean colocarFicha(int fila, int columna, char ficha) {
        if (esCasillaValida(fila, columna)) {
            tablero[fila][columna] = ficha;
            return true;
        }
        return false;
    }




}
