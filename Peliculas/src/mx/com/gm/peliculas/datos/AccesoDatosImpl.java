package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;

public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        boolean existe = false;
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            existe = false;
        } else {
            existe = true;
        }
        return existe;
    }

    @Override
    public List<String> listar(String nombre) {
        List<String> peliculas = new ArrayList<>();
        File archivo = new File(nombre);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {
//                System.out.println("pelicula = " + lectura);
                peliculas.add(lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
            System.out.println("Fin lectura de archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(pelicula);
            salida.close();
            System.out.println("Se ha escrito en el archivo " + nombreArchivo + "exitosamente");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        File archivo = new File(nombreArchivo);
        String existe = nombreArchivo + "Vacio";
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {
                if (lectura == buscar) {
                    existe = buscar + " se encuentra en el archivo";
                } else {
                    existe = buscar + " no se encuentra en el archivo";
                }
                lectura = entrada.readLine();
            }
            entrada.close();
            System.out.println("Fin lectura de archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return existe;
    }

    @Override
    public void crear(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo " + nombreArchivo);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        
        AccesoDatosImpl fichero = new AccesoDatosImpl();

        if (fichero.existe(nombreArchivo) == true) {
            archivo.delete();
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero no puede ser borrado");
        }

    }

}
