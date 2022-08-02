package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

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
    public List<Pelicula> listar(String nombre) {
        List<Pelicula> peliculas = new ArrayList<>();
        AccesoDatosImpl fichero = new AccesoDatosImpl();
        if (fichero.existe(nombre) == true) {
            File archivo = new File(nombre);
            try {
                var entrada = new BufferedReader(new FileReader(archivo));
                String lectura = entrada.readLine();
                while (lectura != null) {
                    Pelicula obj = new Pelicula(lectura);
//                System.out.println("pelicula = " + lectura);
                    peliculas.add(obj);
                    lectura = entrada.readLine();
                }
                entrada.close();
                System.out.println("Fin lectura del archivo");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        } else {
            System.out.println(nombre + " no existe");
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        AccesoDatosImpl fichero = new AccesoDatosImpl();
        if (fichero.existe(nombreArchivo) == true) {
            String respuesta = fichero.buscar(nombreArchivo, pelicula.getNombre());
            String frase = pelicula.getNombre() + "   --> existe";
            if (frase.equals(respuesta)) {
                throw new EscrituraDatosEx(pelicula.getNombre() + "   --> existe");
//            System.out.println(pelicula.getNombre() + " ya existe, no se puede escribir");
            } else {
                File archivo = new File(nombreArchivo);
                try {
                    PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
                    salida.println(pelicula.getNombre());
                    salida.close();
                    System.out.println("Se ha escrito " + pelicula.getNombre() + " en el archivo " + nombreArchivo + " exitosamente");
                } catch (FileNotFoundException ex) {
                    throw new EscrituraDatosEx(ex.getMessage());
//                    ex.printStackTrace(System.out);
                } catch (IOException ex) {
                    throw new EscrituraDatosEx(ex.getMessage());
//                    ex.printStackTrace(System.out);
                }
            }
        } else {
            throw new EscrituraDatosEx(nombreArchivo + " no existe");
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        AccesoDatosImpl fichero = new AccesoDatosImpl();
        File archivo = new File(nombreArchivo);
        String existe = nombreArchivo + " no existe";
        if (fichero.existe(nombreArchivo) == true) {
            try {
//            System.out.println("Inicio lectura del archivo");
                var entrada = new BufferedReader(new FileReader(archivo));
                String lectura = entrada.readLine();
//            System.out.println("lectura = " + lectura);
                while (lectura != null) {
                    if (lectura.equals(buscar)) {
                        existe = buscar + "   --> existe";
                        break;
                    } else {
                        existe = buscar + "   --> no existe";
                    }
                    lectura = entrada.readLine();
//                System.out.println("lectura = " + lectura);
                }
                entrada.close();
                System.out.println("Fin lectura de archivo");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return existe;
    }

    @Override
    public void crear(String nombreArchivo) {

        AccesoDatosImpl fichero = new AccesoDatosImpl();

        if (fichero.existe(nombreArchivo) == false) {
            File archivo = new File(nombreArchivo);
            try {
                PrintWriter salida = new PrintWriter(archivo);
                salida.close();
                System.out.println("Se ha creado el archivo " + nombreArchivo);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            }
        } else {
            System.out.println(nombreArchivo + " ya existe");
            System.out.println(nombreArchivo + " no pudo ser creado");
        }

    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        AccesoDatosImpl fichero = new AccesoDatosImpl();

        if (fichero.existe(nombreArchivo) == true) {
            archivo.delete();
            System.out.println("El archivo " + nombreArchivo + " ha sido borrado exitosamente");
        } else {
            System.out.println(nombreArchivo + " no existe");
        }

    }

    @Override
    public void borrarPelicula(String nombreArchivo, String nombrePelicula) {
        AccesoDatosImpl fichero = new AccesoDatosImpl();
        String existe = fichero.buscar(nombreArchivo, nombrePelicula);
        if (existe.equals(nombrePelicula + " se encuentra en el archivo")) {
            //Borrar
            System.out.println("aqui borramos");
        } else {
            System.out.println(nombrePelicula + " no se encuentra en el archivo");
        }
    }
}
