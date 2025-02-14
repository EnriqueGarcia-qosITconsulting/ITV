package modelo;

public class DatosVehiculo {
    private Vehiculo vehiculo;
    private long entrada;
    private long salida;
    private long tiempoEspera;

    public DatosVehiculo(Vehiculo vehiculo) {
        
        this.vehiculo = vehiculo;
        this.entrada = Reloj.ahora();
    }

    public void atiende(){

        this.salida = Reloj.ahora();
        this.tiempoEspera = this.salida - this.entrada;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public long getTiempoEspera() {
        return tiempoEspera/1000;
    }
    

    @Override
    public String toString() {
        return "DatosVehiculo [vehiculo=" + vehiculo + ", entrada=" + entrada + ", salida=" + salida + ", tiempoEspera="
                + tiempoEspera + "]";
    }

    
    
}
