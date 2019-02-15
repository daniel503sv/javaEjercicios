
package sv.edu.udb.tercero;

import javax.xml.bind.annotation.XmlRootElement;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/
@XmlRootElement(name = "libro")
public class Libro extends MaterialEscrito{

    private String autor;
    private int numPaginas;
    private String isbn;
    private int anhoPub;
    private static final String TIPO = Material.LIBRO;

    public Libro(){
        super();
    }
    //Constructor de Libro
    public Libro(String codigo,String titulo,String editorial,int unidades,String autor,int numPaginas, String ISBN, int anioPub){
        super(codigo,titulo,editorial,unidades);
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.isbn = ISBN;
        this.anhoPub = anioPub;   
    }
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
    
    public void listarMateriales(){
    
    }
    
}
