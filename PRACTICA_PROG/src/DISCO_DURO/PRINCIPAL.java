
package DISCO_DURO;


import java.util.Scanner;

public class PRINCIPAL {
    public static void main(String[] args) {
        Scanner leer =new Scanner (System.in);
        boolean continuar = true;
        int x;
        OPERACIONES opc = new OPERACIONES();
        do{
            System.out.println("=================================");
            System.out.println("        MENU DE OPCIONES");
            System.out.println("=================================");
            System.out.println("    1. CREAR ARCHIVO");
            System.out.println("    2. AÑADIR DISCO DURO ");
            System.out.println("    3. AGREGAR ARCHIVOS ");
            System.out.println("    4. MOSTRAR DISCO DURO ");
            System.out.println("    5. ELIMINAR ARCHIVO ");
            System.out.println("    6. SALIR");
            System.out.println("----------------------------------");
            System.out.print("    Elija una opcion : ");
            x = leer.nextInt();
            System.out.println("");
            switch(x){
                case 1:
                    opc.crearARCHIVO();
                    opc.guardarOBJETOS();
                    break;
                case 2:
                    //opc.leerOBJETOS();
                    opc.registrarDiscoDuro();
                    opc.guardarOBJETOS();
                    break;
                case 3:
                    opc.leerOBJETOS();
                    opc.AGREGAR();
                    opc.guardarOBJETOS();
                    break;
                case 4:
                    opc.leerOBJETOS();
                    opc.MOSTRAR();
                    break;
                case 5:
                    opc.leerOBJETOS();
                    opc.ELIMINAR();
                    opc.guardarOBJETOS();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Vuele a digitar una opcion...");
                    break;
            }
        }while (continuar);
    }
}
