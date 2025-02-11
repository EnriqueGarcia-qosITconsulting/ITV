package modelo;

import excepciones.DNIExcepction;
import excepciones.MatriculaException;

public class Vehiculo {
    private String nombre;
    private String apellidos;
    private String dni;
    private String matricula;
    private String identificador;

    public Vehiculo(String nombre, String apellidos, String dni, String matricula) throws DNIExcepction, MatriculaException {
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setDni(dni);
        this.setMatricula(matricula);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) throws DNIExcepction {
        try{
            String[] letrasDNI = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
            if (dni.length() != 9) throw new DNIExcepction();
            if (!Character.isLetter(dni.charAt(8))) throw new DNIExcepction();
            String letraDNI = dni.substring(8, 9);
            int numerosDNI = Integer.parseInt(dni.substring(0, 8));
            int resto = numerosDNI % 23;
            if(letrasDNI[resto] != letraDNI) throw new DNIExcepction();
            this.dni = dni;
        }catch (Exception e){
            throw new DNIExcepction();
        }

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws MatriculaException {
        try{
            if(matricula.length() != 7) throw new MatriculaException();
            int numeroMatricula = Integer.parseInt(matricula.substring(0, 4));
            if(!Character.isLetter(matricula.charAt(4))) throw new MatriculaException();
            if(!Character.isLetter(matricula.charAt(5))) throw new MatriculaException();
            if(!Character.isLetter(matricula.charAt(6))) throw new MatriculaException();
            this.matricula = matricula;
        }
        catch(Exception e) {
            throw new MatriculaException();
        }
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String nombre, String apellidos, String dni) {
        String letras [] = apellidos.split(" ");

        this.identificador += nombre.substring(0,1);
        this.identificador += letras[0].substring(0,1);
        this.identificador += letras[1].substring(0,1);
        this.identificador += dni.substring(5,9);

    }

    @Override
    public String toString() {
        return "Vehiculo [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", matricula=" + matricula
                + ", identificador=" + identificador + "]";
    }
    
    
}
