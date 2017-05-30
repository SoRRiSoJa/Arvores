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
public class ListInfo {

    private ListInfoNo lista;
    private ListInfoNo ini, fim;

    public ListInfo() {
        this.lista = null;
    }

    public void insere(int info) {
        ListInfoNo nova= new ListInfoNo(info);
        if (lista == null) {
            lista = nova;
            ini=fim=lista;
        } else {
            nova.setAnt(fim);
            fim.setProx(nova);
            fim=nova;
        }
    }

}
