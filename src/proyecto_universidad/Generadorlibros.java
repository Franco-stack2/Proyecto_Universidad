/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;

/**
 *
 * @author Franco
 */
public class Generadorlibros {

 

    
      private Libro[] libros = new Libro[50]; // se realizan los static ya que esto representa un beneficio en ahorrarnos en crear el objeto uno por uno
      private Socio[] socios = new Socio[30]; // por ejemplo el objeto libros se comprende como que hay 50 libros y no hay que crear libro1,libro2 que es mas tedioso
      private Prestamo[] prestamos = new Prestamo[50];
      
      private int totalLibros;
    

      private String[] titulos = {
      "Cien Anios de Soledad",
      "El Principito",
      "1984",
      "Don Quijote de la Mancha",
      "La Metamorfosis",
      "El Hobbit",
      "Dracula",
      "Fahrenheit 451"
       };

      private String[] autores = {
      "Gabriel Garcia Marquez",
      "Antoine de Saint Exupery",
      "George Orwell",
      "Miguel de Cervantes",
      "Franz Kafka",
      "JRR Tolkien",
      "Bram Stoker",
      "Ray Bradbury"
      };

      private String[] editoriales = {
      "Planeta",
      "Penguin",
      "Alfaguara",
      "Anagrama",
      "Random House"
      };


    
          private  Libro generarLibro(){

        Genero[] generos = Genero.values();

        String titulo = titulos[(int)(Math.random()*titulos.length)];
        String autor = autores[(int)(Math.random()*autores.length)];
        String editorial = editoriales[(int)(Math.random()*editoriales.length)];

        Genero genero = generos[(int)(Math.random()*generos.length)];

        int anio = 1950 + (int)(Math.random()*77); // esta linea de codigo nos da un margen de 1950 a 2026 para no tener fechas como 2027 porque no son validas

        return new Libro(titulo, autor, editorial, genero, anio);

          }
        
 
          
    public void mostrarBiblioteca(){

    for(int i = 0; i < totalLibros; i++){
        libros[i].mostrarLibro();
    }

}

    public int cargarLibros(int cantidad){ // si la cantidad de libros supera la de 50 se hace el print de limite alcanzado

    for(int i = 0; i < cantidad; i++){

        
        if(totalLibros >= 50){
            System.out.println("Limite alcanzado");
            return totalLibros;
        }

        libros[totalLibros] = generarLibro();

        totalLibros++;
    }

    return totalLibros;
}

        public int getTotalLibros() {
        return totalLibros;
    }

    public void setTotalLibros(int totalLibros) {
        this.totalLibros = totalLibros;
    }
    
       public Libro[] getLibros() {
        return libros;
    }

    public void setLibros(Libro[] libros) {
        this.libros = libros;
    }

    public Socio[] getSocios() {
        return socios;
    }

    public void setSocios(Socio[] socios) {
        this.socios = socios;
    }

    public Prestamo[] getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Prestamo[] prestamos) {
        this.prestamos = prestamos;
    }

    public String[] getTitulos() {
        return titulos;
    }

    public void setTitulos(String[] titulos) {
        this.titulos = titulos;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public String[] getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(String[] editoriales) {
        this.editoriales = editoriales;
    }

}
