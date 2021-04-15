
package DISCO_DURO;

import java.io.Serializable;
import java.util.Scanner;

public class ALMACENAR implements Serializable{
    static final long serialVersionUID=2L;

    transient Scanner leer = new Scanner (System.in);

    private String marca;
    private double capacidad;
    private double espacioDis;

    public void llenar(){
        System.out.println("INGRESE LOS SIGUIENTES DATOS:");
        System.out.print("MARCA DEL DISPOSITIVO: ");
        this.marca = leer.nextLine();
        System.out.print("CAPACIDAD (Mg): ");
        this.capacidad = leer.nextDouble();
        System.out.print("ESPACIO DISPONIBLE (Mg): ");
        this.espacioDis = leer.nextDouble();
        leer.nextLine();
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getEspacioDis() {
        return espacioDis;
    }

    public void setEspacioDis(double espacioDis) {
        this.espacioDis = espacioDis;
    }
        public void mostrar(){
        System.out.println("MARCA         : " + this.marca);
        System.out.println("CAPACIDAD     : " + this.capacidad);
        System.out.println("ESPACIO LIBRE : " + this.espacioDis);
    }
    
}
