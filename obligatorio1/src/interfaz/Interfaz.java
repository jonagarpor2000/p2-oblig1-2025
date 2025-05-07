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
    public static void menu(Sistema sys){
        
        Scanner in = new Scanner(System.in);
        int op = 0;
        while(op != 5){
            System.out.println("--------------------------------------------------------");
            System.out.println("\t Triangulos - Main menu");
            System.out.println("--------------------------------------------------------\n");
            System.out.println(" Seleccione su opcion:");
            System.out.println("1 - Registrar jugador\n");
            System.out.println("2 - Configurar la partida\n");
            System.out.println("3 - Comienzo de la partida\n");
            System.out.println("4 - Ver ranking\n");
            System.out.println("5 - Salir del juego\n");
            op = solicitarNum("Ingrese opcion (1-5) ",1,5);
            switch(op){
                case 1:
                    sys.registrarJugador(ingresoJugador());
                    break;
                case 2:
                    System.out.println("El ranking de jugadores es el siguiente :");
                    sys.ordenarScoreDec();
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
            }
        }
        
        
    }
    
    public static Jugador ingresoJugador (){
        Scanner in = new Scanner (System.in);
        String nombre = "";
        int edad = Integer.MIN_VALUE;
        System.out.println("Ingrese los datos solicitados: ");
        System.out.println("Ingrese su nickname: ");
        nombre = in.nextLine();
        edad = solicitarNum("Ingrese edad del jugador: ",1,120);
        return new Jugador(nombre,edad);
    }

    public static int solicitarNum(String mensaje, int minimo, int maximo){
        Scanner in = new Scanner(System.in);
        boolean ok = false;
        int num = 0;
        while (!ok){
            try{
                System.out.println(mensaje);
                num = in.nextInt();
                if(num<minimo || num > maximo){
                    System.out.println("Valor fuera de rango( "+minimo+" - "+ maximo + " )");
                }else{
                    ok = true;
                }
                
                
            }catch(InputMismatchException e){
                System.out.println("Por favor, ingrese solo numeros");
                in.nextLine();
            }
        }
        return num;
    }
    
    public static void fuegosArtificiales(){
        //Logica
    }
    
    public static void mostrarTablero() {
        int FILAS = 9;
        int COLUMNAS = 13;
        //private final int COLUMNAS = 13;
        
        Tablero t = new Tablero(9,13);
        System.out.println("  A B C D E F G H I J K L M");
        for (int i = 0; i < FILAS; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(t.getTablero()[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void listadoJugadores(Sistema sys){
        System.out.println("\nLista de jugadores\n------------");
        for (Jugador gamer : sys.getListaJugadores()){
            System.out.println(gamer+"\n");
        }
    }
}
