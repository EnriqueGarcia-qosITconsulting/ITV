package vista;

import controlador.VehiculoController;
import excepciones.DNIExcepction;
import excepciones.MatriculaException;
import modelo.DatosVehiculo;
import modelo.Vehiculo;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
        Vehiculo vehiculo = new Vehiculo("Luis", "García Perez", "21150568K", "1224ABC");
        }catch (DNIExcepction | MatriculaException e){
            System.out.println(e.getMessage());
        }
        VehiculoController vc = new VehiculoController();
        int numVehiculos = vc.getColaEspera().size();
        for (int i = 0; i < numVehiculos; i++) {
                vc.atenderVehiculo();
            }
        System.out.println();
        System.out.printf("Tiempo de espera medio: %ds",DatosVehiculo.getTiempoTotal()/numVehiculos);
    }
}
