/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MANEJO_ARCH;

import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class mainClass {
    public static void main(String[] args) {
        Scanner sd =new Scanner (System.in);
        OperacionesArchivo op = new OperacionesArchivo();
        boolean con=true;
        int opcion;
        do{
            System.out.println("    ----- MENU DE OPCIONES ----- \n");
            System.out.println("1. Crear Directorio ");
            System.out.println("2. Crear Archivo ");
            System.out.println("3. Agregar Contenido ");
            System.out.println("4. Mostrar Contenido ");
            System.out.println("5. Salir \n");
            System.out.print("Elija una opcion : ");
            opcion = sd.nextInt();
            switch(opcion){
                case 1 :
                    op.crearD();
                    break;
                case 2:
                    op.crearArchivo();
                    break;
                case 3:
                    op.agregarContenido();
                    break;
                case 4:
                    op.mostrarContenido();
                    break;
                case 5:
                    System.out.println("\n Cerrando Programa ...!!!! \n");
                    con = false;
                    break;
                default:
                    System.out.println("\n \b Opcion Incorrecta, Intente de nuevo ,,,!!!! \n ");
                    break;
            }
        }while(con);
    }
    
}
