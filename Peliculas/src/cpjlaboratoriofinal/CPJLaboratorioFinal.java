package cpjlaboratoriofinal;

import java.util.List;
import java.util.Scanner;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;

public class CPJLaboratorioFinal {

    public static void main(String[] args) {
        String nombreArchivo = "peliculas.txt";

        AccesoDatosImpl datos = new AccesoDatosImpl();
        Pelicula pelicula = new Pelicula("Nemo 2");

        boolean respuesta = false;

//        respuesta = datos.existe(nombreArchivo);
//        System.out.println("Existe " + respuesta);
//        
//        datos.crear(nombreArchivo);
//        
//        respuesta = datos.existe(nombreArchivo);
//        System.out.println("Existe " + respuesta);

//        datos.escribir(pelicula, nombreArchivo, respuesta); //Repite peliculas
        
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
