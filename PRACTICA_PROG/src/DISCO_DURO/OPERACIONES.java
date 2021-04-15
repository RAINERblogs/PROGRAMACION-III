
package DISCO_DURO;

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
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OPERACIONES {
    Scanner sd = new Scanner (System.in);
    
    private List <DISCO> listaDis;
    private DISCO dd;
    private ARCHIVO ar;

    public OPERACIONES(){
        listaDis = new ArrayList<>();
    }

    public void registrarDiscoDuro(){
        dd=new DISCO();
        dd.llenar();
        listaDis.add(dd);
    }
 
    public void AGREGAR(){
        boolean sw=true;
        
        System.out.println("INTRODUZCA LOS SIGUIENTES DATOS DEL DISCO DURO:");
        System.out.print("MARCA : ");
          String nom = sd.nextLine();         
          for (DISCO m:listaDis){
              if(m.getMarca().equalsIgnoreCase(nom)){
                  sw=false;
                  System.out.print("NUMERO DE ARCHIVOS A AGREGAR : ");
                  int lim = sd.nextInt();
                  ar =new ARCHIVO();
                  for (int i = 1; i <= lim; i++) {
                      sd.nextLine();
                      System.out.print("NOMBRE DEL ARCHIVO: ");
                      ar.setNombrear(sd.nextLine());
                      System.out.print("TAMAÑO DEL ARCHIVO: ");
                      double tam = sd.nextDouble();
                      if(m.getEspacioDis() > tam){
                        ar.setTamar(tam);
                        double esp = m.getEspacioDis() - tam;
                        m.setEspacioDis(esp);
                        m.agregarEs(ar);
                          System.out.println("ARCHIVO AGREGADO!");
                          System.out.println("");
                      }else{
                          System.out.println("NO HAY ESPACIO EN EN EL DISCO... ");
                          System.out.println("");
                      }
                      
                  }
         
              } 
          }
          if (sw){
              System.out.println("DISCO DURO NO EXISTENTE ...!!!!!");
          }
    }
    public void MOSTRAR(){
        int sw=0;
        System.out.print("INTRODUZCA LA MARCA DEL DISCO DURO: ");
         String disco = sd.nextLine();    
        for(DISCO dis: listaDis){
            if (dis.getMarca().equalsIgnoreCase(disco)){
                sw = 1;
                dis.mostrar();
            }
        }
        if (sw == 0){
            System.out.println("EL DISCO DURO NO EXISTE");
        }
    }
    
    public void ELIMINAR(){
        int sw=0;
        System.out.print("INTRODUZCA MARCA DEL DISCO DURO: ");
        String disco = sd.nextLine();
        for(DISCO dis: listaDis){
            if (dis.getMarca().equalsIgnoreCase(disco)){
                sw = 1;
                System.out.println("¿QUE ARCHIVO DESEA ELIMINAR?: ");
                String name = sd.nextLine();
                dis.eliminarar(name);
            }
        }
    
        if (sw == 0){
            System.out.println("EL DISCO DURO NO EXISTE...");
        }
    }
  
    public void crearARCHIVO(){
        Path path=Paths.get("E:\\PROGRAMACION3\\PRACTICA.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (Exception e) {
        }
    }
    
        public void leerOBJETOS(){
        String ruta="E:\\PROGRAMACION3\\PRACTICA.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaDis=(List<DISCO>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void guardarOBJETOS(){
        String ruta="E:\\PROGRAMACION3\\PRACTICA.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaDis);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

}
