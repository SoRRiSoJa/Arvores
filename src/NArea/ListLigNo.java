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
public class ListLigNo {
    private NNDarea info;
    private ListLigNo prox, ant;

    public ListLigNo(NNDarea info, ListLigNo ant, ListLigNo prox) {
        this.info = info;
        this.prox = prox;
        this.ant = ant;
    }

    public NNDarea getInfo() {
        return info;
    }

    public void setInfo(NNDarea info) {
        this.info = info;
    }

    public ListLigNo getProx() {
        return prox;
    }

    public void setProx(ListLigNo prox) {
        this.prox = prox;
    }

    public ListLigNo getAnt() {
        return ant;
    }

    public void setAnt(ListLigNo ant) {
        this.ant = ant;
    }
    
    
}
