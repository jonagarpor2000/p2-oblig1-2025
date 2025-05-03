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

    private final int FILAS = 9;
    private final int COLUMNAS = 13;
    private char[][] tablero;

    public Tablero() {
        tablero = new char[FILAS][COLUMNAS];
        inicializarTablero();

    }

    private void inicializarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = ' '; // Por defecto, no jugable
            }
        }

        int centro = COLUMNAS / 2;
        for (int i = 0; i < FILAS; i++) {
            int alcance = i <= FILAS / 2 ? i : FILAS - 1 - i;
            for (int j = centro - alcance; j <= centro + alcance; j += 2) {
                tablero[i][j] = '★'; // Casilla jugable
            }
        }
    }

    public boolean esCasillaValida(int fila, int columna) {
        return fila >= 0 && fila < FILAS
                && columna >= 0 && columna < COLUMNAS
                && tablero[fila][columna] == '.';
    }

    public boolean colocarFicha(int fila, int columna, char ficha) {
        if (esCasillaValida(fila, columna)) {
            tablero[fila][columna] = ficha;
            return true;
        }
        return false;
    }

    public void mostrarTablero() {
        System.out.println("  A B C D E F G H I J K L M");
        for (int i = 0; i < FILAS; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (java.io.UnsupportedEncodingException e) {
            System.err.println("Encoding no soportado: " + e.getMessage());
        }
        Tablero t = new Tablero();
        t.mostrarTablero();

    }
}
