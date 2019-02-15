/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.tercero;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author josed
 */
public class Mediateca {

    private static final String[] MATERIALES = {"LIBRO","REVISTA","DVD","CD"};

    private Inventario inventario;
    
    private String file;

    public Mediateca(){
    
        this.file = "resources/inventario.xml";
        this.inventario = new Inventario();

    }
    
    public Inventario obtenerInventario() {
        return this.inventario;
    }

    public void ingresarInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    
    public List<?> obtenerListaMaterial(String tipo){  //retorna la lista del tipo solicitado
        switch(tipo.toUpperCase()){
            case Material.CD:
                return inventario.obtenerCds();
            case Material.DVD:
                return inventario.obtenerDvds();
            case Material.LIBRO:
                return inventario.obtenerLibros();
            case Material.REVISTA:
                return inventario.obtenerRevistas();
            default:
                return new ArrayList<>(); //retorna una lista vacia si no encuentra el tipo de material
        }
    }
    
   public void ingresarNuevoLibro(String titulo,String editorial,int unidades,String autor,int numPaginas, String ISBN, int anioPub){
       this.inventario.ingresarNuevoLibro(titulo, editorial, unidades, autor, numPaginas, ISBN, anioPub);
   }
    
   public void ingresarNuevaRevista(String titulo,String editorial, int unidades,String periodicidad,String fechaPub){
       this.inventario.ingresarNuevaRevista(titulo,editorial, unidades,periodicidad,fechaPub);
   }
   
   public void ingresarNuevoCd(String titulo,String duracion,String genero,String artista,int numCanciones,int unidades){
       this.inventario.ingresarNuevoCd(titulo,duracion,genero,artista,numCanciones,unidades);
   }
   
   public void ingresarNuevoDvd(String titulo,String duracion, String genero,String director){
     this.inventario.ingresarNuevoDvd(titulo,duracion,genero,director);
   }
   
   
    
    public boolean agregarMaterial(Material material){
        return this.agregarMaterial(material.getTIPO(), material);
    }
    
    public boolean agregarMaterial(String tipo, Material material){
        
         switch(tipo.toUpperCase()){
            case Material.CD:
                inventario.obtenerCds().add((CD)material);
                return true;
            case Material.DVD:
                inventario.obtenerDvds().add((DVD)material);
                return true;
            case Material.LIBRO:
                inventario.obtenerLibros().add((Libro)material);
                return true;
            case Material.REVISTA:
                inventario.obtenerRevistas().add((Revista)material);
                return true;
            default:
                return false; //retorna una lista vacia si no encuentra el tipo de material
        }
    }
    
    public Material buscarMaterial(String codigo){
        String tipo = codigo.toUpperCase().substring(0,3);
        switch(tipo){
            case "LIB":
                for(Libro libro:inventario.obtenerLibros()){
                    if(libro.getCodigo().equalsIgnoreCase(codigo)){
                        return libro;
                    }
                }
                break;
            case "REV":
                for(Revista revista:inventario.obtenerRevistas()){
                    if(revista.getCodigo().equalsIgnoreCase(codigo)){
                        return revista;
                    }
                }
                break;
            case "CDA":
                for(CD cd:inventario.obtenerCds()){
                    if(cd.getCodigo().equalsIgnoreCase(codigo)){
                        return cd;
                    }
                }
                break;
            case "DVD":
                for(DVD dvd:inventario.obtenerDvds()){
                    if(dvd.getCodigo().equalsIgnoreCase(codigo)){
                        return dvd;
                    }
                }
                break;
        }
        return null;
    }
    
    public boolean borrarMaterial(String codigo){
        String tipo = codigo.toUpperCase().substring(0,3);
        switch(tipo){
            case "LIB":
                for(Libro libro:inventario.obtenerLibros()){
                    if(libro.getCodigo().equalsIgnoreCase(codigo)){
                       inventario.obtenerLibros().remove(libro);
                       return true;
                    }
                }
                break;
            case "REV":
                for(Revista revista:inventario.obtenerRevistas()){
                    if(revista.getCodigo().equalsIgnoreCase(codigo)){
                       inventario.obtenerRevistas().remove(revista);
                       return true;
                    }
                }
                break;
            case "CDA":
                for(CD cd:inventario.obtenerCds()){
                    if(cd.getCodigo().equalsIgnoreCase(codigo)){
                       inventario.obtenerCds().remove(cd);
                       return true;
                    }
                }
                break;
            case "DVD":
                for(DVD dvd:inventario.obtenerDvds()){
                    if(dvd.getCodigo().equalsIgnoreCase(codigo)){
                       inventario.obtenerDvds().remove(dvd);
                       return true;
                    }
                }
                break;
        }
        return false;
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
        String xml = new String ( Files.readAllBytes( Paths.get(this.file) ) );
        this.inventario = JAXB.unmarshal(new StringReader(xml), Inventario.class);
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
    
     public void ingresarNuevoMaterial(){
         int tipoMaterial = JOptionPane.showOptionDialog(null, "Que tipo de material ingresara"
                      , "CAJERO", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION
                      , null, MATERIALES, MATERIALES[0]);
         
         
         
         switch(tipoMaterial){
             case 0:
                 this.ingresarLibro();
                 break;
             case 1:
                 
                 break;
                 
             case 2:
                 
                 break;
                 
             case 3:
                 
                 break;
         }
    }
     
         
    private String ingresarTexto(String llave){
        return JOptionPane.showInputDialog("Ingrese el "+llave);
    }
    private int ingresarNumero(String llave){
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese el "+llave));
    }
    
    private void ingresarLibro(){
           String titulo = this.ingresarTexto("titulo");
                 String editorial = this.ingresarTexto("editorial");
                 String autor = this.ingresarTexto("autor");
                 String isbn = this.ingresarTexto("isbn");
                 int unidades = this.ingresarNumero("unidades");
                 int paginas = this.ingresarNumero("paginas");
                 this.ingresarNuevoLibro(titulo, editorial, unidades, autor, paginas, isbn, paginas);

    }
    
    public void mostrar(){
        Material material = this.buscarMaterial(this.ingresarTexto("Codigo"));
        if(material != null){
            JOptionPane.showMessageDialog(null, material);
        }else{
            JOptionPane.showMessageDialog(null, "material no encontrado");
        }
    }
    public void borrar(){
        
        if(this.borrarMaterial(this.ingresarTexto("Codigo"))){
            JOptionPane.showMessageDialog(null, "material borrado");
        }else{
            JOptionPane.showMessageDialog(null, "material no encontrado");
        }
    }
    
    public void listar(){
         String nl = System.getProperty("line.separator");
         String libros = this.inventario.obtenerLibros().stream().map(e->e.toString()).collect(Collectors.joining(nl));
         String revistas = this.inventario.obtenerRevistas().stream().map(e->e.toString()).collect(Collectors.joining(nl));
         String discos = this.inventario.obtenerCds().stream().map(e->e.toString()).collect(Collectors.joining(nl));
         String dvds = this.inventario.obtenerDvds().stream().map(e->e.toString()).collect(Collectors.joining(nl));
    
         JOptionPane.showMessageDialog(null, "Libros" + nl +libros);
         JOptionPane.showMessageDialog(null, "Revistas" + nl +revistas);
         JOptionPane.showMessageDialog(null, "CDA" + nl +discos);
         JOptionPane.showMessageDialog(null, "DVDS" + nl +dvds);
    }
}
