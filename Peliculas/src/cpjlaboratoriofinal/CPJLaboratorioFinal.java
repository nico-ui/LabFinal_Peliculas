package cpjlaboratoriofinal;

import java.util.List;
import java.util.Scanner;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;

public class CPJLaboratorioFinal {

    public static void main(String[] args) {
        String nombreArchivo = "peliculas.txt";

        AccesoDatosImpl datos = new AccesoDatosImpl();
        Pelicula pelicula = new Pelicula("Nemo");

        boolean respuesta = false;

//        respuesta = datos.existe(nombreArchivo);
//        System.out.println("Existe " + respuesta);
//        
//        datos.crear(nombreArchivo);
//        
//        respuesta = datos.existe(nombreArchivo);
//        System.out.println("Existe " + respuesta);

        try {
            datos.escribir(pelicula, nombreArchivo, respuesta); //Repite peliculas
        } catch (Exception e) {
            System.out.println("Ocurrió un error: ");
            //e.printStackTrace(System.out);
            System.out.println(e.getMessage());
        }

//        datos.borrar(nombreArchivo);
//        String repuesta = datos.buscar(nombreArchivo, "Nemo 2");
//        System.out.println("repuesta = " + repuesta);
//        
//        List<Pelicula> lista = datos.listar(nombreArchivo); 
//        lista.forEach(elemento -> {
//            System.out.println("elemento = " + elemento);
//        });
    }
}
