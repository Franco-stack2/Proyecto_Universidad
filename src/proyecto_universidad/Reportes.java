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
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
