
package sv.edu.udb.tercero;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/
public class Tercero {
    public static void main(String[] args) {
        Mediateca mediateca = new Mediateca();
        mediateca.agregarMaterial(Material.LIBRO, new Libro("cod01","titulo libro","editorial libro",25,"autor",500, "ISBN?", 1999));
        mediateca.agregarMaterial(Material.LIBRO, new Libro("cod02","titulo libro 2","editorial libro 2",25,"autor 2",500, "ISBN?2", 1999));
        mediateca.agregarMaterial(Material.LIBRO, new Libro("cod03","titulo libro 3","editorial libro 3",25,"autor 3",500, "ISBN?3", 1999));
        
    }
}
