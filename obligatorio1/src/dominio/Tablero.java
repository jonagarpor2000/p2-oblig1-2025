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

public class Tablero {

    private int filas;
    private int columnas;
    private char [] abecedario;

    public char[] getAbecedario() {
        return abecedario;
    }

    public void setAbecedario(char[] abecedario) {
        this.abecedario = abecedario;
    }

    
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
         char[] abc = new char[this.getFilas()*2];
         char letra = 'A';
         for (int i = 0; i < abc.length; i+=2) {
            abc[i]=letra++;
            if(i+1 < abc.length){
                abc[i+1] =' ';
            }
            
        }
         this.setAbecedario(abc); 
        int FILAS = this.getFilas();
        int COLUMNAS = this.getColumnas();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                this.getTablero()[i][j] = ' ';
            }
        }
        int[][] asterisco = {
                {0,6},
                {0,10},
                {0,14},
                {0,18},
                {2,4},
                {2,8},
                {2,12},
                {2,16},
                {2,20},
                {4,2},
                {4,6},
                {4,10},
                {4,14},
                {4,18},
                {4,22},
                {6,0},
                {6,4},
                {6,8},
                {6,12},
                {6,16},
                {6,20},
                {6,24},
                {8,2},
                {8,6},
                {8,10},
                {8,14},
                {8,18},
                {8,22},
                {10,4},
                {10,8},
                {10,12},
                {10,16},
                {10,20},
                {12,6},
                {12,10},
                {12,14},
                {12,18}
            };

        for (int[] pos : asterisco) {
            int fila = pos[0], col = pos[1];
            if (fila >= 0 && fila < FILAS && col >= 0 && col < COLUMNAS) {
                this.getTablero()[fila][col] = '*';
            }
        }
    }

    public void reiniciarTablero() {
        inicializarTablero();
    }

    public boolean esCasillaValida(int fila, int columna) {
        return fila >= 0 && fila < this.getFilas()
                && columna >= 0 && columna < this.getColumnas()
                && tablero[fila][columna] == '*';
    }

    public boolean colocarBandasC(int[][] posOrigDest,char tipoBanda) {
        boolean bandasColocadas = false;
        int j = posOrigDest[0][1];
        if (esCasillaValida(posOrigDest[0][0],posOrigDest[0][1])&& esCasillaValida(posOrigDest[1][0],posOrigDest[1][1])) {
            for (int i = posOrigDest[0][0]; i < posOrigDest[1][0]; i++) {
                    if(tablero[i][j]==' '){
                        tablero[i][j] = tipoBanda;
                    }
                j++;
            }
            
            bandasColocadas=true;
            
        }
        return bandasColocadas;
    }
    public boolean colocarBandasQ(int[][] posOrigDest,char tipoBanda) {
        boolean bandasColocadas = false;
        int j = posOrigDest[0][1];
        if (esCasillaValida(posOrigDest[0][0],posOrigDest[0][1])&& esCasillaValida(posOrigDest[1][0],posOrigDest[1][1])) {
            for (int i = posOrigDest[0][0]; i < posOrigDest[1][0]; i++) {
                    if(tablero[i][j]==' '){
                        tablero[i][j] = tipoBanda;
                    }
                j++;-
            }
            
            bandasColocadas=true;
            
        }
        return bandasColocadas;
    }

    boolean esMovimientoValido(int fila, int columna, Jugador turno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void realizarMovimiento(int fila, int columna, Jugador turno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Jugador determinarGanador() {
       
        return null;
    }

}
