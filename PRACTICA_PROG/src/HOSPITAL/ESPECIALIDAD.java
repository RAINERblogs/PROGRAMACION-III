
package HOSPITAL;

import java.io.Serializable;

public class ESPECIALIDAD implements Serializable{
    transient static final long serialVersionUID=40L;

    private String nomEspe;
 
    public void mostrarEspe(){
        System.out.println("ESPECIALIDAD : "+this.nomEspe);
    }
 
    public String getNomEspe() {
        return nomEspe;
    }

    public void setNomEspe(String nomEspe) {
        this.nomEspe = nomEspe;
    }
}
