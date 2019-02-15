
package sv.edu.udb.tercero;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/

 public abstract class Material {

    
    private String codigo;
    private String titulo;
    
    public static final String LIBRO = "LIBRO";
    public static final String REVISTA = "REVISTA";
    public static final String CD = "CD";
    public static final String DVD = "DVD";
    private static final String TIPO = "MATERIAL";
    //Constructor con parametros
    public Material(String codigo, String titulo){
       
        this.codigo = codigo;
        this.titulo = titulo;
        
    }

    public String getTIPO() {
        return TIPO;
    }
    
    public Material(){
    
    }
    
    //Setters y getters
        public String getCodigo() {
        return codigo;
    }

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public String getTitulo() {
        return titulo;
    }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void agregarMaterial(){
        
    }
    
    public void modificarMaterial(){
        
    }
    
    public abstract void listarMateriales();
    
    public void borrarMaterial(){
        
    }
    
    public void buscarMaterial(){
        
    }
}
