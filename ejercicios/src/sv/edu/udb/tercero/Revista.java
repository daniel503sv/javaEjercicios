
package sv.edu.udb.tercero;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/
public class Revista extends MaterialEscrito{

    private String periodicidad;
    private String fechaPub;
    
    //Constructor de Revista
    public Revista(String codigo,String titulo,String editorial, int unidades,String periodicidad,String fechaPub){
    super(codigo,titulo,editorial,unidades);
    this.periodicidad = periodicidad;
    this.fechaPub = fechaPub;
    }
    
    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(String fechaPub) {
        this.fechaPub = fechaPub;
    }
    public void listarMateriales(){
    
    }
}
