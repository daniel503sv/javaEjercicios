
package sv.edu.udb.tercero;

import javax.xml.bind.annotation.XmlRootElement;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/
@XmlRootElement(name = "revista")
public class Revista extends MaterialEscrito{

    private String periodicidad;
    private String fechaPub;
    private static final String TIPO = Material.REVISTA;

    public Revista(){
        super();
    }
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
