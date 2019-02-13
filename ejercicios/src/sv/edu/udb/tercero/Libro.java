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
public class Libro extends MaterialEscrito{

    private String autor;
    private int numPaginas;
    private String isbn;
    private int anhoPub;
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnhoPub() {
        return anhoPub;
    }

    public void setAnhoPub(int anhoPub) {
        this.anhoPub = anhoPub;
    }
    
    
    
}
