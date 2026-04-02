/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;



public class Libro {
    
  private int AnioPublicacion;
  
  private String isbn,titulo,autor,editorial;
  
  private int vecesPrestado = 0;  

  private Genero genero;
  
  private EstadoLibro estadoLibro;
  
  private static int contadorISBN = 1;
  


public Libro(String titulo, String autor, String editorial, Genero genero, int AnioPublicacion){
    
        
        this.isbn = generarISBN();
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editorial = editorial;
        this.AnioPublicacion = AnioPublicacion;
        this.estadoLibro = EstadoLibro.DISPONIBLE;

    }

    
private String generarISBN() {
        String codigo;

if(contadorISBN < 10){ // aquí se realiza un contador con if y else if para poder realizar el generador de codigo la forma mas organica posible
    codigo = "LIB-00" + contadorISBN;
}
else if(contadorISBN < 100){
    codigo = "LIB-0" + contadorISBN;
}
else{
    codigo = "LIB-" + contadorISBN;
}
contadorISBN++;
    return codigo;

    }


 public void prestar() {
        estadoLibro = EstadoLibro.PRESTADO;
        vecesPrestado++;
    }

  public void extraviado() {
        estadoLibro = EstadoLibro.EXTRAVIADO;
        vecesPrestado++;
    }
 
 
    public void devolver() {
        estadoLibro = EstadoLibro.DISPONIBLE;
    }


    public void mostrarLibro(){

    System.out.println(
        isbn + " | " +
        titulo + " | " +
        autor + " | " +
        genero + " | " +
        estadoLibro + " | Prestado: " +
        vecesPrestado
    );
}
    
  
    
    
    
public int getAnioPublicacion() {
        return AnioPublicacion;
    }

    public void setAnioPublicacion(int AnioPublicacion) {
        this.AnioPublicacion = AnioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getVecesPrestado() {
        return vecesPrestado;
    }


    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public EstadoLibro getEstadoLibro() {
        return estadoLibro;
    }


    public static int getContadorISBN() {
        return contadorISBN;
    }

    public String getIsbn() {
    return isbn;}
    
public void cambiarEstado(EstadoLibro nuevoEstado) {
    this.estadoLibro = nuevoEstado;
}    
}