/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Reportes {
    
  
     public void topLibros(Generadorlibros generador){
     
         System.out.println("TOP 5 LIBROS:");
         
         Libro[] libros = generador.getLibros();
        int total = generador.getTotalLibros();
   
      boolean[] usado = new boolean[total];

for(int k = 0; k < 5 && k < total; k++){

    int indiceMayor = -1; // aqui se inicia con -1 porque no hay candidato aun entonces se agarra cualquier libro para que sea el punto de comparacion

    for(int i = 0; i < total; i++){

        if(!usado[i]){ 

            if(indiceMayor == -1 || 
               libros[i].getVecesPrestado() > libros[indiceMayor].getVecesPrestado()){ // este or es el que nos da el paso para que una de las opciones sea que -1 sea el primer libro

                indiceMayor = i;
            }
        }
    }

    
    usado[indiceMayor] = true; // con el !usado de antes se usa esto para tachar un libro que ya fue evaluado

    // mostrar
    System.out.println(
        libros[indiceMayor].getIsbn() + " | " +
        libros[indiceMayor].getTitulo() + " | " +
        libros[indiceMayor].getVecesPrestado()
    );
}
     
}
        public void topSocios(GestionPrestamos gestion){

        ArrayList<Prestamo> lista = gestion.getListaPrestamos();

    ArrayList<Socio> sociosUnicos = new ArrayList<>();
    ArrayList<Integer> contadorPrestamos = new ArrayList<>();


    for(int i = 0; i < lista.size(); i++){

        Socio s = lista.get(i).getSocio();

        int pos = -1;

        for(int j = 0; j < sociosUnicos.size(); j++){
            if(sociosUnicos.get(j).getIdSocio().equals(s.getIdSocio())){
                pos = j;
                break;
            }
        }

        if(pos == -1){
            sociosUnicos.add(s);
            contadorPrestamos.add(1);
        }else{
            contadorPrestamos.set(pos, contadorPrestamos.get(pos) + 1);
        }
    }

    int total = sociosUnicos.size();

    boolean[] usado = new boolean[total];

    System.out.println("TOP 5 SOCIOS:");

    // se aplica la misma logica para ordenar mayor
    for(int k = 0; k < 5 && k < total; k++){

        int indiceMayor = -1;

        for(int i = 0; i < total; i++){

            if(!usado[i]){

                if(indiceMayor == -1 || 
                   contadorPrestamos.get(i) > contadorPrestamos.get(indiceMayor)){

                    indiceMayor = i;
                }
            }
        }

        usado[indiceMayor] = true;

        System.out.println(
            sociosUnicos.get(indiceMayor).getIdSocio() + " | " +
            sociosUnicos.get(indiceMayor).getNombreCompleto() + " | " +
            contadorPrestamos.get(indiceMayor)
        );
    }
}
     
    public void sociosMorosos(GeneradorSocios socios){
    
    for(int i = 0; i < socios.getListaSocios().size(); i++){ // se inicializa para que se recorran todos los socios uno por uno con el .size
    
        Socio s = socios.getListaSocios().get(i);// se crea el objeto que va a representar al socio que va a pasar por el if
        
        if(s.getEstadoSocio() == Estadosocio.MOROSO || s.getMultasAcumuladas() > 0){
        
       System.out.println(
                    s.getIdSocio() + " | " +
                    s.getNombreCompleto() + " | " +
                    s.getMultasAcumuladas());
     
        }
    
    }
    
 
    }
     
     
     
     public void historialSocio(GestionPrestamos gestion){

    String id = JOptionPane.showInputDialog("Ingrese ID socio:");

    ArrayList<Prestamo> lista = gestion.getListaPrestamos();

    for(int i = 0; i < lista.size(); i++){

        Prestamo p = lista.get(i);

        if(p.getSocio().getIdSocio().equals(id)){

            System.out.println(
                "Prestamo: " + p.getIdPrestamo() +
                " | Libro: " + p.getLibro().getTitulo() +
                " | Estado: " + p.getEstadoPrestamo()
            );
        }
    }
}
       
    public void librosPorEstado(Generadorlibros generador){

        Libro[] libros = generador.getLibros();
        int total = generador.getTotalLibros();

        int disponibles = 0;
        int prestados = 0;
        int reparacion = 0;
        int extraviados = 0;

        for(int i = 0; i < total; i++){

            if(null != libros[i].getEstadoLibro())switch (libros[i].getEstadoLibro()) {
                case DISPONIBLE:
                    disponibles++;
                    break;
                case PRESTADO:
                    prestados++;
                    break;
                case EN_REPARACION:
                    reparacion++;
                    break;
                case EXTRAVIADO:
                    extraviados++;
                    break;
                default:
                    break;
            }
        }

        System.out.println("Disponibles: " + disponibles);
        System.out.println("Prestados: " + prestados);
        System.out.println("En reparacion: " + reparacion);
        System.out.println("Extraviados: " + extraviados);
    }

     
     
}
