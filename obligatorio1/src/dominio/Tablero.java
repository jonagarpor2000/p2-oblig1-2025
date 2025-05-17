/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nahuel Paroldo
 * @author Jonathan Garcia
 */
public class Tablero {

    private int filas;
    private int columnas;
    private char[] abecedario;
    private List<String> historialJugadas;
    private char fichaBlanca = '□'; 
    private char fichaNegra = '■';

    public List<String> getHistorialJugadas() {
        return historialJugadas;
    }

    public void registrarJugada(String jugada) {
        historialJugadas.add(jugada);
    }

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
        historialJugadas = new ArrayList<>();
        char[] abc = new char[this.getFilas() * 2];
        char letra = 'A';
        for (int i = 0; i < abc.length; i += 2) {
            abc[i] = letra++;
            if (i + 1 < abc.length) {
                abc[i + 1] = ' ';
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
        for (int i = 0; i < FILAS; i += 2) { 
            int empieza = Math.abs(6 - i); 
            for (int j = empieza; j < COLUMNAS-empieza; j += 4) {
                this.getTablero()[i][j] = '*';
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

    public boolean colocarBandasC(int[][] posOrigDest, char tipoBanda, boolean j1) {
        boolean bandasColocadas = false;
        char ficha=' ';
        if(j1){
            ficha = fichaBlanca;
        }else{
            ficha = fichaNegra;
        }
           
        int j = posOrigDest[0][1];
        if (esCasillaValida(posOrigDest[0][0], posOrigDest[0][1]) && esCasillaValida(posOrigDest[1][0], posOrigDest[1][1])) {
            for (int i = posOrigDest[0][0]; i < posOrigDest[1][0]; i++) {
                if (tablero[i][j] == ' ') {
                    tablero[i][j] = tipoBanda;
                }else if(tablero[i][j] == '*'){
                    
               
                    
                    if(verificarTriangulos(i,j,posOrigDest[1][0],posOrigDest[1][1],ficha)){
                       //Bajo esta situacion debe sumar puntos
                    }
                }
                j++;
            }

            bandasColocadas = true;

        }
        return bandasColocadas;
    }

    public boolean colocarBandasQ(int[][] posOrigDest, char tipoBanda) {
        int filaO = posOrigDest[0][0];
        int colO = posOrigDest[0][1];
        int filaD = posOrigDest[1][0];
        int colD = posOrigDest[1][1];
        boolean bandasColocadas = false;

        if (esCasillaValida(filaO, colO) && esCasillaValida(filaD, colD)) {

            for (int i = filaO, j = colO; i > filaD && j > colD; i--, j--) {
                if (tablero[i][j] == ' ') {
                    tablero[i][j] = tipoBanda;
                }
            }
            bandasColocadas = true;
        }
        return bandasColocadas;
    }

    public boolean colocarBandasE(int[][] posOrigDest, char tipoBanda) {
        int filaO = posOrigDest[0][0];
        int colO = posOrigDest[0][1];
        int filaD = posOrigDest[1][0];
        int colD = posOrigDest[1][1];
        boolean bandasColocadas = false;

        if (esCasillaValida(filaO, colO) && esCasillaValida(filaD, colD)) {
            for (int i = filaO, j = colO; i > filaD && j < colD; i--, j++) {
                if (tablero[i][j] == ' ') {
                    tablero[i][j] = tipoBanda;
                }
            }
            bandasColocadas = true;
        }
        return bandasColocadas;
    }

    public boolean colocarBandasZ(int[][] posOrigDest, char tipoBanda) {
        int filaO = posOrigDest[0][0], colO = posOrigDest[0][1];
        int filaD = posOrigDest[1][0], colD = posOrigDest[1][1];
        boolean bandasColocadas = false;

        if (esCasillaValida(filaO, colO) && esCasillaValida(filaD, colD)) {
            for (int i = filaO, j = colO; i < filaD && j > colD; i++, j--) {
                if (tablero[i][j] == ' ') {
                    tablero[i][j] = tipoBanda;
                }
            }
            bandasColocadas = true;
        }
        return bandasColocadas;
    }

    public boolean colocarBandasD(int[][] posOrigDest, char tipoBanda) {
        int filaO = posOrigDest[0][0];
        int colO = posOrigDest[0][1];
        int filaD = posOrigDest[1][0];
        int colD = posOrigDest[1][1];
        boolean bandasColocadas = false;

        if (filaO >= 0 && filaO < filas
                && colO >= 0 && colO < columnas
                && filaD >= 0 && filaD < filas
                && colD >= 0 && colD < columnas) {
            for (int j = colO; j < colD; j++) {
                if (tablero[filaO][j] == ' ') {
                    tablero[filaO][j] = tipoBanda;
                }
            }
            bandasColocadas = true;
        }
        return bandasColocadas;
    }

    public boolean colocarBandasA(int[][] posOrigDest, char tipoBanda) {
        int filaO = posOrigDest[0][0];
        int colO = posOrigDest[0][1];
        int filaD = posOrigDest[1][0];
        int colD = posOrigDest[1][1];
        if (filaO < 0 || filaO >= filas
                || colO < 0 || colO >= columnas
                || filaD < 0 || filaD >= filas
                || colD < 0 || colD >= columnas) {
            return false;
        }
        for (int j = colO; j > colD; j--) {
            if (tablero[filaO][j] == ' ') {
                tablero[filaO][j] = tipoBanda;
            }
        }
        return true;
    }
    
    public boolean verificarTriangulos(int fila, int columna, int filaDest, int colDest, char ficha) {
        boolean colocado = false;
        int filas = this.getFilas();
        int columnas = this.getColumnas();

        try {
            // Controlar que no se salga de los límites del tablero
            if (fila + 1 < filas && columna - 1 >= 0 && columna + 1 < columnas) {
                
                // Dirección Z (↙): abajo-izquierda y abajo-derecha deben tener bandas
                if (fila < filaDest && columna > colDest && !colocado) {
                    if ((tablero[fila + 1][columna - 1] == '\\' || tablero[fila + 1][columna - 1] == '/')
                            && (tablero[fila + 1][columna + 1] == '\\' || tablero[fila + 1][columna + 1] == '/')
                            && tablero[fila + 1][columna] == ' ') {
                        tablero[fila + 1][columna] = ficha;
                        colocado = true;
                    }
                }
            }
            if (fila - 1 >= 0 && fila + 1 < filas && columna - 1 >= 0 && columna + 1 < columnas) {
                // Dirección E (↗): arriba-izquierda y abajo-derecha deben tener bandas
                if (fila > filaDest && columna < colDest && !colocado) {
                    if ((tablero[fila - 1][columna - 1] == '\\' || tablero[fila - 1][columna - 1] == '/')
                            && (tablero[fila + 1][columna + 1] == '\\' || tablero[fila + 1][columna + 1] == '/')
                            && tablero[fila + 1][columna] == ' ') {
                        tablero[fila + 1][columna] = ficha;
                        colocado = true;
                    }
                }
            }
            if (fila + 2 < filas && fila - 1 >= 0 && columna - 1 >= 0 && columna + 1 < columnas) {
                // Dirección C (↘): abajo-izquierda y arriba-derecha deben tener bandas, y abajo dos filas debe haber '-'
                if (fila < filaDest && columna < colDest && !colocado) {
                    if ((tablero[fila + 1][columna - 1] == '\\' || tablero[fila + 1][columna - 1] == '/')
                            && (tablero[fila - 1][columna + 1] == '\\' || tablero[fila - 1][columna + 1] == '/')
                            && tablero[fila + 2][columna] == '-'
                            && tablero[fila + 1][columna] == ' ') {
                        tablero[fila + 1][columna] = ficha;
                        colocado = true;
                    }
                }
            }
            // Dirección Q (↖): arriba-izquierda y arriba-derecha deben tener bandas
            if (fila - 1 >= 0 && columna - 1 >= 0 && columna + 1 < columnas) {
                if (fila > filaDest && columna > colDest && !colocado) {
                    if ((tablero[fila - 1][columna - 1] == '\\' || tablero[fila - 1][columna - 1] == '/')
                            && (tablero[fila - 1][columna + 1] == '\\' || tablero[fila - 1][columna + 1] == '/')
                            && tablero[fila - 1][columna] == ' ') {
                        tablero[fila - 1][columna] = ficha;
                        colocado = true;
                    }
                }
            }
            // Dirección D (→): derecha y abajo-derecha deben tener bandas
            if (fila + 1 < filas && columna + 2 < columnas) {
                if (fila == filaDest && columna < colDest && !colocado) {
                    if ((tablero[fila][columna + 1] == '-' || tablero[fila][columna + 1] == '/')
                            && (tablero[fila + 1][columna + 1] == '\\' || tablero[fila + 1][columna + 1] == '/')
                            && tablero[fila][columna + 2] == ' ') {
                        tablero[fila][columna + 2] = ficha;
                        colocado = true;
                    }
                }
            }
            // Dirección A (←): izquierda y abajo-izquierda deben tener bandas
            if (fila + 1 < filas && columna - 2 >= 0) {
                if (fila == filaDest && columna > colDest && !colocado) {
                    if ((tablero[fila][columna - 1] == '-' || tablero[fila][columna - 1] == '/')
                            && (tablero[fila + 1][columna - 1] == '\\' || tablero[fila + 1][columna - 1] == '/')
                            && tablero[fila][columna - 2] == ' ') {
                        tablero[fila][columna - 2] = ficha;
                        colocado = true;
                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            
        }
        
        return colocado;
    }

    /**
     * Coloca una banda en el tablero según la dirección y verifica si se forma un triángulo.
     * @param posOrigDest posiciones [origen][destino]
     * @param tipoBanda caracter de la banda
     * @param esJ1 true si es jugador 1 (blanco), false si es jugador 2 (negro)
     * @param direccion dirección de la jugada ('C','Q','E','Z','D','A')
     * @return cantidad de puntos obtenidos (0 si no formó triángulo)
     */
    public int colocarBandas(int[][] posOrigDest, char tipoBanda, boolean esJ1, char direccion) {
        int puntos = 0;
        int filaO = posOrigDest[0][0];
        int colO = posOrigDest[0][1];
        int filaD = posOrigDest[1][0];
        int colD = posOrigDest[1][1];
        char ficha = esJ1 ? fichaBlanca : fichaNegra;

        // Validar casillas de origen y destino
        if (esCasillaValida(filaO, colO) && esCasillaValida(filaD, colD)){

            // Movimiento según dirección
            int i = filaO, j = colO;
            boolean bandaColocada = false;
            switch (Character.toUpperCase(direccion)) {
                case 'C': // Sureste
                    while (i < filaD && j < colD) {
                        if (tablero[i][j] == ' ') {
                            tablero[i][j] = tipoBanda;
                            bandaColocada = true;
                        } else if (tablero[i][j] == '*') {
                            if (verificarTriangulos(i, j, filaD, colD, ficha)) {
                                puntos++;
                            }
                        }
                        i++; j++;
                    }
                    break;
                case 'Q': // Noroeste
                    while (i > filaD && j > colD) {
                        if (tablero[i][j] == ' ') {
                            tablero[i][j] = tipoBanda;
                            bandaColocada = true;
                        } else if (tablero[i][j] == '*') {
                            if (verificarTriangulos(i, j, filaD, colD, ficha)) {
                                puntos++;
                            }
                        }
                        i--; j--;
                    }
                    break;
                case 'E': // Noreste
                    while (i > filaD && j < colD) {
                        if (tablero[i][j] == ' ') {
                            tablero[i][j] = tipoBanda;
                            bandaColocada = true;
                        } else if (tablero[i][j] == '*') {
                            if (verificarTriangulos(i, j, filaD, colD, ficha)){
                                puntos++;
                            }
                        }
                        i--; j++;
                    }
                    break;
                case 'Z': // Suroeste
                    while (i < filaD && j > colD) {
                        if (tablero[i][j] == ' ') {
                            tablero[i][j] = tipoBanda;
                            bandaColocada = true;
                        } else if (tablero[i][j] == '*') {
                            if (verificarTriangulos(i, j, filaD, colD, ficha)) {
                                puntos++;
                            }
                        }
                        i++; j--;
                    }
                    break;
                case 'D': // Este
                    while (j < colD) {
                        if (tablero[i][j] == ' ') {
                            tablero[i][j] = tipoBanda;
                            bandaColocada = true;
                        } else if (tablero[i][j] == '*') {
                            if (verificarTriangulos(i, j, filaD, colD, ficha))  {
                                puntos++;
                            }
                        }
                        j++;
                    }
                    break;
                case 'A': // Oeste
                    while (j > colD) {
                        if (tablero[i][j] == ' ') {
                            tablero[i][j] = tipoBanda;
                            bandaColocada = true;
                        } else if (tablero[i][j] == '*') {
                            if (verificarTriangulos(i, j, filaD, colD, ficha)) {
                                puntos++;
                            }
                        }
                        j--;
                    }
                    break;
                default:

                    puntos = 0;
            }
        }
        return puntos;
    }

    public int filaAsteriscoANumeroReal(int filaAsterisco) {
        int contador = 0;
        int filaReal = -1;
        for (int i = 0; i < filas; i++) {
            boolean tieneAsterisco = false;
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == '*') {
                    tieneAsterisco = true;
                }
            }
            if (tieneAsterisco) {
                contador++;
                if (contador == filaAsterisco) {
                    filaReal = i;
                }
            }
        }
        return filaReal;
    }

}
