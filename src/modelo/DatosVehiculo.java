package modelo;

public class DatosVehiculo {
    private Vehiculo vehiculo;
    private long entrada;
    private long salida;
    private long tiempoEspera;
    private static long tiempoTotal;

    public DatosVehiculo(Vehiculo vehiculo) {
        
        this.vehiculo = vehiculo;
        this.entrada = Reloj.ahora();
    }

    public void atiende(){

        this.salida = Reloj.ahora();
        this.tiempoEspera = getTiempoEspera();
        tiempoTotal += this.tiempoEspera;
        System.out.println("Tiempo de espera: " + this.tiempoEspera + "s");
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public long getEntrada(){
        return entrada;
    }

    public long getSalida(){
        return salida;
    }

    public long getTiempoEspera() {
        return (salida - entrada) / 1000;
    }

    public static long getTiempoTotal() {
        return tiempoTotal;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "DatosVehiculo [vehiculo=" + vehiculo + ", entrada=" + entrada + ", salida=" + salida + ", tiempoEspera="
                + tiempoEspera + "]";
    }

    
    
}
