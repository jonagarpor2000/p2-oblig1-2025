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
    int centro = this.filas/2;
    boolean mitad = false;
    int despH = 4;
    int despV = -2;
    int acumAsteriscos = 7;
    
    for (int i = 0; i <= this.filas; i++) {
        for (int j = 0; j < this.columnas; j++) {
            tablero[i][j]=' ';
        }
    }
    dibujarMitad(acumAsteriscos,despH,despV,0);
    despV=2;
    dibujarMitad(acumAsteriscos,despH,despV,this.columnas-1);

}

public void dibujarMitad(int acumAsteriscos, int desplazamientoHorizonal, int desplazamientoVertical,int lim){
    int centro = this.filas/2;
    for (int i = centro; i >= 0; i+=desplazamientoVertical) {
        for (int j = 0; j < this.columnas && (acumAsteriscos > 0); j+=desplazamientoHorizonal) {
            tablero[i][j]='*';
        }
        acumAsteriscos--;
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
