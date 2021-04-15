
package DOCENTE;

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

    private DOCENTE doc;
    private List<MATERIA> listaMat;
    

    public OPERACIONES(){
        listaMat = new ArrayList<>();
    }
    
    Scanner leer = new Scanner (System.in);

      public void crearDOC(){
        doc = new DOCENTE();
         System.out.println("INTRODUACA LOS SIGUIENTES DATOS DEL DOCENTE:");
        System.out.print("NOMBRE: ");
        doc.setNombre(leer.nextLine());
        System.out.print("AP.PATERNO: ");
        doc.setPaterno(leer.nextLine());
        System.out.print("AP. MATERNO: ");
        doc.setMaterno(leer.nextLine());
        System.out.print("TITULO: ");
        doc.setTitulo(leer.nextLine());
        System.out.print("CARGA HORARIA: ");
        doc.setCargaH(leer.nextInt());
        doc.setHmax(0);
          System.out.println("");
          System.out.println("DOCENTE REGISTRADO!");
    }
      public void mostraDocente(){
          if(doc != null){
              doc.MOSTRARper();
          }
      }
      public void crearMateria(){
          MATERIA mat = new MATERIA();
          mat.crearMat();
          listaMat.add(mat);
      }
      
      public void ASIGNARmateria(){
          boolean sw=true;
          System.out.print("INTRODUZCA NOMBRE DE LA MATERIA: ");
          String nomM = leer.nextLine();
          for (MATERIA ma:listaMat){
              if(ma.getNombreM().equalsIgnoreCase(nomM)){
                  sw=false;
                  if(doc.getCargaH() == doc.getHmax()){
                      System.out.println("");
                      System.out.println("      CARGA HORARIA ASIGNADA...");
                      System.out.println("");
                  }else{
                  if(doc.getCargaH()>doc.getHmax()){
                      doc.agregar(ma);
                      int TE = ma.getHoraM() + doc.getHmax();
                      doc.setHmax(TE);
                  }else{
                      int COL = doc.getCargaH() - doc.getHmax();
                      System.out.println("");
                      System.out.println("CARGA HORARIA LIBRE: "+COL);
                      System.out.println("");
                  }
                  }
              } 
          }
          if(sw){
              System.out.println("      LA MATERIA NO EXISTE....");
          }
      }

    public void crearArchivo(){
        // D
        Path path=Paths.get("E:\\PROGRAMACION3\\DOCENTE.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("ARCHIVO CREADO...");
            }else{
                System.out.println("EL ARCHIVO YA EXISTE...");
            }
        } catch (Exception e) {
        }
    }

    public void guardarObjetos(){
        String ruta="E:\\PROGRAMACION3\\DOCENTE.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaMat);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    public void leerMaterias(){
        String ruta="E:\\PROGRAMACION3\\DOCENTE.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaMat=(List<MATERIA>)ois.readObject();
            }else{
                System.out.println("ES NULO...");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
