/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import dominio.Jugador;
import dominio.Partida;
import dominio.Sistema;
import java.util.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Nahuel Paroldo
 * @author Jonathan Garcia
 */


public class Interfaz {
    private final Sistema sys;
    private Partida game = new Partida();
    private Scanner in; // No olvidar nextLine luego de nextInt, tiene error de buffering
    
    
    public Interfaz(Sistema sys){
        this.sys = sys;
        this.in = new Scanner (System.in);
        menu();


    }
    public void menu() {
        int op = 0;
        while (op != 5) {
            System.out.println("--------------------------------------------------------");
            System.out.println("\t Triangulos - Main menu");
            System.out.println("""
                               \t Desarrollado por: 
                                \tJonathan Garcia - 307938
                                \tNahuel Paroldo - 345530""");
            System.out.println("--------------------------------------------------------\n");
            System.out.println(" Seleccione su opcion:");
            System.out.println("1 - Registrar jugador\n");
            System.out.println("2 - Configurar la partida\n");
            System.out.println("3 - Comienzo de la partida\n");
            System.out.println("4 - Ver ranking\n");
            System.out.println("5 - Salir del juego\n");
            op = solicitarNum("Ingrese opcion ", 1, 5);
            switch (op) {
                case 1:
                    sys.registrarJugador(ingresoJugador());
                    break;
                case 2:
                    setearConfigs();
                    break;
                case 3:
                    if (sys.getListaJugadores().size() < 2) {
                        System.out.println("Se requieren al menos 2 jugadores para comenzar el juego");
                    } else {
                        empezarPartida();
                        
                    }
                    break;
                case 4:
                    System.out.println("El ranking de jugadores es el siguiente :");
                    sys.ordenarScoreDec();
                    System.out.println(sys.getListaJugadores());
                    break;
                case 5:
                    //fuegosArtificiales();
                    cargarTablero();
                    
                    break;
                default:
                    System.out.println("El valor introducido es inválido");
                    break;
            }
        }

    }

    public Jugador ingresoJugador() {
        String nombre;
        int edad = Integer.MIN_VALUE;
        System.out.println("Ingrese los datos solicitados: ");
        System.out.println("Ingrese su nickname: ");
        nombre = in.nextLine();
        while (jugadorExistente(nombre)) {
            System.out.println("El jugador " + nombre + " existe \nPruebe con otro nombre");
            nombre = in.nextLine();
        }
        edad = solicitarNum("Ingrese edad del jugador: ", 1, 120);
        return new Jugador(nombre, edad);
    }

    public int solicitarNum(String mensaje, int minimo, int maximo) {
        boolean ok = false;
        int num = 0;
        while (!ok) {
            try {
                System.out.println(mensaje+" ( "+minimo+" - "+maximo+" )");
                num = in.nextInt();
                in.nextLine();
                if (num < minimo || num > maximo) {
                    System.out.println("Valor fuera de rango(" + minimo + "-" + maximo + ")");
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

    public boolean solicitarBoolean(String mensaje) {    //Revisar si se puede cambiar Scanner por nextBoolean
        boolean ok = false;
        int num = Integer.MIN_VALUE;
            
        
        while(!ok){
            try {
                System.out.println(mensaje);
                num = in.nextInt();
                in.nextLine();
                if(num < 0 || num > 1){
                    System.out.println("Debe ingresar 0 o 1");
                }else{
                    ok=true;
                }
                
                

            } catch (InputMismatchException e) { //Error: Nunca llega si se ingresa campo equivocado
                System.out.println("Por favor, ingrese solo  0 o 1");
                num = in.nextInt();
            }
        }
        
        return num==1;
    }
    
    public boolean confirmarAccion(String mensaje) {
        System.out.println(mensaje + " (1: Sí, 0: No)");
        return solicitarNum("", 0, 1) == 1;
    }

    public void cargarTablero() {
        //System.out.println("Largo: "+sys.getLargoDefault()+"Bandas: "+sys.getMaximoBandas()+" Tableros: "+sys.getNumTableros()+" Contacto: "+sys.isRequiereContacto());    
        
            
        for (char letra : game.getTablero().getAbecedario()) {
            System.out.print(letra);
        }
            System.out.println();
           for (int i = 0; i < game.getTablero().getFilas(); i++) {
            for (int j = 0; j < game.getTablero().getColumnas(); j++) {
                System.out.print(game.getTablero().getTablero()[i][j]);
            }
            System.out.println();
        }
    }

    public boolean jugadorExistente(String nombre) {
        boolean existe = false;
        for (Jugador j : sys.getListaJugadores()) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                existe = true;
            }
        }
        return existe;
    }
    
    public void elegirJugador(){
        ArrayList <Jugador> res = solicitarEntradaJugador(sys.getListaJugadores(),sys);
        System.out.println("Ahora repita el procedimiento con el segundo jugador");
        res = solicitarEntradaJugador(res,sys); 
    }
    
    public ArrayList <Jugador> solicitarEntradaJugador(ArrayList<Jugador> playerexcluded,Sistema sys){
        ArrayList <Jugador> res = new ArrayList<>();
        String nombre;
        System.out.println("Elija su jugador de la lista indicando su nombre\n");
        Iterator<Jugador> iterador = playerexcluded.iterator();
        while(iterador.hasNext()){
            System.out.println(iterador.next());
        }
        
        nombre = in.nextLine();
        if(jugadorExistente(nombre)){
           for (Jugador j : playerexcluded) {
               if(j.getNombre().contentEquals(nombre) && (game.getJ1()==null)){
                  game.setJ1(sys.obtenerJugador(nombre));
               }else if (j.getNombre().contentEquals(nombre)){
                  game.setJ2(sys.obtenerJugador(nombre));
               }
               
            }
                res = sys.ObtenerJugadoresExcluidos(nombre, playerexcluded);
        }else{
            while(!jugadorExistente(nombre)){
                System.out.println("El jugador "+nombre+ "no existe.");
                System.out.println("Ingrese un nombre valido");
                nombre = in.nextLine();
            }
            res = sys.ObtenerJugadoresExcluidos(nombre, playerexcluded);
            
        }
        
        return res;
        
    
    }
    


    
    /* Método para mostrar la animación de fuegos artificiales
       Se utilizo Grok con el siguiente prompt: "Al terminar una partida, si hay ganador mostrar efecto de
       animación con desplazamiento de “fuegos artificiales” con colores en consola por un breve tiempo (se
       sugiere utilizar en la consola el font Courier New) en Java*/

       public void fuegosArtificiales(String nombre) {
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
            System.out.println("¡Enhorabuena "+nombre+" has ganado!");

        } catch (InterruptedException e) {
            System.err.println("Error en la animación: " + e.getMessage());
        }
    }


    public void setearConfigs() {
        System.out.println("Establezca las configuraciones para la partida: ");
        int largobandas = solicitarNum("Escriba el largo de movilidad que tendra con las bandas", 1, 4);
        boolean contacto = solicitarBoolean("Escriba 1 si desea el contacto con las bandas anteriores o escriba 0 si desea que la banda sea colocada en cualquier ubicación");
        int Maxbandas = solicitarNum("Escriba el maximo de bandas para jugar", 1, Integer.MAX_VALUE);
        int cantTableros = solicitarNum("Escriba la cantidad de tableros con la que desea jugar", 1, 3);
        sys.setConfiguraciones(largobandas, contacto, Maxbandas, cantTableros);
    }
    
    public void ingresarJugada(){
            
    }
    
    public void empezarPartida(){
        elegirJugador();
        
    }
}
