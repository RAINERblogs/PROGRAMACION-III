/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1;

import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class Menu_Principal {
    public static void main(String[] args) {
        Scanner sd =new Scanner (System.in);
        boolean con = true;
        int opc;
        MaterialBibliografico matLibro = new Libro();
        MaterialBibliografico matProyecto = new ProyectoGrado();
        OperacionB op = new OperacionB();
        do{
            System.out.println("\n    ------------------- MENU DE OPCIONES ----------------- \n");
            System.out.println("    1. Crear archivo");
            System.out.println("    2. Agregar Material Bibliografico ");
            System.out.println("    3. Guardar los registros");
            System.out.println("    4. Mostrar Material Biblografico ");
            System.out.println("    5. Buscar Material Biblografico");
            System.out.println("    6. Eliminar Material Bibliografico ");
            System.out.println("    7. Salir \n");
            System.out.print("    Elija una opcion : ");
            opc = sd.nextInt();
            System.out.println("");
            switch(opc){
                case 1:
                    op.crearArchivo();
                    break;
                case 2:
                    op.leerMaterial();
                    System.out.print("\n Introduzca tipo de Material '1. Libro' o '2. Proyecto de Grado' : ");
                    int opcion=sd.nextInt();
                    System.out.println("-----------------------------------------------------------");
                    if(opcion==1){
                        op.AgregarMaterial(matLibro);
                    }else{
                        op.AgregarMaterial(matProyecto);
                    }
                    break;
                case 3:
                    System.out.println(" \nDatos guardados con exito...!!!");
                    op.guardarObjetos();
                    break;
                case 4:
                    op.leerMaterial();
                    op.MostrarMaterial();
                    break;
                case 5:
                    op.leerMaterial();
                    System.out.print("\n Introduzca tipo de Material que busca '1. Libro' o '2. Proyecto de Grado' : ");
                    int opcn=sd.nextInt();
                    System.out.println("-----------------------------------------------------------");
                    if(opcn==1){
                        sd.nextLine();
                        System.out.print("Introduzca titulo del Libro : ");
                        String ti=sd.nextLine();
                        op.buscarLibro(ti);
                    }else{
                        sd.nextLine();
                        System.out.print("Introduzca titulo del Proyecto : ");
                        String pro=sd.nextLine();
                        op.buscarProyecto(pro);
                    }
                    op.guardarObjetos();
                    break;
                case 6:
                    op.leerMaterial();
                    System.out.print("\n Introduzca tipo de Material que desea Eliminar '1. Libro' o '2. Proyecto de Grado' : ");
                    int o =sd.nextInt();
                    System.out.println("-----------------------------------------------------------");
                    if(o == 1){
                        sd.nextLine();
                        System.out.print("Introduzca titulo del Libro : ");
                        String eli=sd.nextLine();
                        op.eliminarLibro(eli);
                    }else{
                        sd.nextLine();
                        System.out.print("Introduzca titulo del Libro : ");
                        String pro=sd.nextLine();
                        op.eliminarProy(pro);
                    }
                    op.guardarObjetos();
                    break;
                case 7:
                    System.out.println("    Saliendo del Programa...!!!!!");
                    con = false;
                    break;
                default:
                    System.out.println("    Opcion Incorrecta....!!!!!");
                    System.out.println("    Intente de nuevo.....!!!!!!");
                    break;
            }
        }while (con);
    }
    
}
