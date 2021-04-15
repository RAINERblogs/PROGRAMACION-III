
package HOSPITAL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HOSPITAL implements Serializable{
    static final long serialVersionUID=41L;

    transient Scanner leer = new Scanner (System.in);
    
    private String NOMBRE;
    private String DIR;
    private int NIV;
    private List <ESPECIALIDAD> listaEs;
    
    public HOSPITAL(){
        listaEs = new ArrayList<>();
    }

    public void mostrarHospital(){
        System.out.println("--------------------------------------");
        System.out.println("        DATOS DE HOPITAL");
        System.out.println("-------------------------------------");
        System.out.println("Nombre  : "+this.NOMBRE);
        System.out.println("Direccion : "+this.DIR);
        System.out.println("Nivel    : "+this.NIV+"\n");
        if (listaEs.size() > 0){
            System.out.println("       ESPECIALIDADES DEL HOSPITAL ");
            System.out.println("_______________________________________");
            for (ESPECIALIDAD ee: listaEs){
                System.out.print("");
                ee.mostrarEspe();
            }
        }
    }
    public void mostrarH(){
        System.out.println("NOMBRE  : "+this.NOMBRE);
        System.out.println("DIRECCION : "+this.DIR);
        System.out.println("NIVEL    : "+this.NIV);
    }
    public void agregarEs(ESPECIALIDAD es){
        listaEs.add(es);
        System.out.println("");
        System.out.println("        ESPECIALIDAD REGISTRADA...");
        System.out.println("");
    }
    
    public String getNombre() {
        return NOMBRE;
    }

    public void setNombre(String nombre) {
        this.NOMBRE = nombre;
    }

    public String getDireccion() {
        return DIR;
    }

    public void setDireccion(String direccion) {
        this.DIR = direccion;
    }

    public int getNivel() {
        return NIV;
    }

    public void setNivel(int nivel) {
        this.NIV = nivel;
    }

    public List<ESPECIALIDAD> getListaEs() {
        return listaEs;
    }

    public void setListaEs(List<ESPECIALIDAD> listaEs) {
        this.listaEs = listaEs;
    }
}
