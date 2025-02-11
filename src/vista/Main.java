package vista;

import excepciones.DNIExcepction;
import excepciones.MatriculaException;
import modelo.Vehiculo;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
        Vehiculo vehiculo = new Vehiculo("Luis", "García Perez", "31452329J", "1224ABC");
        }catch (DNIExcepction | MatriculaException e){
            System.out.println(e.getMessage());
        }
    }
}
