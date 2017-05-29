/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPtree;

/**
 *
 * @author joao
 */
public class BPNode implements Param {

    private int[] vInfo;
    private BPNode[] vLig;
    private BPNode ant;
    private BPNode prox;

    private int tl;

    public BPNode() {
        this.vInfo = new int[N * 2 + 1];
        this.vLig = new BPNode[N * 2 + 2];
        this.ant = this.prox = null;
        for (int i = 0; i < N * 2 + 2; i++) {
            this.vLig[i] = null;
        }
        this.tl = 0;
    }

    public BPNode(int info) {
        this.vInfo = new int[N * 2 + 1];
        this.vLig = new BPNode[N * 2 + 2];
        this.ant = this.prox = null;
        for (int i = 0; i < N * 2 + 2; i++) {
            this.vLig[i] = null;
        }
        this.vInfo[0] = info;
        this.tl = 1;
    }

    public void setInfo(int pos, int info) {
        this.vInfo[pos] = info;
    }

    public int getInfo(int pos) {
        return this.vInfo[pos];
    }

    public void setLig(int pos, BPNode no) {
        this.vLig[pos] = no;
    }

    public BPNode getLig(int pos) {
        return this.vLig[pos];
    }

    public void setTl(int tl) {
        this.tl = tl;
    }

    public int getTl() {
        return tl;
    }

    /*Retorna a posição no vetor vInfo para uma info
     * int procuraPosicao(int)
     * @param info
     * Retorna inteiro com a posição do vetor de informações para a informação do nó
     */
    public int procuraPosicao(int info) {
        int i = 0;
        while (i < getTl() && info > getInfo(i)) {
            i++;
        }
        return i;
    }

    /*Remaneja de  o vetor de informações para etapa de operação de inserção
     * void remanejaInvertido(int)
     * @param pos
     */
    public void remaneja(int pos) {
        vLig[tl + 1] = vLig[tl];
        for (int i = tl; i > pos; i--) {
            vInfo[i] = vInfo[i - 1];
            vLig[i] = vLig[i - 1];
        }
    }

    public void remanejaSplit(int info) {
        int pos = info;
        while (pos < tl - 1) {
            vInfo[pos] = vInfo[pos + 1];
            vLig[pos] = vLig[pos + 1];
            pos++;
        }
    }

    /*Remaneja de forma inversa o vetor de informações para etapa de operação de exclusao
     * void remanejaInvertido(int)
     * @param pos
     */
    public void remanejaInvertido(int info) {
        int pos = procuraPosicao(info);
        while (pos < tl) {
            vInfo[pos] = vInfo[pos + 1];
            vLig[pos] = vLig[pos + 1];
            pos++;
        }
        tl--;
    }

    /*Retorna se um nó é uma folha
      boolean isFolha()
     * Retorna true para nó com 0 ligações
     */
    public boolean isFolha() {
        return (vLig[0] == null);
    }

    public BPNode getAnt() {
        return ant;
    }

    public void setAnt(BPNode ant) {
        this.ant = ant;
    }

    public BPNode getProx() {
        return prox;
    }

    public void setProx(BPNode prox) {
        this.prox = prox;
    }

}
