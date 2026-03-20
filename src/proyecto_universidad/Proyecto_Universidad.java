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

        totalLibros = Generadorlibros.cargarLibros(libros, totalLibros, 10);

        Generadorlibros.mostrarBiblioteca(libros, totalLibros);
  
    }
    

    }

    
    

