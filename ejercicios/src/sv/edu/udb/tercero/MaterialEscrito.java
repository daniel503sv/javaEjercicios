/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.tercero;

/**
 *
 * @author Toshiba
 */
public class MaterialEscrito extends Material {
 
    private String editorial;
    private int unidades;
    
    //Constructor
    public MaterialEscrito(){
        
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
}
