/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;

/**
 *
 * @author Usuario
 */
public class Generadorlibros {
    
    static Libro[] libros = new Libro[50]; // se realizan los static ya que esto representa un beneficio en ahorrarnos en crear el objeto uno por uno
      static Socio[] socios = new Socio[30]; // por ejemplo el objeto libros se comprende como que hay 50 libros y no hay que crear libro1,libro2 que es mas tedioso
      static Prestamo[] prestamos = new Prestamo[50];

      static String[] titulos = {
      "Cien Anios de Soledad",
      "El Principito",
      "1984",
      "Don Quijote de la Mancha",
      "La Metamorfosis",
      "El Hobbit",
      "Dracula",
      "Fahrenheit 451"
       };

      static String[] autores = {
      "Gabriel Garcia Marquez",
      "Antoine de Saint Exupery",
      "George Orwell",
      "Miguel de Cervantes",
      "Franz Kafka",
      "JRR Tolkien",
      "Bram Stoker",
      "Ray Bradbury"
      };

      static String[] editoriales = {
      "Planeta",
      "Penguin",
      "Alfaguara",
      "Anagrama",
      "Random House"
      };
    // lo siguiente seria la lista de socios con nombres y apellidos
      static String[] nombres = {
      "Carlos","Ana","Luis","Maria","Mohamed","Laura","Jose","Daniela"
      };

      static String[] apellidos = {
      "Lopez","Ramirez","Fernandez","Gomez","Soto","Vargas","Morales"
      };
    
      static int totalLibros = 0; // este inicializador nos ayuda a mantener los valores iniciales en cero y asegurarnos de que el conteo empieze correctamente
      static int totalSocios = 0; // tambien se utiliza el static para que esta variable pueda ser utilizada en otros metodos y no este desconectada
      static int totalPrestamos = 0;
    

    public static void generarLibros(int cantidad){

    Genero[] generos = Genero.values(); // el values me sirve para tener los valores de la clase "genero" creada en el objeto de libro

     for(int i=0;i<cantidad;i++){

     String titulo = titulos[(int)(Math.random()*titulos.length)]; // el math.random nos genera un decimal donde el "titulos.length" da una posicion entre los libros
     String autor = autores[(int)(Math.random()*autores.length)]; // el int es para permitir que ese numero sea cerrado y cuando el ciclo termine autores tenga un numero
     String editorial = editoriales[(int)(Math.random()*editoriales.length)]; // en el cual poder elegir de la lista de libros totalmente random

     Genero genero = generos[(int)(Math.random()*generos.length)];

     int anio = 1950 + (int)(Math.random()*74); // esta linea nos genera un numero aleatorio entre el 1950 a 2023

      Libro libro = new Libro(titulo,autor,editorial,genero,anio);

     libros[totalLibros] = libro;

     totalLibros++;

     libros[i].mostrarLibro(); // esta linea es una prueba para ver si generar libros funciona
}
    
}
}
