/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import dominio.Jugador;
import dominio.Sistema;
import java.util.*;
import dominio.Tablero;

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

                    sys.setConfiguraciones(op, true, op, op);
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

    public static int solicitarBoolean(String mensaje) {
        Scanner in = new Scanner(System.in);
        boolean ok = false;
        int num = 0;
        while (!ok) {
            try {
                System.out.println(mensaje);
                num = in.nextInt();
                /*if (num < minimo || num > maximo) {
                    System.out.println("Valor fuera de rango( " + minimo + " - " + maximo + " )");
                } else {
                    ok = true;
                }*/
                ok = true;

            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese solo numeros");
                in.nextLine();
            }
        }
        return num;
    }

    public static void fuegosArtificiales() {
        //Logica
    }

    public static void mostrarTablero() {
        int test2 = 0;
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

    public static void setearConfigs() {
        System.out.println("Establezca las configuraciones para la partida: ");
        int largobandas = solicitarNum("Escriba el largo de movilidad que tendra con las bandas", 1, 4);

        boolean contacto;
        int Maxbandas = solicitarNum("Escriba el maximo de bandas para jugar", 1, Integer.MAX_VALUE);
        int cantTableros = solicitarNum("Escriba la cantidad de tableros con la que desea jugar", 1, 3);

    }
}
