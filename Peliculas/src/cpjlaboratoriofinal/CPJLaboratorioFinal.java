package cpjlaboratoriofinal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;

public class CPJLaboratorioFinal {

    public static void main(String[] args) throws IOException {
        Scanner leer = new Scanner(System.in);
        Integer opcion;
        do {
            menu();
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    Iniciar();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Hasta luego :-)");
                    break;
                default:
                    System.out.println("Opción invalida, intente de nuevo");
            }

        } while (opcion != 0);

//        AccesoDatosImpl datos = new AccesoDatosImpl();
//        Pelicula pelicula = new Pelicula("Nemo");
//
//        boolean respuesta = false;
//
////        
//
//        try {
//            datos.escribir(pelicula, nombreArchivo, respuesta);
//        } catch (Exception e) {
//            System.out.println("Ocurrió un error: ");
//            //e.printStackTrace(System.out);
//            System.out.println(e.getMessage());
//        }
//        datos.borrar(nombreArchivo);
//        String repuesta = datos.buscar(nombreArchivo, "Nemo 2");
//        System.out.println("repuesta = " + repuesta);
//        
//        List<Pelicula> lista = datos.listar(nombreArchivo); 
//        lista.forEach(elemento -> {
//            System.out.println("elemento = " + elemento);
//        });
    }

    public static void menu() {
        limpiarAnt();
        System.out.println("");
        System.out.println("1. Iniciar catalogo de peliculas");
        System.out.println("2. Agregar pelicula");
        System.out.println("3. Listar Peliculas");
        System.out.println("4. Buscar pelicula");
        System.out.println("0. Salir");
        System.out.println("Opción: ");
    }

    public static void Iniciar() {
        AccesoDatosImpl datos = new AccesoDatosImpl();
        boolean respuesta = false;
        String nombreArchivo = "peliculas.txt";
        respuesta = datos.existe(nombreArchivo);
        datos.crear(nombreArchivo);
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
