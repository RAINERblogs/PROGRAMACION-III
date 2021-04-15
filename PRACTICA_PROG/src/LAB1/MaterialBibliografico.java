/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1;

import java.io.Serializable;

/**
 *
 * @author PC-AL_100
 */
public class MaterialBibliografico implements Serializable{
    static final long serialVersionUID=45L;
    // ATRIBUTOS
    private String titulo;
    private String autor;
    
    // METODOS
    public void mostrar(){
        System.out.println("Titulo   : "+this.titulo);
        System.out.println("Autor   : "+this.autor);
    }
    // GETTER AND SETTER

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
