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
    @XmlElementWrapper(name="libros")
    @XmlElement(name="libro")
    private List<Libro> libros;
    @XmlElementWrapper(name="revistas")
    @XmlElement(name="revista")
    private List<Revista> revistas;
    @XmlElementWrapper(name="cds")
    @XmlElement(name="cd")
    private List<CD> cds;
    @XmlElementWrapper(name="dvds")
    @XmlElement(name="dvd")
    private List<DVD> dvds;
   
    public Inventario(){
   
        this.libros = new ArrayList<>();
        this.revistas = new ArrayList<>();
        this.cds = new ArrayList<>();
        this.dvds = new ArrayList<>();

    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Revista> getRevistas() {
        return revistas;
    }

    public void setRevistas(List<Revista> revistas) {
        this.revistas = revistas;
    }

    public List<CD> getCds() {
        return cds;
    }

    public void setCds(List<CD> cds) {
        this.cds = cds;
    }

    public List<DVD> getDvds() {
        return dvds;
    }

    public void setDvds(List<DVD> dvds) {
        this.dvds = dvds;
    }
 
}
