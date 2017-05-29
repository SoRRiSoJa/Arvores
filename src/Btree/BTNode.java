/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Btree;

import BPtree.Param;

/**
 *
 * @author joao
 */
public class BTNode implements Param {

    private int[] vInfo;
    private int[] vPos;
    private BTNode[] vLig;
    private int tl;

    public BTNode() {
        this.vInfo = new int[N * 2 + 1];
        this.vPos = new int[N * 2 + 1];
        this.vLig = new BTNode[N * 2 + 2];
        for (int i = 0; i < N * 2 + 2; i++) {
            this.vLig[i] = null;
        }
        this.tl = 0;
    }

    public BTNode(int info, int pos) {
        this.vInfo = new int[N * 2 + 1];
        this.vPos = new int[N * 2 + 1];
        this.vLig = new BTNode[N * 2 + 2];
        for (int i = 0; i < N * 2 + 2; i++) {
            this.vLig[i] = null;
        }
        this.vInfo[0] = info;
        this.vPos[0] = pos;
        this.tl = 0;
    }

    public void setInfo(int pos, int info) {
        this.vInfo[pos] = info;
    }

    public void setPos(int pos, int info) {
        this.vPos[pos] = info;
    }

    public int getInfo(int pos) {
        return this.vInfo[pos];
    }

    public int getPos(int pos) {
        return this.vPos[pos];
    }

    public void setLig(int pos, BTNode no) {
        this.vLig[pos] = no;
    }

    public BTNode getLig(int pos) {
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
            vPos[i] = vPos[i - 1];
            vLig[i] = vLig[i - 1];
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
            vPos[pos] = vPos[pos + 1];
            vLig[pos] = vLig[pos + 1];
            pos++;
        }
        tl--;
    }

    /*Retorna se um nó é uma folha
      boolean isFolha()
     * Retorna true para nó com 0 ligações e N+1 elementos
     */
    public boolean isFolha() {
        return (vLig[0] == null && tl > N);
    }
}
