/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;


public class Reportes {
    
  
     public void topLibros(Generadorlibros generador){
     
         System.out.println("TOP 5 LIBROS:");
         
         Libro[] libros = generador.getLibros();
        int total = generador.getTotalLibros();
   
      boolean[] usado = new boolean[total];

for(int k = 0; k < 5 && k < total; k++){

    int indiceMayor = -1;

    for(int i = 0; i < total; i++){

        if(!usado[i]){ 

            if(indiceMayor == -1 || 
               libros[i].getVecesPrestado() > libros[indiceMayor].getVecesPrestado()){

                indiceMayor = i;
            }
        }
    }

    // marcar como usado
    usado[indiceMayor] = true;

    // mostrar
    System.out.println(
        libros[indiceMayor].getIsbn() + " | " +
        libros[indiceMayor].getTitulo() + " | " +
        libros[indiceMayor].getVecesPrestado()
    );
}
     
}
       
  
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
