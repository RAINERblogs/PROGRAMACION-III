/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DISCO_DURO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class DISCO extends ALMACENAR{
    static final long serialVersionUID=3L;
    // OBJETO DE LECTURA
    transient Scanner sd = new Scanner (System.in);
     // AGREGANDO ESPECIALIDAD
    private List <ARCHIVO> listaar;
    
    //CONSTRUCTOR
    public DISCO(){
        listaar = new ArrayList<>();
    }
    // ATRIBUTOS
    private String tipoin;
    
    // METODOS
    @Override
    public void llenar(){
        super.llenar();
        System.out.print("Ingrese tipo de interfaz : ");
        this.tipoin = sd.nextLine();
    }
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Tipo de Interfaz : " + this.tipoin);
        if (listaar.size() > 0){
            System.out.println(" ------ ARCHIVOS DEL DISCO DURO ------ ");
            for (ARCHIVO ee: listaar){
                System.out.print(" - ");
                ee.mostrar();
            }
        }
    }
    public void agregarEs(ARCHIVO ar){
        listaar.add(ar);
        System.out.println("");
        System.out.println("¡¡¡¡.....Archivo Agregada.....!!!!");
        System.out.println("");
    }
    public void eliminarar(String nom){
            Iterator<ARCHIVO> ite=this.listaar.iterator();
             while(ite.hasNext()){
                  ARCHIVO ar = ite.next();
                  if(ar.getNombrear().equalsIgnoreCase(nom)){
                      ite.remove();
                   System.out.println("\n    --------- ARCHIVO ELIMINADO  --------- \n");
                  }   
                    }
    }
    // GETTER AND SETTER 

    public String getTipoin() {
        return tipoin;
    }

    public void setTipoin(String tipoin) {
        this.tipoin = tipoin;
    }

    public List<ARCHIVO> getListaar() {
        return listaar;
    }

    public void setListaar(List<ARCHIVO> listaar) {
        this.listaar = listaar;
    }
    
}
