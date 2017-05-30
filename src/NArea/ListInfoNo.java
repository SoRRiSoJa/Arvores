/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NArea;

/**
 *
 * @author Aluno
 */
public class ListInfoNo {

    public int info;
    public ListInfoNo ant;
    public ListInfoNo prox;

    public ListInfoNo() {
        this.ant = this.prox = null;
    }

    public ListInfoNo(int info) {
        this.info = info;
        this.ant = this.prox = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public ListInfoNo getAnt() {
        return ant;
    }

    public void setAnt(ListInfoNo ant) {
        this.ant = ant;
    }

    public ListInfoNo getProx() {
        return prox;
    }

    public void setProx(ListInfoNo prox) {
        this.prox = prox;
    }
    

}
