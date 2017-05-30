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
public class NNDarea {
    private ListInfo lInfo;
    private ListLig lLig;
    private int tl;

    public NNDarea(int info) {
        this.lInfo.insere(info);
        tl++;
    }

    public ListInfo getlInfo() {
        return lInfo;
    }

    public void setlInfo(int info) {
        this.lInfo.insere(info);
    }

    public ListLig getlLig() {
        return lLig;
    }

    public void setlLig(ListLig lLig) {
        this.lLig = lLig;
    }

    public int getTl() {
        return tl;
    }

    public void setTl(int tl) {
        this.tl = tl;
    }
    
}
