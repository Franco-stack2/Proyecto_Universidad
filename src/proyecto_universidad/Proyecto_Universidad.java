/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_universidad;


import javax.swing.JOptionPane;

public class Proyecto_Universidad {

      static Libro[] libros = new Libro[50]; // se realizan los static ya que esto representa un beneficio en ahorrarnos en crear el objeto uno por uno
      static Socio[] socios = new Socio[30]; // por ejemplo el objeto libros se comprende como que hay 50 libros y no hay que crear libro1,libro2 que es mas tedioso
      static Prestamo[] prestamos = new Prestamo[50];

      static int totalLibros = 0; // este inicializador nos ayuda a mantener los valores iniciales en cero y asegurarnos de que el conteo empieze correctamente
      static int totalSocios = 0;
      static int totalPrestamos = 0;
    
    
    
    public static void main(String[] args) {
  
        
       generarLibros(20);
       generarSocios(10); 
   
     
     
     
    }
    
    public static void generarLibros(int cantidad){

// codigo para generar libros

}
    
   public static void generarSocios(int cantidad){

// codigo para generar socios

} 
    
    
}
