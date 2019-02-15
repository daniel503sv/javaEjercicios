
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

    @Override
    public String toString() {
        return super.toString() + " director=" + director;
    }

    
    private String director;
    private static final String TIPO = Material.DVD;

    
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
