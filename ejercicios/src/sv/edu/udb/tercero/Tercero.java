
package sv.edu.udb.tercero;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/
public class Tercero {
    private static final String[] OPERACIONES = {"SALIR","AGREGAR","LISTAR","BORRAR","BUSCAR"};
    private static Mediateca mediateca;
    public static void main(String[] args) {
        mediateca = new Mediateca();
        boolean continuar = true;
        int operacion =0;

        try {
            mediateca.cargar(); //se carga el xml
        } catch (IOException ex) { //no se pudo cargar el xml
            System.out.println(ex);
        }
        
        do{
            operacion = JOptionPane.showOptionDialog(null, "Mediateca seleccione una opcion"
                      , "MEDIATECA", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION
                      , null, OPERACIONES, OPERACIONES[0]);
            switch(operacion){
                case 0:
                    continuar = false;
                    break;
                case 1:
                    mediateca.ingresarNuevoMaterial();
                    break;
                case 2:
                    mediateca.listar();
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
            }
        }while(continuar);
        
        
        //creacion
        //mediateca.ingresarNuevoLibro("titulo libro","editorial libro",25,"autor",500, "ISBN?", 1999);
        //mediateca.ingresarNuevoLibro("titulo libro 2","editorial libro 2",25,"autor 2",500, "ISBN?", 1999);
   
        //busqueda
        //Libro libro = (Libro) mediateca.buscarMaterial("LIB00000");
        //mediateca.borrarMaterial("LIB00000");
        
        try {
            mediateca.guardar(); //se guarda al xml
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
   

}
