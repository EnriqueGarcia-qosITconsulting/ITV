package controlador;

import java.util.LinkedList;
import java.util.Queue;

import modelo.DatosVehiculo;
import modelo.Vehiculo;

public class VehiculoController {
    private Queue <DatosVehiculo> ColaEspera = new LinkedList <DatosVehiculo>();
    private Queue <DatosVehiculo> ColaAtendidos = new LinkedList <DatosVehiculo>();

    public VehiculoController(){

    }

    public Queue<DatosVehiculo> getColaEspera() {
        return ColaEspera;
    }

    public Queue<DatosVehiculo> getColaAtendidos() {
        return ColaAtendidos;
    }

    public void nuevoVehiculo(Vehiculo vehiculo){
        DatosVehiculo datosVehiculo = new DatosVehiculo(vehiculo);
        ColaEspera.add(datosVehiculo);
    }

    public void atenderVehiculo(Vehiculo vehiculo){

        if(ColaEspera.isEmpty()){
            System.out.println("No quedan vehículos en espera");
            return;
        }

        DatosVehiculo v = ColaEspera.poll();
        v.atiende();
        ColaAtendidos.add(v);
        System.out.println(v.getVehiculo().getMatricula() + " ha sido atendido");

    }

}
