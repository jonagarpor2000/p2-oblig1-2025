/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import dominio.Jugador;
import dominio.Sistema;
import java.util.*;
import dominio.Tablero;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Nahuel Paroldo
 * @author Jonathan Garcia
 */

//nombre + Nroestudiante en interfaz
public class Interfaz {

    public static void menu(Sistema sys) {

        Scanner in = new Scanner(System.in);
        int op = 0;
        while (op != 5) {
            System.out.println("--------------------------------------------------------");
            System.out.println("\t Triangulos - Main menu");
            System.out.println("--------------------------------------------------------\n");
            System.out.println(" Seleccione su opcion:");
            System.out.println("1 - Registrar jugador\n");
            System.out.println("2 - Configurar la partida\n");
            System.out.println("3 - Comienzo de la partida\n");
            System.out.println("4 - Ver ranking\n");
            System.out.println("5 - Salir del juego\n");
            op = solicitarNum("Ingrese opcion (1-5) ", 1, 5);
            switch (op) {
                case 1:
                    sys.registrarJugador(ingresoJugador(sys));
                    break;
                case 2:
                    setearConfigs(sys);
                    break;
                case 3:
                    if (sys.getListaJugadores().size() < 2) {
                        System.out.println("Se requieren al menos 2 jugadores para comenzar el juego");
                    } else {
                        sys.empezarPartida();
                    }
                    break;
                case 4:
                    System.out.println("El ranking de jugadores es el siguiente :");
                    sys.ordenarScoreDec();
                    System.out.println(sys.getListaJugadores());
                    break;
                case 5:
                    fuegosArtificiales();
                    //cargarTablero();
                    break;
                default:
                    System.out.println("El valor introducido es inválido");
                    break;
            }
        }

    }

    public static Jugador ingresoJugador(Sistema sys) {
        Scanner in = new Scanner(System.in);
        String nombre;
        int edad = Integer.MIN_VALUE;
        System.out.println("Ingrese los datos solicitados: ");
        System.out.println("Ingrese su nickname: ");
        nombre = in.nextLine();
        while (jugadorExistente(nombre, sys)) {
            System.out.println("El jugador " + nombre + " existe \nPruebe con otro nombre");
            nombre = in.nextLine();
        }
        edad = solicitarNum("Ingrese edad del jugador: ", 1, 120);
        return new Jugador(nombre, edad);
    }

    public static int solicitarNum(String mensaje, int minimo, int maximo) {
        Scanner in = new Scanner(System.in);
        boolean ok = false;
        int num = 0;
        while (!ok) {
            try {
                System.out.println(mensaje);
                num = in.nextInt();
                if (num < minimo || num > maximo) {
                    System.out.println("Valor fuera de rango( " + minimo + " - " + maximo + " )");
                } else {
                    ok = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese solo numeros");
                in.nextLine();
            }
        }
        return num;
    }

    public static boolean solicitarBoolean(String mensaje) {
        Scanner in = new Scanner(System.in);
        boolean ok = false;
        int num = 0;
        boolean binario = false;
        while (!ok) {
            try {
                System.out.println(mensaje);
                num = in.nextInt();
                if (num < 0 || num > 1) {
                    System.out.println("Valor fuera de rango, debe ser 0 (para indicar false) o 1 (para indicar true)");
                } else {
                    ok = true;
                }
                
               

            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese solo numeros");
                in.nextLine();
            }
        }
        return num==1;
    }

        public static void mostrarTablero(){
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
            cargarTablero();
        } catch (java.io.UnsupportedEncodingException e) {
            System.err.println("Encoding no soportado: " + e.getMessage());
        }
        
    }

    public static void cargarTablero() {
        int FILAS = 7;
        int COLUMNAS = 13;
        //private final int COLUMNAS = 13;

        Tablero t = new Tablero(FILAS, COLUMNAS);
        System.out.println("  A B C D E F G H I J K L M");
        for (int i = 0; i < FILAS; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(t.getTablero()[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void listadoJugadores(Sistema sys) {
        System.out.println("\nLista de jugadores\n------------");
        for (Jugador gamer : sys.getListaJugadores()) {
            System.out.println(gamer + "\n");
        }
    }

    public static boolean jugadorExistente(String nombre, Sistema sys) {
        boolean existe = false;
        for (Jugador j : sys.getListaJugadores()) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                existe = true;
            }
        }
        return existe;
    }

    
    /* Método para mostrar la animación de fuegos artificiales
       Se utilizo Grok con el siguiente prompt: "Al terminar una partida, si hay ganador mostrar efecto de
       animación con desplazamiento de “fuegos artificiales” con colores en consola por un breve tiempo (se
       sugiere utilizar en la consola el font Courier New) en Java*/

       public static void fuegosArtificiales() {
        // Colores ANSI para la consola
        String RESET = "\033[0m";
        String[] COLORS = {
            "\033[31m", // Rojo
            "\033[32m", // Verde
            "\033[33m", // Amarillo
            "\033[34m", // Azul
            "\033[35m", // Magenta
            "\033[36m", // Cian
        };

        // Símbolos para simular fuegos artificiales
        String[] FIREWORK_CHARS = {"", "+", "o", "."};

        // Dimensiones de la "pantalla" en la consola
        int width = 50;
        int height = 10;

        // Duración de la animación (en milisegundos)
        int duration = 3000;
        long startTime = System.currentTimeMillis();

        try {
            // Recomendación de fuente
            System.out.println("Se recomienda usar la fuente 'Courier New' en la consola para mejor visualización.");

            // Bucle de animación
            while (System.currentTimeMillis() - startTime < duration) {
                // Limpia la consola (funciona en terminales compatibles con ANSI)
                System.out.print("\033[H\033[2J");

                // Genera varios "fuegos" en cada cuadro
                for (int i = 0; i < 5; i++) {
                    // Posición aleatoria para el fuego artificial
                    int x = (int) (Math.random() * width);
                    int y = (int) (Math.random() * height);

                    // Selecciona un color y símbolo aleatorio
                    String color = COLORS[(int) (Math.random() * COLORS.length)];
                    String symbol = FIREWORK_CHARS[(int) (Math.random() * FIREWORK_CHARS.length)];

                    // Imprime el fuego artificial en la posición calculada
                    for (int row = 0; row < height; row++) {
                        for (int col = 0; col < width; col++) {
                            if (row == y && col == x) {
                                System.out.print(color + symbol + RESET);
                            } else {
                                // Imprime espacios para simular movimiento
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                }

                // Pausa para controlar la velocidad de la animación
                Thread.sleep(600);
            }

            // Limpia la consola al final
            System.out.print("\033[H\033[2J");
            System.out.println("¡Fin de la animación de fuegos artificiales!");

        } catch (InterruptedException e) {
            System.err.println("Error en la animación: " + e.getMessage());
        }
    }


    public static void setearConfigs(Sistema sys) {
        System.out.println("Establezca las configuraciones para la partida: ");
        int largobandas = solicitarNum("Escriba el largo de movilidad que tendra con las bandas", 1, 4);
        boolean contacto = solicitarBoolean("Escriba 1 si desea el contacto con las bandas anteriores o escriba 0 si desea que la banda sea colocada en cualquier ubicación");
        int Maxbandas = solicitarNum("Escriba el maximo de bandas para jugar", 1, Integer.MAX_VALUE);
        int cantTableros = solicitarNum("Escriba la cantidad de tableros con la que desea jugar", 1, 3);
        sys.setConfiguraciones(largobandas, contacto, Maxbandas, cantTableros);
    }
}
