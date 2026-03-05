
package proyecto_universidad;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Socio 
{
    private static int contadorLibros = 0;
    private static int contadorIdSocio = 1;
    private String idSocio;
    private String nombreCompleto;
    private String fechaRegistro;
    private Estadosocio estadoSocio;
    private double multasAcumuladas;
    private int cantidadLibrosPrestadosActual;

    public Socio(String nombreCompleto) {
        
        this.idSocio = generarIdSocio();
        this.nombreCompleto = nombreCompleto;
        this.fechaRegistro = generarFechaRegistro();
        this.estadoSocio = Estadosocio.ACTIVO;
        this.multasAcumuladas = 0.0;
        this.cantidadLibrosPrestadosActual = contadorLibros;
    }

    
    

    
    private String generarIdSocio() {
    String id = String.format("SOC-%04d", contadorIdSocio);
    contadorIdSocio++;
    return id;
    } // Este método se usa para generar el ID único.
    
    
    private String generarFechaRegistro() {
    LocalDateTime ahora = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    return ahora.format(formato);
    }// Este método nos ayuda a hacer el registro de FechaRegistro.
    
    
    
    public static int getContadorLibros() {
        return contadorLibros;
    }

    public static void setContadorLibros(int contadorLibros) {
        Socio.contadorLibros = contadorLibros;
    }

    public static int getContadorIdSocio() {
        return contadorIdSocio;
    }

    public static void setContadorIdSocio(int contadorIdSocio) {
        Socio.contadorIdSocio = contadorIdSocio;
    }

    public String getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(String idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Estadosocio getEstadoSocio() {
        return estadoSocio;
    }

    public void setEstadoSocio(Estadosocio estadoSocio) {
        this.estadoSocio = estadoSocio;
    }

    public double getMultasAcumuladas() {
        return multasAcumuladas;
    }

    public void setMultasAcumuladas(double multasAcumuladas) {
        this.multasAcumuladas = multasAcumuladas;
    }

    public int getCantidadLibrosPrestadosActual() {
        return cantidadLibrosPrestadosActual;
    }

    public void setCantidadLibrosPrestadosActual(int cantidadLibrosPrestadosActual) {
        this.cantidadLibrosPrestadosActual = cantidadLibrosPrestadosActual;
    }
    
    
}
