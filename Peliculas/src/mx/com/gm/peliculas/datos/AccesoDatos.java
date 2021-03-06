package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;

public interface AccesoDatos {

    public boolean existe(String nombreArchivo);

    public List<Pelicula> listar(String nombre);
    
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    
    public String buscar(String nombreArchivo, String buscar);
    
    public void crear(String nombreArchivo);
    
    public void borrar(String nombreArchivo);
    
    public void borrarPelicula(String nombreArchivo, String nombrePelicula);
    
}
