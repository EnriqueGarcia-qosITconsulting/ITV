package modelo;

public class DatosVehiculo {
    private Vehiculo vehiculo;
    private long entrada;
    private long salida;
    private long tiempoEspera;

    public DatosVehiculo() {

    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public long getTiempoEspera() {
        return tiempoEspera;
    }
    
    public void atiende(){

    }

    @Override
    public String toString() {
        return "DatosVehiculo [vehiculo=" + vehiculo + ", entrada=" + entrada + ", salida=" + salida + ", tiempoEspera="
                + tiempoEspera + "]";
    }

    
    
}
