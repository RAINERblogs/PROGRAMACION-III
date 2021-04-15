
package ALBUM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ALBUM implements Serializable{
    static final long serialVersionUID=2L;

    private String nombre;
    private String artista;
    private String formato;
    

    private List<CANCION> listac;

    public ALBUM(){
        listac = new ArrayList<>();
    }

    public void mostrarALBUM(){
      
        System.out.println("            ALBUM");
        System.out.println("----------------------------------");
        System.out.println("Nombre   : "+this.nombre);
        System.out.println("Artista    : "+this.artista);
        System.out.println("Formato  : "+this.formato);
        System.out.println("            CANCIONES");
        System.out.println("-------------------------------------");
        System.out.println("Nombre   \t\t Duracion(min)   \t\t   Genero ");
        if(listac != null){
            for (CANCION cc:listac){
                cc.mostrarCancion();
            }
            System.out.println("");
        }
    }
    public void agregarCancion(CANCION can){
        this.listac.add(can);
        System.out.println("        CANCION REGISTRADA!!");
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public List<CANCION> getListac() {
        return listac;
    }

    public void setListac(List<CANCION> listac) {
        this.listac = listac;
    }
}
