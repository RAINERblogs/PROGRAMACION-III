
package DOCENTE;

import java.io.Serializable;
import java.util.Scanner;

public class MATERIA implements Serializable{
    static final long serialVersionUID=41L;

    private String NOMBREma;
    private int AÑOma;
    private int HORA;
    
    transient Scanner leer = new Scanner (System.in);

    public void crearMat(){
        System.out.println("INTRODUZCA LOS SIGUIENTES DATOS:");
        System.out.print("NOMRE DE LA MATERIA: ");
         this.NOMBREma = leer.nextLine();
         System.out.print("AÑO: ");
         this.AÑOma = leer.nextInt();
         System.out.print("HORAS DE LA MATERIA: ");
         this.HORA = leer.nextInt();
         leer.nextLine();
    }
    public void mostrar(){
        System.out.println("MATERIA             : "+this.NOMBREma);
        System.out.println("AÑOS DE LA MATERIA  : "+this.AÑOma);
        System.out.println("HHORA DE LA MATERIA : "+this.HORA);
    }

    public String getNombreM() {
        return NOMBREma;
    }

    public void setNombreM(String nombreM) {
        this.NOMBREma = nombreM;
    }

    public int getAñoM() {
        return HORA;
    }

    public void setAñoM(int añoM) {
        this.HORA = añoM;
    }

    public int getHoraM() {
        return HORA;
    }

    public void setHoraM(int horaM) {
        this.HORA = horaM;
    }
}
