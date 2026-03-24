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
            2. Ingresar al menu de prestamos
            """);

            switch(opcion){

                case "1":
                    Generadorlibros.mostrarBiblioteca(libros, totalLibros); // resumen de libros
                    JOptionPane.showMessageDialog(null, "Datos mostrados en consola");
                    GeneradorSocios.resumenSocios();

                    JOptionPane.showMessageDialog(null, "Informacion mostrada en consola"); // este es el resumen de socios
                    break;

                case "2":
               String opcionPrestamo;

              do{ // se realiza un do para que el menu se ejecute al menos una vez

        opcionPrestamo = JOptionPane.showInputDialog("""
            MENU PRESTAMOS

            1. Registrar Prestamo
            2. Registrar Devolucion
            3. Consultar Prestamo por ID
            4. Salir
        """);

        switch(opcionPrestamo){

            case "1":
                GestionPrestamos.registrarPrestamo(libros, totalLibros);
                break;

            case "2":
                GestionPrestamos.registrarDevolucion();
                break;

            case "3":
                GestionPrestamos.consultarPrestamo();
                break;

            case "4":
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
        }

    }while(!opcionPrestamo.equals("4"));

    break;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
