
package proyecto_universidad;

import javax.swing.JOptionPane;

// Esta clase es para gestionar el catálogo de libros
public class GestionCatalogo 
{
    public void menuCatalogo(Generadorlibros generador){
        String opcionCatalogo;
        
        // El do ejecuta al menos una vez el código de adentro.
        do {
            opcionCatalogo = JOptionPane.showInputDialog("""
                MENU CATALOGO
                
                1. Mostrar Catalogo Completo
                2. Agregar Nuevo Libro
                3. Editar Informacion de Libro
                4. Cambiar Estado de Libro
                5. Salir
            """);
            
            switch (opcionCatalogo) {
                case "1":
                    mostrarCatalogoCompleto(generador);
                    break;
                    
                case "2":
                    agregarNuevoLibro(generador);
                    break;
                    
                case "3":
                   // editarLibro(generador);
                    break;
                    
                case "4":
                    cambiarEstadoLibro(generador);
                    break;
                    
                case "5":
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
            
        } while (!opcionCatalogo.equals("5"));
    }
    
    // Este método cambia el estado de los libros entre Disponible, en reparación, extraviado)
    private void cambiarEstadoLibro(Generadorlibros generador) {
        if (generador.getTotalLibros() == 0) {
            JOptionPane.showMessageDialog(null, "No hay libros en el catalogo");
            return;
        }

        // Solicitar ISBN
        String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro:");

        if (isbn == null || isbn.trim().isEmpty()) {
            return; // Usuario canceló
        }

         Buscar libro
        Libro libro = buscarLibroPorISBN(generador, isbn);

       if (libro == null) {
            int opcion = JOptionPane.showConfirmDialog(
                    null,
                    "El libro con ISBN '" + isbn + "' no existe.\n¿Desea ingresar otro ISBN?",
                    "Libro no encontrado",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcion == JOptionPane.YES_OPTION) {
                cambiarEstadoLibro(generador); // Reintentar
            }
            return;
        }

         Validar si está prestado
        if (libro.getEstadoLibro() == EstadoLibro.PRESTADO) {
           JOptionPane.showMessageDialog(
                    null,
                    "El libro '" + libro.getTitulo() + "' (" + isbn + ") esta PRESTADO.\n"
                    + "No se puede cambiar su estado directamente aqui.\n"
                    + "Debe ser devuelto primero."
            );
            return;
        }

        // Mostrar menú simple de opciones
        String opcionEstado = JOptionPane.showInputDialog(
                "Libro: " + libro.getTitulo() + " (" + isbn + ")\n"
                + "Estado actual: " + libro.getEstadoLibro() + "\n\n"
                + "Seleccione el nuevo estado:\n\n"
                + "1. DISPONIBLE\n"
                + "2. EN_REPARACION\n"
                + "3. EXTRAVIADO\n"
                + "4. Cancelar"
        );

        // Procesar la selección
        if (opcionEstado == null) {
            return; // Usuario canceló
        }

        switch (opcionEstado) {
            case "1":
                libro.devolver(); // Cambia a DISPONIBLE
                JOptionPane.showMessageDialog(
                        null,
                        "Estado del libro '" + libro.getTitulo() + "' (" + isbn + ")\n"
                        + "cambiado a DISPONIBLE."
                );
                break;

            case "2":
                libro.cambiarEstado(EstadoLibro.EN_REPARACION);
                JOptionPane.showMessageDialog(
                        null,
                        "Estado del libro '" + libro.getTitulo() + "' (" + isbn + ")\n"
                        + "cambiado a EN_REPARACION."
                );
                break;

            case "3":
                libro.extraviado(); // Cambia a EXTRAVIADO
                JOptionPane.showMessageDialog(
                        null,
                        "Estado del libro '" + libro.getTitulo() + "' (" + isbn + ")\n"
                        + "cambiado a EXTRAVIADO."
                );
                break;

            case "4":
                // No hacer nada, cancelar
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
        }
    }
    // Buscar un libro por ISBN 
}
       

    
    
    

