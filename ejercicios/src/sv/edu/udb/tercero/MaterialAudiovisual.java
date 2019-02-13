package sv.edu.udb.tercero;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/
public class MaterialAudiovisual extends Material {

    private String duracion;
    private String genero;
    
    //Constructor de la clase
    public MaterialAudiovisual(String codigo, String titulo, String duracion, String genero){
        
        super(codigo,titulo);
        this.duracion = duracion;
        this.genero = genero;
    }
    
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }    
    
    public void listarMateriales(){
    
    }    
    
}
