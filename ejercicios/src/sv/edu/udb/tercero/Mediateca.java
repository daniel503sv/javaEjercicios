/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.tercero;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import sv.edu.udb.segundo.Cuenta;

/**
 *
 * @author josed
 */
public class Mediateca {
    private Map<String,List<Material>> inventario;
    private String file;

    public Mediateca(){
        this.inventario = new HashMap<>(); //mapa que guarda datos
        this.inventario.put(Material.LIBRO, new ArrayList<>());
        this.inventario.put(Material.REVISTA, new ArrayList<>());
        this.inventario.put(Material.CD, new ArrayList<>());
        this.inventario.put(Material.DVD, new ArrayList<>());
    }
    
    public Map<String, List<Material>> getInventario() {
        return inventario;
    }

    public void setInventario(Map<String, List<Material>> inventario) {
        this.inventario = inventario;
    }
    
    public List<Material> getListaMaterial(String tipo){
        if(this.inventario.containsKey(tipo.toUpperCase())){
            return this.inventario.get(tipo.toUpperCase()); //busca la lista del tipo de material
        }
        return new ArrayList<>(); //retorna una lista vacia si no encuentra el tipo de material
    }
    
    public boolean agregarMaterial(String tipo, Material material){
        
        if(this.inventario.containsKey(tipo.toUpperCase())){
           this.inventario.get(tipo.toUpperCase()).add(material); //se guardo el material en la lista correspondiente
           return true; //finalizo exitosamente
        }
        return false; //no se encontro el tipo de material enviado
    }
    
    public Material buscarMaterial(String codigo){
        Material material = null;
        return material;
    }
    
     public void guardar() throws IOException{
        String datos = ""; //se unen todas las lineas del arreglo con un salto de linea
        
        try {
            Files.write(Paths.get(this.file), datos.getBytes()); //se guarda el archivo
        } catch (IOException ex) { //error en la escritura
            throw ex;
        }
    }
     
     public void cargar() throws IOException{
        //se carga el archivo como una coleccion de las lineas
        try (Stream<String> stream = Files.lines(Paths.get(file))) { 
            
        } catch (IOException e) { //error de lectura
            throw e; //se devuelve el error 
        } catch (Exception ex){ //cualquier otro error como parsing o archivo incorrecto
            throw ex;
        }
    }
}
