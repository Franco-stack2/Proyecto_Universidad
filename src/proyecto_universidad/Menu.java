/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;


import javax.swing.JOptionPane;

public class Menu {

    public void menuPrincipal(Generadorlibros generador,GeneradorSocios socios,GestionPrestamos gestion,GestionSocios gestionsocios) {

        String opcion;

do {

    opcion = JOptionPane.showInputDialog("""
        MENU PRINCIPAL
        1. Biblioteca
        2. Menu de Prestamos
        3. Catalogo
        4. Menu de Socios
        5. Reportes
        6. Salir
    """);

    switch (opcion) {

        case "1":
            generador.mostrarBiblioteca();
            socios.resumenSocios();
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
                        gestion.registrarPrestamo(generador.getLibros(),generador.getTotalLibros(),socios);
                        break;

                    case "2":
                        gestion.registrarDevolucion();
                        break;

                    case "3":
                         gestion.consultarPrestamo();
                        break;

                    case "4":
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                }

            } while (!opcionPrestamo.equals("4"));

            break;

        case "3":
            GestionCatalogo gestionCatalogo = new GestionCatalogo();
            gestionCatalogo.menuCatalogo(generador);
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
                        gestionsocios.ejecutarRegistro(socios);
                        break;

                    case "2":
                       // GestionSocios.ConsultarSocioID();
                        gestionsocios.Consultar(socios);
                        break;

                    case "3":
                        gestionsocios.actualizarEstadoSocio(socios);
                        break;

                    case "4":
                        gestionsocios.ConsultarMultas(socios);
                        break;

                    case "5":
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                }

            } while (!opcionSocio.equals("5"));

            break;

        case "5":
            JOptionPane.showMessageDialog(null, "En Construccion");
            break;
        case "6":
            JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opcion invalida");
        }

    } while (!opcion.equals("6")); // este while nos ayuda a que si entramos al sistema la persona solo pueda salir se marca la opcion 5
    }
}