
package ALBUM;

import java.io.Serializable;

public class CANCION implements Serializable{
    static final long serialVersionUID=1L;

    private String NOMBRE;
    private float DURACION;
    private String GENERO;
    

    public void mostrarCancion(){
        System.out.println(this.NOMBRE+
          "  " + "\t\t\t "+this.DURACION+
          "  "+ "\t\t\t  "+this.GENERO);

    }

    public String getNombrec() {
        return NOMBRE;
    }

    public void setNombrec(String nombrec) {
        this.NOMBRE = nombrec;
    }

    public float getDuracion() {
        return DURACION;
    }

    public void setDuracion(float duracion) {
        this.DURACION = duracion;
    }

    public String getGenero() {
        return GENERO;
    }

    public void setGenero(String genero) {
        this.GENERO = genero;
    }
}
