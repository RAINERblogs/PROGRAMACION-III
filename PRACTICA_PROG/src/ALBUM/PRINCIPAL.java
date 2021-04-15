
package ALBUM;

import java.util.Scanner;


public class PRINCIPAL {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        OPERACIONES opc = new OPERACIONES();

        boolean con = true;
        int x;
        do {
            System.out.println("===============================");
            System.out.println("        MENU DE OPCIONES");
            System.out.println("===============================");
            System.out.println("    1. CREAR ARCHIVO ");
            System.out.println("    2. AÑADIR ALBUM ");
            System.out.println("    3. MOSTRAR TODOS LOS ALBUMES ");
            System.out.println("    4. BUSCAR POR CANCION ");
            System.out.println("    5. MOSTRAR ALBUM DETERMINADO ");
            System.out.println("    6. ELIMINAR ALBUM ");
            System.out.println("    7. SALIR");
            System.out.println("--------------------------------");
            System.out.print("    Elija una opcion : ");
            x = leer.nextInt();
            System.out.println("");
            switch (x) {
                case 1:
                    opc.crearArchivo();
                    break;
                case 2:

                    opc.RegistrarAlbum();
                    opc.guardarObjetos();
                    break;
                case 3:
                    opc.leerOBJETOS();
                    opc.mostrarAlbum();
                    break;
                case 4:
                    opc.leerOBJETOS();
                    opc.buscarCancion();
                    break;
                case 5:
                    opc.leerOBJETOS();
                    opc.mostrarALBUMdet();
                    break;
                case 6:
                    opc.leerOBJETOS();
                    opc.eliminarAlbum();
                    opc.guardarObjetos();
                    break;
                case 7:
                    con = false;
                    break;
                default:
                    System.out.println("Vuelva a digitar una opcion...");

                    break;
            }
        } while (con);
    }
}
