package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import modelo.DatosVehiculo;
import modelo.Vehiculo;

public class VehiculoController {
    private Queue <DatosVehiculo> ColaEspera = new LinkedList <DatosVehiculo>();
    private Queue <DatosVehiculo> ColaAtendidos = new LinkedList <DatosVehiculo>();

    public VehiculoController(){
        File f;
        FileReader fr;
        BufferedReader br;

        f = new File("fichero.txt");

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String lineaFichero = "";
            while ((lineaFichero = br.readLine()) != null){
                String[] partes = lineaFichero.split(",");
                nuevoVehiculo(new Vehiculo(partes[0], partes[1], partes[2], partes[3]));
                Thread.sleep(1000);              
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
        System.out.println(vehiculo.getMatricula() + " añadido a la cola de espera");
    }

    public void atenderVehiculo(){

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
