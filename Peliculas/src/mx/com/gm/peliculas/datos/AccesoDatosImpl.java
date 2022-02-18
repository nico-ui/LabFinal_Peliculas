package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;

public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> listar(String nombre) {
        File archivo = new File(nombre);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {
                System.out.println("lectura = " + lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
            System.out.println("Fin lectura de archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crear(String nombreArchivo) {
        String ruta = "C:\\catalogoPeliculas\\";
        ruta = ruta + nombreArchivo;
        File archivo = new File(ruta);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo " + ruta + "exitosamente");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
