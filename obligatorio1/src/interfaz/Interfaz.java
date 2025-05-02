/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import java.util.*;
/**
 *
 * @author Nahuel Paroldo
 * @author Jonathan Garcia
 */

//nombre + Nroestudiante en interfaz
public class Interfaz {
    public static void menu(){
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
        }
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
}
