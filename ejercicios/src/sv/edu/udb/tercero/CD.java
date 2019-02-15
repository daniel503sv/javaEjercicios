package sv.edu.udb.tercero;

import javax.xml.bind.annotation.XmlRootElement;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/
@XmlRootElement(name = "cd")
public class CD extends MaterialAudiovisual{

    private String artista;
    private int numCanciones;
    private int unidades;
    private static final String TIPO = Material.CD;
    
    public CD(){
        super();
    }

    public static String getTIPO() {
        return TIPO;
    }
    //Constructor de la clase CD
    public CD(String codigo,String titulo,String duracion,String genero,String artista,int numCanciones,int unidades){
    super(codigo,titulo,duracion,genero);
    this.artista = artista;
    this.numCanciones = numCanciones;
    this.unidades = unidades;
    }
    
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(int numCanciones) {
        this.numCanciones = numCanciones;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    public void listarMateriales(){
    
    }
    
}
