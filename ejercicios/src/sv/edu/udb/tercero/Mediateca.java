/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.tercero;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author josed
 */
public class Mediateca {

    private Inventario inventario;
    
    private String file;

    public Mediateca(){
    
        this.file = "resources/inventario.xml";
        this.inventario = new Inventario();

    }
    
    public Inventario getInventario() {
        return this.inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    
    public List<?> getListaMaterial(String tipo){  //retorna la lista del tipo solicitado
        switch(tipo.toUpperCase()){
            case Material.CD:
                return inventario.getCds();
            case Material.DVD:
                return inventario.getDvds();
            case Material.LIBRO:
                return inventario.getLibros();
            case Material.REVISTA:
                return inventario.getRevistas();
            default:
                return new ArrayList<>(); //retorna una lista vacia si no encuentra el tipo de material
        }
    }
    
    public boolean agregarMaterial(String tipo, Material material){
        
         switch(tipo.toUpperCase()){
            case Material.CD:
                inventario.getCds().add((CD)material);
                return true;
            case Material.DVD:
                inventario.getDvds().add((DVD)material);
                return true;
            case Material.LIBRO:
                inventario.getLibros().add((Libro)material);
                return true;
            case Material.REVISTA:
                inventario.getRevistas().add((Revista)material);
                return true;
            default:
                return false; //retorna una lista vacia si no encuentra el tipo de material
        }
    }
    
    public Material buscarMaterial(String codigo){
        Material material = null;
        return material;
    }
    
     public void guardar() throws IOException{
        
        String datos = jaxbObjectToXML(this.inventario); //se unen todas las lineas del arreglo con un salto de linea
        
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
    private static String jaxbObjectToXML(Inventario inventario)
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Inventario.class,Material.class);
             
            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
            //Print XML String to Console
            StringWriter sw = new StringWriter();
             
            //Write XML to StringWriter
            jaxbMarshaller.marshal(inventario, sw);
             
            //Verify XML Content
            String xmlContent = sw.toString();
            return xmlContent;
 
        } catch (JAXBException e) {
            System.out.println(e);
            return "";
        }
    }
}
