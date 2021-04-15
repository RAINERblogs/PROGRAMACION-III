
package DISCO_DURO;

import java.io.Serializable;

public class ARCHIVO implements Serializable{
    transient static final long serialVersionUID=3L;
    private String nomARCHIVO;
    private double tamARCHIVO;


    public String getNombrear() {
        return nomARCHIVO;
    }

    public void setNombrear(String nombrear) {
        this.nomARCHIVO = nombrear;
    }

    public double getTamar() {
        return tamARCHIVO;
    }

    public void setTamar(double tamar) {
        this.tamARCHIVO = tamar;
    }
    
    public void mostrar(){
        System.out.println("NOMBRE ARCHIVO      : " + this.nomARCHIVO);
        System.out.println("TAMAÑO ARCHIVO (MB) : " + this.tamARCHIVO);
    }
    
}
