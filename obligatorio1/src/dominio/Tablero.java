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
    for (int i = 0; i < filas; i++)
        for (int j = 0; j < columnas; j++)
            tablero[i][j] = ' ';

    int centro = columnas / 2; 

    for (int i = 0; i < filas; i++) {
        int alcance     = i <= filas/2 ? i : filas - 1 - i;
        int nEstrellas  = filas/2 + 1 + alcance;      
        int colInicial          = centro - (nEstrellas - 1); 

        for (int k = 0; k < nEstrellas; k++) {
            int j = colInicial + k * 2;
            tablero[i][j] = '*';
        }
        System.out.println("\n");
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
