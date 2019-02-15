
package sv.edu.udb.tercero;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/
public class Tercero {
    public static void main(String[] args) {
        Mediateca mediateca = new Mediateca();
        try {
            mediateca.cargar(); //se carga el xml
        } catch (IOException ex) { //no se pudo cargar el xml
            System.out.println(ex);
        }
        
        //creacion
        mediateca.ingresarNuevoLibro("titulo libro","editorial libro",25,"autor",500, "ISBN?", 1999);
        mediateca.ingresarNuevoLibro("titulo libro 2","editorial libro 2",25,"autor 2",500, "ISBN?", 1999);
   
        //busqueda
        Libro libro = (Libro) mediateca.buscarMaterial("LIB00000");
        System.out.println(libro);
        
        
        
        try {
            mediateca.guardar(); //se guarda al xml
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
