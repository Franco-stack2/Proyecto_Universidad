/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;


public class Reportes {
    
  
     public void topLibros(Generadorlibros generador){
     
         Libro[] libros = generador.getLibros();
        int total = generador.getTotalLibros();
     
     for(int i = 0; i < total; i++){
            for(int j = i + 1; j < total; j++){

                if(libros[i].getVecesPrestado() < libros[j].getVecesPrestado()){

                    Libro provisional = libros[i];
                    libros[i] = libros[j];
                    libros[j] = provisional;
                }
            }
        }

        System.out.println("TOP 5 LIBROS:");

        for(int i = 0; i < 5 && i < total; i++){
            System.out.println(
                libros[i].getIsbn() + " | " +
                libros[i].getTitulo() + " | " +
                libros[i].getVecesPrestado()
            );
        }
    
     
     }
    
         
         
    
}
