
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
    
    //Constructor con parametros
    public Material(String codigo, String titulo){
       
        this.codigo = codigo;
        this.titulo = titulo;
        
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
