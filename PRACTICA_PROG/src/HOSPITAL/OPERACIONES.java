
package HOSPITAL;


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
    Scanner leer = new Scanner (System.in);
    
    private List <HOSPITAL> listaHos;
    private HOSPITAL hosp;
    private ESPECIALIDAD espec;

    public OPERACIONES(){
        listaHos = new ArrayList<>();
    }

    public void registrarHospital(){
        hosp=new HOSPITAL();
        System.out.println("INTRODUZCA LOS SIGUIENTE DATOS DEL HOSPITAL.");
        System.out.print("NOMBRE: ");
        hosp.setNombre(leer.nextLine());
        System.out.print("DIRECCION: ");
        hosp.setDireccion(leer.nextLine());
        System.out.print("NIVEL: ");
        hosp.setNivel(leer.nextInt());
        listaHos.add(hosp);
    }
 
    public void AgregarEspecialidad(){
        boolean sw=true;
        System.out.println("AÑADIENDO ESPECIALIDAD:");
        System.out.print("INTRODUZCA EL NOMBRE DEL HOSPITA : ");
          String hos = leer.nextLine();         
          for (HOSPITAL m:listaHos){
              if(m.getNombre().equalsIgnoreCase(hos)){
                  sw=false;
                  System.out.println("¿CUANTAS ESPECIALIDADES TENDRA?: ");
                  int lim = leer.nextInt();
                  for (int i = 1; i <= lim; i++) {
                      espec=new ESPECIALIDAD();
                      System.out.println(" NOMBRE DE LA ESPECIALIDAD "+"["+i+"]"+" :");
                      espec.setNomEspe(leer.nextLine());
                      m.agregarEs(espec);
                  }
         
              } 
          }
          if (sw){
              System.out.println("HOSPITAL NO REGISTRADO...");
          }
    }
    public void mostrarHospital(){
        int sw=0;
        System.out.print("Introduzca nombre del Hospital : ");
         String hospi = leer.nextLine();    
        for(HOSPITAL hos: listaHos){
            if (hos.getNombre().equalsIgnoreCase(hospi)){
                sw = 1;
                hos.mostrarHospital();
            }
        }
        if (sw == 0){
            System.out.println("HOSPITAL NO REGISTRADO...");
        }
    }
    public void mostrarPorEspecialidad(){
        int sw=0;
        System.out.print("INTRODUZCA NOMBRE DE LA ESPECIALIDAD: ");
        String espe = leer.nextLine();    
        for(ESPECIALIDAD es: hosp.getListaEs()){
            if (es.getNomEspe().equalsIgnoreCase(espe)){
                sw = 1;
                es.mostrarEspe();
            }
        }
        if (sw==0){
            System.out.println("HOSPITAL NO REGISTRADO...");
        }
    }


    public void guardarObjetos(){
        String ruta="E:\\PROGRAMACION3\\HOSPITAL";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaHos);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OPERACIONES.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    public void leerEspecialidad(){
        String ruta="E:\\PROGRAMACION3\\HOSPITAL";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaHos=(List<HOSPITAL>)ois.readObject();
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
