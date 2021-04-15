/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1;

/**
 *
 * @author PC-AL_100
 */
public class Libro extends MaterialBibliografico{
    static final long serialVersionUID=46L;
     // ATRIBUTOS
    private int edicion;
    private String area;
    
    // METODOS
    @Override
    public void mostrar(){
        System.out.println("--------------------------------------------------");
        super.mostrar();
        System.out.println("Edicion : "+this.edicion);
        System.out.println("Area    : "+ this.area);
        System.out.println("----------------------------------------------------");
    }
    // GETTER AND SETTER

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
}
