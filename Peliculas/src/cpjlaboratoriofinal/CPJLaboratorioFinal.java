package cpjlaboratoriofinal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;

public class CPJLaboratorioFinal {

    public final static String NOMBRE_ARCHIVO = "peliculas.txt";

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Integer opcion;
        String pelicula;
        String buscar;
        String borrar;
        AccesoDatosImpl datos = new AccesoDatosImpl();;
        do {
            menu();
            opcion = leer.nextInt();
            leer.nextLine(); //Limpiar buffer
            switch (opcion) {
                case 1:
                    iniciar(datos);
                    break;
                case 2:
                    System.out.println("Ingresa el nombre de la pelicula a AGREGAR: ");
                    pelicula = leer.nextLine();
                    
                    System.out.println("¿Confirmar? S/N");
                    String confirmar = leer.nextLine();
                    
                    if(confirmar.equals("S")){
                        Pelicula peliculaObj = new Pelicula(pelicula);
                    try {
                        agregar(datos, peliculaObj, NOMBRE_ARCHIVO, true);
                    } catch (EscrituraDatosEx ex) {
                        System.out.println(ex.getMessage());
                    }
                    }else{
                        System.out.println("Opción invalida");
                        System.out.println("No se ha podido agregar "+pelicula +" a "+ NOMBRE_ARCHIVO);
                    }
                    
                    
                    break;
                case 3:
                    listar(datos, NOMBRE_ARCHIVO);
                    break;
                case 4:
                    System.out.println("Ingresa el nombre de la pelicula a BUSCAR: ");
                    buscar = leer.nextLine();
                    buscar(datos, NOMBRE_ARCHIVO, buscar);
                    break;
                case 5:
                    System.out.println("¿Deseas borrar "+ NOMBRE_ARCHIVO+"? S/N" );
                    borrar = leer.nextLine();
                    if(borrar.equals("S")){
                        borrar(datos, NOMBRE_ARCHIVO);
                    }else{
                        System.out.println("Opción invalida");
                        System.out.println("No se ha podido borrar "+ NOMBRE_ARCHIVO);
                    }
                    break;
                case 0:
                    System.out.println("Hasta luego :-)");
                    break;
                default:
                    System.out.println("Opción invalida, intente de nuevo");
            }

        } while (opcion != 0);    
    }

    public static void menu() {
        limpiarAnt();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("1. Iniciar catalogo de peliculas");
        System.out.println("2. Agregar pelicula");
        System.out.println("3. Listar Peliculas");
        System.out.println("4. Buscar pelicula");
        System.out.println("5. Borrar catalogo de peliculas");
        //System.out.println("6. Borrar pelicula");//Agrego por accidente una pelicula
        System.out.println("0. Salir");
        System.out.println("Opción: ");
    }

    public static void iniciar(AccesoDatosImpl datos) {
        datos.crear(NOMBRE_ARCHIVO);
    }

    public static void agregar(AccesoDatosImpl datos, Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        datos.escribir(pelicula, nombreArchivo, anexar);
    }

    public static void listar(AccesoDatosImpl datos, String nombreArchivo) {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas = datos.listar(nombreArchivo);
//        System.out.println("peliculas es una lista de objetos Pelicula");
//        System.out.println("peliculas = " + peliculas);
        System.out.println("peliculas: ");
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println(i+1 +". " + peliculas.get(i).getNombre());
        }
    }
    
    public static void buscar(AccesoDatosImpl datos, String nombreArchivo, String buscar){
        String respuesta = datos.buscar(nombreArchivo, buscar);
        System.out.println(respuesta);
    }

    public static void borrar(AccesoDatosImpl datos, String nombreArchivo){
        datos.borrar(nombreArchivo);
    }
    
    public static void limpiarPantalla() {
        try {
            System.out.println("Presione una tecla para continuar...");
            new Scanner(System.in).nextLine();
            String sistemaoperativo = System.getProperty("os.name");
            ArrayList<String> comando = new ArrayList<>();
            if (sistemaoperativo.contains("Windows")) {
                comando.add("cmd");
                comando.add("/C");
                comando.add("cls");

            } else {
                comando.add("clear");

            }
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process iniciar;
            iniciar = pb.inheritIO().start();
            iniciar.waitFor();
        } catch (Exception ex) {
            System.out.println("Error al limpiar pantalla: " + ex.getMessage());
        }
    }

    public static void limpiarAnt() {
        //Limpiar linea de comandos ctrl + L
        try {
            System.out.println("Presione una tecla para continuar...");
            new Scanner(System.in).nextLine();
            Robot pressBot = new Robot();
            pressBot.keyPress(KeyEvent.VK_CONTROL);
            pressBot.keyPress(KeyEvent.VK_L);
            pressBot.keyRelease(KeyEvent.VK_CONTROL);
            pressBot.keyRelease(KeyEvent.VK_L);

        } catch (AWTException ex) {
            System.out.println("Error al limpiar pantalla: " + ex.getMessage());

        }
    }
}
