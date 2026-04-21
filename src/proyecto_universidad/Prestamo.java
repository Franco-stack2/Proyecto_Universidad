/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author bbadi
 */
public class Prestamo {
    
    private static int contador = 1000;

    private int idPrestamo;
    private Socio socio;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaDevolucionEstimada;
    private String fechaDevolucionReal;
    private EstadoPrestamo estadoPrestamo;

    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private double multaGeneradaEstePrestamo;

    public Prestamo(Socio socio, Libro libro, String fechaPrestamo) {
        this.idPrestamo = contador++;
        this.socio = socio;
        this.libro = libro;
        LocalDate hoy = LocalDate.now();
        this.fechaPrestamo = hoy.format(formato);
        this.fechaDevolucionEstimada = "15 dias despues"; 
        this.fechaDevolucionReal = null;
        this.estadoPrestamo = EstadoPrestamo.ACTIVO;
        this.multaGeneradaEstePrestamo = 0.0;
    }
    
    public void devolverLibros(String fechaReal, boolean retraso){ // aqui continua la logica de devolver con retraso con que si es false entonces va al else y si es
      this.fechaDevolucionReal = fechaReal; // si es true entonces se devuelve con retraso

        if (retraso) {
            this.estadoPrestamo = EstadoPrestamo.DEVUELTO_CON_RETRASO;
            this.multaGeneradaEstePrestamo = 1000; 
        } else {
            this.estadoPrestamo = EstadoPrestamo.DEVUELTO_A_TIEMPO;
        }
    }
    
      public int getIdPrestamo() {
        return idPrestamo;
    }

     public EstadoPrestamo getEstadoPrestamo() {
        return estadoPrestamo;
    }
  
     public Libro getLibro(){
    return libro;
}
     
         public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
