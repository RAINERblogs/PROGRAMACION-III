/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARCHIVO_OBJ;

import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class MainClass {
    public static void main(String[] args) {
        int opc = 0;
        boolean continuar = true;
        OperacionClienteTarjeta obj = new OperacionClienteTarjeta();
        Scanner sd = new Scanner(System.in);
        do {
            System.out.println("-----------------------------------------------");
            System.out.println("              MENU DE OPCIONES \n ---------------------------------------------");
            System.out.println("1. Crear archivo");
            System.out.println("2. Registrar cliente - Tarjeta");
            System.out.println("3. Guardar los registros");
            System.out.println("4. Mostrar Datos"); 
            System.out.println("5. Bloquear Tarjeta");
            System.out.println("6. Depositar Dinero");
            System.out.println("7. Retirar Dinero ");
            System.out.println("8. Salir \n ");
            System.out.print("Digite una opcion : ");
            opc = sd.nextInt();
            switch (opc) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    String res="S";
                    while(res.equalsIgnoreCase("S")){
                        sd.nextLine();
                        obj.crearClienteTarjeta();
                        System.out.print("¿Desea seguir registrando clientes?   S/N   : ");
                        res=sd.nextLine();
                    }                    
                    break;
                case 3:
                    obj.guardarObjetos();
                    break;
                case 4:
                    obj.leerClientes();
                    obj.mostrarCliente();
                    break;
                case 5:
                    obj.leerClientes();
                    System.out.print("Digite el numero de cedula    : ");
                    int c=sd.nextInt();
                    obj.cambiarEstado(c);
                    obj.guardarObjetos();
                    break;
                case 6:
                    obj.leerClientes();
                    System.out.print("Digite el numero de cedula  : ");
                    int ced=sd.nextInt();
                    System.out.print("Digite el monto que desea depositar   : ");
                    double m=sd.nextDouble();
                    obj.depositar(ced, m);
                    obj.guardarObjetos();
                    break;
                case 7:
                    obj.leerClientes();
                    System.out.print("Digite su Numero de Cedula : ");
                    int ce = sd.nextInt();
                    System.out.print("Digite el monto que desea retirar : ");
                    double r = sd.nextDouble();
                    obj.retirar(ce, r);
                    obj.guardarObjetos();
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
    
}
