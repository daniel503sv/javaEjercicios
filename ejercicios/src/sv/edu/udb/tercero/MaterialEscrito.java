
package sv.edu.udb.tercero;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/
public class MaterialEscrito extends Material {
 
    private String editorial;
    private int unidades;
    
    public MaterialEscrito(){
        super();
    }
    //Constructor
    public MaterialEscrito(String codigo,String titulo,String editorial,int unidades){
        super(codigo,titulo);
        this.editorial = editorial;
        this.unidades = unidades;
    }
    
    //setters y getters
    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
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
