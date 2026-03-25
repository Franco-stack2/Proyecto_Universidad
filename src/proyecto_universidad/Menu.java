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
        2. Menu de Prestamos
        3. Catalogo
        4. Menu de Socios
        5. Salir
    """);

    switch (opcion) {

        case "1":
            Generadorlibros.mostrarBiblioteca(libros, totalLibros);
            GeneradorSocios.resumenSocios();
            JOptionPane.showMessageDialog(null, "Informacion mostrada en consola");
            break;

        case "2":

            String opcionPrestamo;

            do { // se realiza un submenu en el case 2 con otro switch y sus respectivos casos y llamados a metodos de otras clases y objetos

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
            JOptionPane.showMessageDialog(null, "Catalogo en construccion");
            break;

        case "4":

            String opcionSocio;

            do { // se hace un do while y otro switch anidado como submenu para realizar el menu de socios 

                opcionSocio = JOptionPane.showInputDialog("""
                    MENU SOCIOS

                    1. Registrar Nuevo Socio
                    2. Consultar Datos de Socio
                    3. Actualizar Información de Socio
                    4. Gestionar Multas de Socio
                    5. Salir
                """);

                switch (opcionSocio) {

                    case "1":
                        GestionSocios.registrarSocio();
                        break;

                    case "2":
                        JOptionPane.showMessageDialog(null, "Pendiente");
                        break;

                    case "3":
                        JOptionPane.showMessageDialog(null, "Pendiente");
                        break;

                    case "4":
                        JOptionPane.showMessageDialog(null, "Pendiente");
                        break;

                    case "5":
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                }

            } while (!opcionSocio.equals("5"));

            break;

        case "5":
            JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
            break;

        default:
            JOptionPane.showMessageDialog(null, "Opcion invalida");
        }

    } while (!opcion.equals("5")); // este while nos ayuda a que si entramos al sistema la persona solo pueda salir se marca la opcion 5
    }
}