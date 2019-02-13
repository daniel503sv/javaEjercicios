
package sv.edu.udb.tercero;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/
public class DVD extends MaterialAudiovisual{

    private String director;
    
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
