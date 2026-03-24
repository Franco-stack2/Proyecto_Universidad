/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_universidad;


import javax.swing.JOptionPane;

public class Proyecto_Universidad {


    public static void main(String[] args) {
  
      Libro[] libros = new Libro[50];
        int totalLibros = 0;

        totalLibros = Generadorlibros.cargarLibros(libros, totalLibros, 5);

        Menu.menuPrincipal(libros, totalLibros); // se llama al primer menu que va a visualizar el usuario
  
        
        
        
    // Parte para generar la cantidad de socios
    /*
        String input = JOptionPane.showInputDialog("Cuantos socios desea generar?");
        int cantidad = Integer.parseInt(input);

        GeneradorSocios.cargarSocios(cantidad);
        GeneradorSocios.mostrarSocios();
    */
    }
    

    }

     
    

