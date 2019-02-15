/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.tercero;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josed
 */

@XmlRootElement
public class Inventario {
    
  // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "libros") 
    @XmlElement(name = "libro")
    private List<Libro> libros;
    @XmlElementWrapper(name = "revistas") 
    @XmlElement(name = "revista")
    private List<Revista> revistas;
    @XmlElementWrapper(name = "cds") 
    @XmlElement(name = "cd")
    private List<CD> cds;
    @XmlElementWrapper(name = "dvds") 
    @XmlElement(name = "dvd")
    private List<DVD> dvds;

    public int getNumeroCorrelativo() {
        return numeroCorrelativo;
    }

    public void setNumeroCorrelativo(int numeroCorrelativo) {
        this.numeroCorrelativo = numeroCorrelativo;
    }
    private int numeroCorrelativo;
    
    public Inventario(){
   
        this.libros = new ArrayList<>();
        this.revistas = new ArrayList<>();
        this.cds = new ArrayList<>();
        this.dvds = new ArrayList<>();
        this.numeroCorrelativo = 0;

    }

    public List<Libro> obtenerLibros() {
        return libros;
    }

    public void ingresarLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
    public void ingresarNuevoLibro(String titulo,String editorial,int unidades,String autor,int numPaginas, String ISBN, int anioPub){
        Libro libro = new Libro(
                "LIB"+String.format ("%05d", this.numeroCorrelativo++),
                titulo,
                editorial,
                unidades,
                autor,
                numPaginas,
                ISBN, 
                anioPub);
      
        this.libros.add(libro);
    }
    public void ingresarNuevaRevista(String titulo,String editorial, int unidades,String periodicidad,String fechaPub){
        Revista revista = new Revista(
                "REV"+String.format ("%05d", this.numeroCorrelativo++),
                 titulo,editorial,unidades,periodicidad,fechaPub
                );
      
        this.revistas.add(revista);
    }
    
     public void ingresarNuevoCd(String titulo,String duracion,String genero,String artista,int numCanciones,int unidades){
        CD cd = new CD(
                "CDA"+String.format ("%05d", this.numeroCorrelativo++),
                 titulo,duracion,genero,artista,numCanciones,unidades
                );
      
        this.cds.add(cd);
    }
     public void ingresarNuevoDvd(String titulo,String duracion, String genero,String director){
        DVD dvd = new DVD(
                "CDA"+String.format ("%05d", this.numeroCorrelativo++),
                 titulo,duracion,genero,director
                );
      
        this.dvds.add(dvd);
    }
    public void ingresarNuevaRevista(Revista revista){
        revista.setCodigo( "LIB"+String.format ("{%05d}", this.numeroCorrelativo++));
        this.revistas.add(revista);
    }
    public void ingresarNuevoCd(CD cd){
        cd.setCodigo( "CDA"+String.format ("{%05d}", this.numeroCorrelativo++));
        this.cds.add(cd);
    }
    public void ingresarNuevoDvd(DVD dvd){
        dvd.setCodigo( "LIB"+String.format ("{%05d}", this.numeroCorrelativo++));
        this.dvds.add(dvd);
    }

    public List<Revista> obtenerRevistas() {
        return revistas;
    }

    public void ingresarRevistas(List<Revista> revistas) {
        this.revistas = revistas;
    }

    public List<CD> obtenerCds() {
        return cds;
    }

    public void ingresarCds(List<CD> cds) {
        this.cds = cds;
    }

    public List<DVD> obtenerDvds() {
        return dvds;
    }

    public void ingresarDvds(List<DVD> dvds) {
        this.dvds = dvds;
    }
    
    public void guardarNuevoMaterial(Material material){
        
    }
 
}
