
package LAB1;

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

/**
 *
 * @author PC-AL_100
 */
public class OperacionB {
     // Creando una Lista
    Scanner sd = new Scanner (System.in);
    private Libro li;
    private ProyectoGrado p;
    List<MaterialBibliografico>listama;
    // Constructor
    public OperacionB(){
        listama = new ArrayList<>();
    }
    public void AgregarMaterial(MaterialBibliografico mat){
        if (mat instanceof Libro){
            // Realizando el casteo
            li = new Libro();
            System.out.print("Introduzca titulo del Libro : ");
            li.setTitulo(sd.nextLine());
            System.out.print("Introduzca el autor de Libro : ");
            li.setAutor(sd.nextLine());
            System.out.print("Digite la Edicion del Libro : ");
            li.setEdicion(sd.nextInt());
            sd.nextLine();
            System.out.print("Introduzca la area del Libro : ");
            li.setArea(sd.nextLine());
            listama.add(li);
            System.out.println("\n Libro Registrado...!!!! \n");
        }
        if (mat instanceof ProyectoGrado){
            // Realizando el casteo
            p = new ProyectoGrado();
            System.out.print("Introduzca Titulo del Proyecto : ");
            p.setTitulo(sd.nextLine());
            System.out.print("Introduzca Autor del Proyecto : ");
            p.setAutor(sd.nextLine());
            System.out.print("Introduzca Tutor del Proyecto : ");
            p.setTutor(sd.nextLine());
            System.out.print("Introduzca Revisor del Proyecto : ");
            p.setRevisor(sd.nextLine());
            listama.add(p);
        }
    }
    // METODO DE MOSTRAR DATOS
    public void MostrarMaterial(){
          if ( listama!= null ){
              for (MaterialBibliografico mat:listama){
                if (mat instanceof Libro){
                    Libro li = (Libro) mat;
                    System.out.println("\n------------ LIBRO --------- \n");
                    li.mostrar();
                }else{
                    ProyectoGrado pg = (ProyectoGrado) mat;
                     System.out.println("\n------ PROYECTOS DE GRADO ------ \n");  
                    pg.mostrar();
                }
            }                  
            }else{
              System.out.println("NO HAY MATERIAL !!! ");
          }
    }
    // METODO DE  BUSCAR LIBRO
    public void buscarLibro(String bl){
        int sw=0;
            for(MaterialBibliografico ma:listama){
                if(ma instanceof Libro){
                    Libro li = (Libro) ma;
                    if(li.getTitulo().equalsIgnoreCase(bl)){
                        sw=1;
                        li.mostrar();
                    }
                }
            }
            if(sw==0){
                System.out.println("\n LIBRO NO ENCONTRADO !! \n");
            }
    }
    // METODO DE BUSCAR PROYECTO
    public void buscarProyecto(String bp){
        int sw=0;
            for(MaterialBibliografico ma:listama){
                if(ma instanceof ProyectoGrado){
                    ProyectoGrado pg = (ProyectoGrado) ma;
                    if(pg.getTitulo().equalsIgnoreCase(bp)){
                        sw=1;
                        pg.mostrar();
                    }
                }
            }
            if(sw==0){
                System.out.println("\n PROYECTO NO ENCONTRADO !! \n");
            }
    }
    // METODO DE ELIMINACION DE ALGUN MATERIAL 
    public void eliminarLibro(String el){
        int sw=0;
            Iterator<MaterialBibliografico> ite=listama.iterator();
             while(ite.hasNext()){
                MaterialBibliografico mat = ite.next();
                if(mat instanceof Libro){
                    Libro pg = (Libro) mat;
                    if(pg.getTitulo().equalsIgnoreCase(el)){
                        sw=1;
                        ite.remove();
                        System.out.println("    -----------------------------------------------------------------");
                        System.out.println("    --------- LIBRO ELIMINADO  --------- ");
                        System.out.println("    ............................................ \n");
                    }
                }
            }
            if(sw==0){
                System.out.println("\n LIBRO NO ENCONTRADO !! \n");
            }
    }
    // METODO DE ELIMINACION
    public void eliminarProy(String pr){
            int sw=0;
            Iterator<MaterialBibliografico> ite=listama.iterator();
             while(ite.hasNext()){
                MaterialBibliografico mat = ite.next();
                if(mat instanceof ProyectoGrado){
                    ProyectoGrado pg = (ProyectoGrado) mat;
                    if(pg.getTitulo().equalsIgnoreCase(pr)){
                        sw=1;
                        ite.remove();
                        System.out.println("    -----------------------------------------------------------------");
                        System.out.println("    --------- PROYECTO DE GRADO ELIMINADO  --------- ");
                        System.out.println("    ............................................ \n");
                    }
                }
            }
            if(sw==0){
                System.out.println("\n PROYECTO NO ENCONTRADO !! \n");
            }
    }
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("E:\\PROGRAMACION\\TercerAño\\archivoMaterial.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente..!!! ");
            }else{
                System.out.println("El archivo ya existe...!!! ");
            }
        } catch (Exception e) {
        }
    }
    //guardando la listama dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta="E:\\PROGRAMACION\\TercerAño\\archivoMaterial.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listama);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionB.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionB.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    //cargamos los datos del archivo a un list<MaterialBibliografico>
    public void leerMaterial(){
        String ruta="E:\\PROGRAMACION\\TercerAño\\archivoMaterial.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listama=(List<MaterialBibliografico>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionB.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionB.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
