
package sv.edu.udb.tercero;

import javax.xml.bind.annotation.XmlRootElement;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/
@XmlRootElement(name = "dvd")
public class DVD extends MaterialAudiovisual{

    private String director;
    
    public DVD(){
        super();
    }
    
    //Constructor de la clase DVD
    public DVD(String codigo,String titulo,String duracion, String genero,String director){
        super(codigo,titulo,duracion,genero);
        this.director = director;
        
    }
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    public void listarMateriales(){
    
    }
    
    
}
