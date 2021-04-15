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
public class ProyectoGrado extends MaterialBibliografico{
    static final long serialVersionUID=47L;
    // ATRIBUTOS
    private String tutor;
    private String revisor;
    
    // METODOS
    @Override
    public void mostrar(){
        System.out.println("------------------------------------------------");
        super.mostrar();
        System.out.println("Tutor : "+this.tutor);
        System.out.println("Revisor  : "+ this.revisor);
        System.out.println("------------------------------------------------");
    }
    // GETTER AND SETTER

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
}
