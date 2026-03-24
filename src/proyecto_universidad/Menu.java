/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;


import javax.swing.JOptionPane;

public class Menu {

    public static void menuPrincipal(Libro[] libros, int totalLibros) {

        String opcion;

        do {

            opcion = JOptionPane.showInputDialog("""
                MENU PRINCIPAL
                1. Biblioteca
                2. Ingresar al menu de prestamos
                3. Salir
            """);

            switch (opcion) {

                case "1":
                    Generadorlibros.mostrarBiblioteca(libros, totalLibros);
                    GeneradorSocios.resumenSocios();
                    JOptionPane.showMessageDialog(null, "Informacion mostrada en consola");
                    break;

                case "2":

                    String opcionPrestamo;

                    do {

                        opcionPrestamo = JOptionPane.showInputDialog("""
                            MENU PRESTAMOS

                            1. Registrar Prestamo
                            2. Registrar Devolucion
                            3. Consultar Prestamo por ID
                            4. Salir
                        """);

                        switch (opcionPrestamo) {

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

                    } while (!opcionPrestamo.equals("4"));

                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }

        } while (!opcion.equals("3"));
    }
}