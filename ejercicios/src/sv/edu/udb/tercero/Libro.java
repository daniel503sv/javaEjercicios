
package sv.edu.udb.tercero;

/*Integrantes: 
*              Jose Chinchilla
*              Oscar Aragón
*              Rafael Lara
*              Daniel Choriego
*/
public class Libro extends MaterialEscrito{

    private String autor;
    private int numPaginas;
    private String isbn;
    private int anhoPub;
    
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
