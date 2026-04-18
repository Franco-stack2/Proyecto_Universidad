
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
            
            if (opcionCatalogo == null) {
                JOptionPane.showMessageDialog(null, "operacion cancelada");
                break;
            }
            
            switch (opcionCatalogo) {
                case "1":
                    mostrarCatalogoCompleto(generador);
                    break;
                    
                case "2":
                    agregarNuevoLibro(generador);
                    break;
                    
                case "3":
                    editarLibro(generador);
                    break;
                    
                case "4":
                    cambiarEstadoLibro(generador);
                    break;
                    
                case "5":
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
            
        } while (!opcionCatalogo.equals("5")); // Que se repita todo hasta que la opción sea 5.
    }
    
    private void mostrarCatalogoCompleto (Generadorlibros generador)
    {
        if (generador.getTotalLibros()==0){
            System.out.println("No hay libros registrados en el catálogo");
            JOptionPane.showMessageDialog(null,"No hay libros en el catalogo");
            
            return;
        }
        
        System.out.println("\n=== CATALOGO COMPLETO ===");
        generador.mostrarBiblioteca();
        
        JOptionPane.showMessageDialog(null,"Catalogo completo mostrado en consola");
    }
    
    // Este método agrega un nuevo libro al catalogo
    private void agregarNuevoLibro(Generadorlibros generador){
        // Validar limite de libros y si hay espacio.
        if(generador.getTotalLibros() >= 50) {
            JOptionPane.showMessageDialog(null, "Limite maximo de libros (50) alcanzado");
            return;
        }
        //Solicitar titulo
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro: ");
        if (titulo.equals("")) {
            JOptionPane.showMessageDialog(null, "opcion invalida");
            return;
        }
        if (titulo == null) {
            return;
        }
        // Solicitat autor
        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro: ");
        if (autor.equals("")) {
            JOptionPane.showMessageDialog(null, "opcion invalida");
            return;
        }
        if (autor == null) {
            return;
        }
        // Solicitar editorial
        String editorial = JOptionPane.showInputDialog("Ingrese la editorial del libro:");
        
        if (editorial.equals("")) {
            JOptionPane.showMessageDialog(null, "opcion invalida");
            return;
        }
        if (editorial == null) {
            return;
        }
        
        // Solicitar año de publicación
        String anioTexto = JOptionPane.showInputDialog("Ingrese el anio de publicacion:");
        if (anioTexto.equals("")) {
            JOptionPane.showMessageDialog(null, "opcion invalida");
            return;
        }
        if (anioTexto == null) {
            return;
        }
        
        int anio = Integer.parseInt(anioTexto);
        
        // Validar que el año sea positivo
        if (anio <= 0) {
            JOptionPane.showMessageDialog(null, "Anio de publicacion invalido. Debe ser mayor a 0.");
            return;
        }
        
        // Solicitar genero
        String opcionGenero = JOptionPane.showInputDialog( // Creo un menú con las 6 opciones del menú
            "Seleccione el genero:\n\n" +
            "1. NOVELA\n" +
            "2. CIENCIA_FICCION\n" +
            "3. HISTORIA\n" +
            "4. INFANTIL\n" +
            "5. POESIA\n" +
            "6. ENSAYO"
        );
        
        if (opcionGenero == null) {
            return;
        }
        
        Genero genero = null; // Aquí creo una variable genero, tipo de dato Genero y que está vacía
        
        switch (opcionGenero) { // De acuerdo a lo que elija como opción
            case "1":
                genero = Genero.NOVELA;
                break;
            case "2":
                genero = Genero.CIENCIA_FICCION;
                break;
            case "3":
                genero = Genero.HISTORIA;
                break;
            case "4":
                genero = Genero.INFANTIL;
                break;
            case "5":
                genero = Genero.POESIA;
                break;
            case "6":
                genero = Genero.ENSAYO;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion de genero invalida");
                return;
        }
        // Crea un nuevo libro
        Libro nuevoLibro = new Libro(titulo, autor, editorial, genero, anio); // El constructor genera automaticamente el ISBN...
        
        // Agrega al arreglo
        Libro[] libros = generador.getLibros(); // El arreglo está dentro de generador
        libros[generador.getTotalLibros()] = nuevoLibro; // Añade el nuevoLibro al arreglo, añade una nueva posición.
        generador.setTotalLibros(generador.getTotalLibros() + 1); // Actualiza el contador, el "TotalLibros"
        
        // Mostrar confirmación
        JOptionPane.showMessageDialog(
            null,
            "Libro agregado correctamente\n\n" +
            "ISBN: " + nuevoLibro.getIsbn() + "\n" +
            "Titulo: " + nuevoLibro.getTitulo() + "\n" +
            "Autor: " + nuevoLibro.getAutor() + "\n" +
            "Editorial: " + nuevoLibro.getEditorial() + "\n" +
            "Anio: " + nuevoLibro.getAnioPublicacion() + "\n" +
            "Genero: " + nuevoLibro.getGenero() + "\n" +
            "Estado: " + nuevoLibro.getEstadoLibro()
        );
    }
    
    // Este método edita la información de un libro existente
    private void editarLibro(Generadorlibros generador)
    {
        if (generador.getTotalLibros() == 0) // Verifica si existe al menos un 1 libro
        {
            JOptionPane.showMessageDialog(null, "No hay libros en el catálogo");
            return;            
        }
        
        // Solicitar ISBN del libro a editar
        String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro a editar: ");
        
        if (isbn == null){
            return;
        }
        
        // Buscar X libro
        Libro libroEncontrado = null;
        Libro[] libros = generador.getLibros();// libros es una referencia / copia al arreglo original
        
        for (int i = 0; i < generador.getTotalLibros(); i++) {
            if (libros[i].getIsbn().equals(isbn)) {
                libroEncontrado = libros[i]; // Guarda el libro encontrado
                break;
            }
        }
        
        if (libroEncontrado == null) {
            JOptionPane.showMessageDialog(null, "El libro con ISBN '" + isbn + "' no existe.");
            return;
        }
        
        menuEdicionLibro(libroEncontrado); // Pasa el libro que encontró al otro método para editarlo
    }
    
    private void menuEdicionLibro(Libro libro) // El método recibe al objeto de tipo Libro, que se encontró en 187
    {
        String opcionEdicion;
        
        do {
            opcionEdicion = JOptionPane.showInputDialog(
                "Editando: " + libro.getTitulo() + " (" + libro.getIsbn() + ")\n\n" +
                "1. Editar Titulo\n" +
                "2. Editar Autor\n" +
                "3. Editar Editorial\n" +
                "4. Editar Anio de Publicacion\n" +
                "5. Editar Genero\n" +
                "6. Atras"
            );
         switch (opcionEdicion) {
                case "1":
                    String nuevoTitulo = JOptionPane.showInputDialog("Ingrese el nuevo titulo:");
                    if (nuevoTitulo != null) {
                        libro.setTitulo(nuevoTitulo);
                        JOptionPane.showMessageDialog(null, "Titulo actualizado correctamente.");
                    }
                    break;
                    
                case "2":
                    String nuevoAutor = JOptionPane.showInputDialog("Ingrese el nuevo autor:");
                    if (nuevoAutor != null) {
                        libro.setAutor(nuevoAutor);
                        JOptionPane.showMessageDialog(null, "Autor actualizado correctamente.");
                    }
                    break;
                    
                case "3":
                    String nuevaEditorial = JOptionPane.showInputDialog("Ingrese la nueva editorial:");
                    if (nuevaEditorial != null) {
                        libro.setEditorial(nuevaEditorial);
                        JOptionPane.showMessageDialog(null, "Editorial actualizada correctamente.");
                    }
                    break;
                    
                case "4":
                    String anioTexto = JOptionPane.showInputDialog("Ingrese el nuevo anio de publicacion:");
                    if (anioTexto != null) {
                        int nuevoAnio = Integer.parseInt(anioTexto);
                        
                        if (nuevoAnio > 0) {
                            libro.setAnioPublicacion(nuevoAnio);
                            JOptionPane.showMessageDialog(null, "Anio actualizado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Anio invalido. Debe ser mayor a 0.");
                        }
                    }
                    break;
                    
                case "5":
                    String opcionGenero = JOptionPane.showInputDialog(
                        "Genero actual: " + libro.getGenero() + "\n\n" +
                        "Seleccione el nuevo genero:\n\n" +
                        "1. NOVELA\n" +
                        "2. CIENCIA_FICCION\n" +
                        "3. HISTORIA\n" +
                        "4. INFANTIL\n" +
                        "5. POESIA\n" +
                        "6. ENSAYO"
                    );
                    
                    if (opcionGenero != null) {
                        Genero nuevoGenero = null;
                        
                        switch (opcionGenero) {
                            case "1":
                                nuevoGenero = Genero.NOVELA;
                                break;
                            case "2":
                                nuevoGenero = Genero.CIENCIA_FICCION;
                                break;
                            case "3":
                                nuevoGenero = Genero.HISTORIA;
                                break;
                            case "4":
                                nuevoGenero = Genero.INFANTIL;
                                break;
                            case "5":
                                nuevoGenero = Genero.POESIA;
                                break;
                            case "6":
                                nuevoGenero = Genero.ENSAYO;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion invalida");
                        }
                        
                        if (nuevoGenero != null) {
                            libro.setGenero(nuevoGenero);
                            JOptionPane.showMessageDialog(null, "Genero actualizado correctamente.");
                        }
                    }
                    break;
                    
                case "6":
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
            
        } while (!opcionEdicion.equals("6"));
    }
        
    // Este método cambia el estado de los libros entre Disponible, en reparación y extraviado)
    private void cambiarEstadoLibro(Generadorlibros generador) { // Objeto generador de tipo Generadorlibros.
        if (generador.getTotalLibros() == 0) {
            JOptionPane.showMessageDialog(null, "No hay libros en el catalogo");
            return;
        }

        // Solicitar ISBN
        String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro:");

        if (isbn == null) {
            return; // Usuario canceló
        }

        //Buscar libro
        Libro libroEncontrado = null; // Aquí se guarda el libro cuando lo encuentre
        Libro[] libros = generador.getLibros(); // Se obtiene el arreglo de libros

        for (int i = 0; i < generador.getTotalLibros(); i++) {
            if (libros[i].getIsbn().equals(isbn)) {
                libroEncontrado = libros[i]; // Aquí se guarda el libro en "libroEncontrado"
                break;
            }
        }
        if (libroEncontrado == null) {
            JOptionPane.showMessageDialog(null, "El libro con ISBN '" + isbn + "' no existe.");
            return;
        }
        //Aquí se valida si el libro está prestado
        if (libroEncontrado.getEstadoLibro() == EstadoLibro.PRESTADO) {
            JOptionPane.showMessageDialog(
                null,
                "El libro '" + libroEncontrado.getTitulo() + "" + isbn + " esta PRESTADO.\n" +
                "No se puede cambiar su estado directamente aqui.\n" +
                "Debe ser devuelto primero."
            );
            return;
        }
        
        String opcionEstado = JOptionPane.showInputDialog( // Aquí se muestra el menú
             "Libro: " + libroEncontrado.getTitulo() + " (" + isbn + ")\n" +
            "Estado actual: " + libroEncontrado.getEstadoLibro() + "\n\n" +
            "Seleccione el nuevo estado:\n\n" +
            "1. DISPONIBLE\n" +
            "2. EN_REPARACION\n" +
            "3. EXTRAVIADO\n" +
            "4. Cancelar"   
        );
        
        if (opcionEstado == null){
            return;
        }
        switch (opcionEstado) {
            case "1":
                libroEncontrado.devolver();
                JOptionPane.showMessageDialog(
                        null,
                        "Estado del libro '" + libroEncontrado.getTitulo()+" "+ isbn + "\n"
                        + "cambiado a DISPONIBLE."
                );
                break;

            case "2": // Aqui se usa cambiarEstado porque no existe un método específico para reparación y así se convierte
                libroEncontrado.cambiarEstado(EstadoLibro.EN_REPARACION); // Aquí se llama al método "cambiarEstado"
                JOptionPane.showMessageDialog( // Lo pasa al estado " En reparación"
                        null,
                        "Estado del libro '" + libroEncontrado.getTitulo() +" "+ isbn +"\n"
                        + "cambiado a EN_REPARACION."
                );
                break;

            case "3":
                libroEncontrado.extraviado();
                JOptionPane.showMessageDialog(
                        null,
                        "Estado del libro '" + libroEncontrado.getTitulo() +" "+ isbn + "\n"
                        + "cambiado a EXTRAVIADO."
                );
                break;
            case "4":
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
        }

    
    }
    
}