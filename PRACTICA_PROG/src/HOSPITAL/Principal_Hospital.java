
package HOSPITAL;

import java.util.Scanner;

public class Principal_Hospital {
    public static void main(String[] args) {
        Scanner leer =new Scanner (System.in);
        boolean continuar = true;
        int x;
        OPERACIONES opc = new OPERACIONES();
        do{
            System.out.println("=========================================");
            System.out.println("            MENU DE OPCIONES");
            System.out.println("=========================================");
            System.out.println("    1. REGISTRAR HOSPITAL ");
            System.out.println("    2. ASIGNAR ESPECIALIDAD ");
            System.out.println("    3. MOSTRAR EPECIALIDAD ");
            System.out.println("    4. LISTAR HOSPITALES POR ESPECIALIDAD");
            System.out.println("    . SALIR ");
            System.out.println("------------------------------------------");
            System.out.println("");
            System.out.print("DIGITE UNA OPCION : ");
            x = leer.nextInt();
            System.out.println("");
            switch(x){

                case 1:
                    opc.registrarHospital();
                    opc.guardarObjetos();
                    break;
                case 2:
                    opc.AgregarEspecialidad();
                    opc.guardarObjetos();
                    break;
                case 3:
                    opc.leerEspecialidad();
                    opc.mostrarHospital();
                    break;
                case 4:
                    opc.leerEspecialidad();
                    opc.mostrarPorEspecialidad();
                    break;
                case 5:

                    continuar = false;
                    break;
                default:
                    System.out.println("DIGITE UAN OPCIOPN NUEVAMENTE...");
                    break;
            }
        }while (continuar);
    }
}
