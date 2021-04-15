
package DOCENTE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DOCENTE implements Serializable{
    
    static final long serialVersionUID=40L;
    
    transient Scanner leer = new Scanner (System.in);

    private String NOM;
    private String PAT;
    private String MAT;
    private String TITULO;
    private int CARGA;
    private int MAX;

    private List<MATERIA> listaMateria;
    
    public DOCENTE(){
        listaMateria = new ArrayList<>();
    }

    public void MOSTRARper(){
        System.out.println("----------------------------------");
        System.out.println("NOMBRE        : "+this.NOM);
        System.out.println("AP. PATERNO   : "+this.PAT);
        System.out.println("AP. MATERNO   : "+this.MAT);
        System.out.println("TITULO        : "+this.TITULO);
        System.out.println("C. HORARIA    : "+this.CARGA);
        if (listaMateria.size() > 0){
            System.out.println("        MATERIAS ASIGNADAS ");
            for (MATERIA ma: listaMateria){
                System.out.println("__________________________________");
                ma.mostrar();
                System.out.println("__________________________________");
            }
        }
    }
    public void agregar(MATERIA mat){
        listaMateria.add(mat);
        System.out.println("");
        System.out.println("        MATERIA ASIGNADA...,");
        System.out.println("");
    }

    public String getNombre() {
        return NOM;
    }

    public void setNombre(String nombre) {
        this.NOM = nombre;
    }

    public String getPaterno() {
        return PAT;
    }

    public void setPaterno(String paterno) {
        this.PAT = paterno;
    }
    public String getMaterno() {
        return MAT;
    }

    public void setMaterno(String materno) {
        this.MAT = materno;
    }

    public String getTitulo() {
        return TITULO;
    }

    public void setTitulo(String titulo) {
        this.TITULO = titulo;
    }

    public int getCargaH() {
        return CARGA;
    }

    public void setCargaH(int cargaH) {
        this.CARGA = cargaH;
    }

    public List<MATERIA> getListaMateria() {
        return listaMateria;
    }

    public void setListaMateria(List<MATERIA> listaMateria) {
        this.listaMateria = listaMateria;
    }

    public int getHmax() {
        return MAX;
    }

    public void setHmax(int hmax) {
        this.MAX = hmax;
    }
}
