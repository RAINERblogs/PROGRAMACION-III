
package ALBUM;


import DISCO_DURO.DISCO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OPERACIONES {

    Scanner leer = new Scanner(System.in);
    private ALBUM alb;
    private CANCION can;

    private List<ALBUM> lisTAlbum;

    public OPERACIONES(){
        lisTAlbum=new ArrayList<>();
    }
    

    public void RegistrarAlbum(){
        alb = new ALBUM();
        System.out.println("INTRODUZCA LOS SIGUIENTES DATOS: ");
        System.out.print("NOMBRE DEL ALBUM: ");
        alb.setNombre(leer.nextLine());
        System.out.print("NOMBRE DEL ARTISTA: ");
        alb.setArtista(leer.nextLine());
        System.out.print("FORMATO DE LA CANCION: ");
        alb.setFormato(leer.nextLine());
        lisTAlbum.add(alb);
        System.out.println("¿CUANTAS CANCIONES TENDRA EL ALBUM?: ");
        int n = leer.nextInt();
        leer.nextLine();
        for (int i = 1; i <= n; i++) {
            can = new CANCION();
            System.out.print("NOMBRE DE LA CANCION "+i+" : ");
            can.setNombrec(leer.nextLine());
            System.out.print("DIGITE LA DURACION: ");
            can.setDuracion(leer.nextFloat());
            leer.nextLine();
            System.out.print("GENEROS DE LA CANCION: ");
            can.setGenero(leer.nextLine());
            alb.agregarCancion(can);
        }
        
    }
    public void mostrarAlbum(){
        if(lisTAlbum != null){
            for(ALBUM al:lisTAlbum){
                al.mostrarALBUM();
            }
        }else{
            System.out.println("------------------------------");
            System.out.println("       LISTA DE ALBUNES");
            System.out.println("_______________________________");
        }
    }
    public void buscarCancion(){
        if(lisTAlbum != null){
            int sw=0;
            System.out.println("¿QUE CANCIONES DESEA BUSCAR?: ");
            String nc = leer.nextLine();
            for(ALBUM al:lisTAlbum){
                for(CANCION ca:al.getListac()){
                    if(ca.getNombrec().equalsIgnoreCase(nc)){
                        sw=1;
                        System.out.println("Cancion encontrada!!!");
                        System.out.println("");
                        System.out.println("--------------------------------");
                        System.out.println("CANCION   : " + ca.getNombrec());
                        
                        System.out.println("ALBUM     : "+ al.getNombre());
                        System.out.println("ARTISTA   : " + al.getArtista());
                    }
                }
            }
              if(sw==0){
                 System.out.println("ALBUM NO ENCONTRADO ...");
             }
        }
    }
    public void mostrarALBUMdet(){
         if(lisTAlbum != null){
             int sw=0;
             System.out.print("Introduzca nombre del Album : ");
             String AL = leer.nextLine();
             for(ALBUM al:lisTAlbum){
                if(al.getNombre().equalsIgnoreCase(AL)){
                    sw=1;
                    al.mostrarALBUM();
                }
            }
             if(sw==0){
                 System.out.println("\n ALBUM NO ENCONTRADO ...!!!\n ");
             }
        }
    }
    public void eliminarAlbum(){
        if(lisTAlbum != null){
            int sw=0;
            System.out.print("Introduzca nombre del Album : ");
            String el = leer.nextLine();
             Iterator<ALBUM> ite=lisTAlbum.iterator();
             while(ite.hasNext()){
                ALBUM alb = ite.next();
                if(alb.getNombre().equalsIgnoreCase(el)){
                    sw=1;
                    ite.remove();

                    System.out.println("    ALBUM ELIMINADO!!!");
                }
            }
             if(sw==0){
                 System.out.println("   ALBUM NO ENCONTRADO...");
             }
        }
    }
    public void crearArchivo(){
        Path path=Paths.get("E:\\PROGRAMACION3\\ALBUM.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("ARCHIVO CREADO!!! ");
            }else{
                System.out.println("  EL ARCHIVO YA EXISTE...");
            }
        } catch (Exception e) {
        }
    }
    
            public void leerOBJETOS(){
        String ruta="E:\\PROGRAMACION3\\ALBUM.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                lisTAlbum=(List<ALBUM>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(DISCO_DURO.OPERACIONES.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(DISCO_DURO.OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(DISCO_DURO.OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void guardarObjetos(){
        String ruta="E:\\PROGRAMACION3\\ALBUM.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(lisTAlbum);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }

}
