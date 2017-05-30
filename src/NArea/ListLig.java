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
public class ListLig {

    private ListLigNo lista;
    private ListLigNo inicio, fim;

    public ListLig() {
        this.lista = null;
    }
    public void insere(NNDarea info){
        ListLigNo nova = new ListLigNo(info, null, null);
        if(lista==null){
            lista=nova;
            inicio=fim=lista;
        }else{
            nova.setAnt(fim);
            fim.setProx(nova);
            fim=nova;
        }
    }

}
