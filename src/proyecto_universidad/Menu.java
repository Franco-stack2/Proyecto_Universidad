/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;


import javax.swing.JOptionPane;


public class Menu {
    
    public static void menuPrincipal(Libro[] libros, int totalLibros){

        String opcion;

        do{

            opcion = JOptionPane.showInputDialog(
            """
            MENU PRINCIPAL
            1. Biblioteca
            2. Salir
            """);

            switch(opcion){

                case "1":
                    Generadorlibros.mostrarBiblioteca(libros, totalLibros);
                    JOptionPane.showMessageDialog(null, "Datos mostrados en consola");
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }

        }while(!opcion.equals("2"));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
