
package DOCENTE;

import java.util.Scanner;


public class PRINCIPAL {
    public static void main(String[] args) {
        Scanner leer =new Scanner (System.in);
        boolean continuar = true;
        int x;
        OPERACIONES oper = new OPERACIONES();
        do{
            System.out.println("==================================");
            System.out.println("         MENU DE OPCIONES");
            System.out.println("==================================");
            System.out.println("      1. CREAR DOCENTE ");
            System.out.println("      2. CREAR MATERIAS ");
            System.out.println("      3. ASIGNAR MATERIA ");
            System.out.println("      4. MOSTRAR DOCENTE ");
            System.out.println("      5. SALIR ");
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.print("    Elija una opcion : ");
            x = leer.nextInt();
            System.out.println("");
            switch(x){

                case 1:
                    oper.crearDOC();
                    oper.guardarObjetos();
                    break;
                case 2:
                    oper.crearMateria();
                    oper.guardarObjetos();
                    break;
                case 3:
                    oper.leerMaterias();
                    oper.ASIGNARmateria();
                    oper.guardarObjetos();
                    break;
                case 4:
                    oper.leerMaterias();
                    oper.mostraDocente();
                    break;
                case 5:

                    continuar = false;
                    break;
                default:
                    System.out.println("Digite una opcion nuevamente...");
                    break;
            }
        }while (continuar);
    }
}
