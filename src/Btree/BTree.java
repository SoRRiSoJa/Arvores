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
public class BTree implements Param{
    private BTNode raiz;

    public BTree() {
        this.raiz = null;
    }
//--------------------------------------------------------------------------

    /* Navega até uma folha com a informação info
     * BTnode navegaAteFolha(int)
     * @param info
     * Retorna o nó da Arvore contendo a informação info
     */
    public BTNode navegaAteFolha(int info) {
        BTNode p = raiz;
        int i = 0;
        while (p.getLig(0) != null) {
            i = 0;
            while (i < p.getTl() && info > p.getInfo(i)) {
                i++;
            }
            if (p.getInfo(i) != info) {
                p = p.getLig(i);
            }
        }
        return p;
    }
//--------------------------------------------------------------------------

    /* Localiza o No Pai de Uma folha com a informação info
     * BTnode localizaPai(int,BTnode)
     * @param info
     * @param folha
     * Retorna o nó da Arvore contendo o nó pais para o nó folha
     */
    public BTNode localizaPai(int info, BTNode folha) {
        BTNode pai, p = raiz;
        int i;
        pai = p;
        while (p != folha) {
            i = 0;
            while (i < p.getTl() && info > p.getInfo(i)) {
                i++;
            }
            pai = p;
            p = p.getLig(i);
        }
        return pai;
    }
//--------------------------------------------------------------------------

    public void split(BTNode folha, BTNode pai, int info) {
        BTNode cx1 = new BTNode(), cx2 = new BTNode();
        int pos, infoAux, i;
        for (i = 0; i < N; i++) {
            cx1.setInfo(i, folha.getInfo(i));
            cx1.setPos(i, folha.getPos(i));
            cx1.setLig(i, folha.getLig(i));
        }
        cx1.setLig(N, folha.getLig(N));
        cx1.setTl(N);
        for (i = (N + 1); i < (2 * N + 1); i++) {
            cx2.setInfo((i - N + 1), folha.getInfo(i));
            cx2.setPos((i - N + 1), folha.getPos(i));
            cx2.setLig((i - N + 1), folha.getLig(i));
        }
        cx2.setLig(N, folha.getLig(i));
        cx2.setTl(N);
        if (pai == folha) {
            folha.setInfo(0, folha.getInfo(N));
            folha.setPos(0, folha.getPos(N));
            folha.setLig(0, cx1);
            folha.setLig(1, cx2);
            folha.setTl(1);
        } else {
            pos = pai.procuraPosicao(info);
            pai.remaneja(pos);
            pai.setTl(pai.getTl() + 1);
            pai.setInfo(pos, folha.getInfo(N));
            pai.setPos(pos, folha.getPos(N));
            pai.setLig(pos, cx1);
            pai.setLig(pos + 1, cx2);
            if (pai.getTl() > 2 * N) {
                folha = pai;
                infoAux = folha.getInfo(N);
                pai = localizaPai(info, pai);
                split(folha, pai, info);
            }
        }
    }

    //--------------------------------------------------------------------------
    /* Insere uma informação e sua respectiva posição no arquivo em uma BTree
     * void insere(int,int)
     * @param info
     * @param posArq
     */
    public void insere(int info, int posArq) {
        BTNode folha, pai;
        int pos;
        if (raiz == null) {
            raiz = new BTNode(info, posArq);
        } else {
            folha = navegaAteFolha(info);
            pos = folha.procuraPosicao(info);
            folha.remaneja(pos);
            folha.setTl(folha.getTl() + 1);
            folha.setInfo(pos, info);
            folha.setPos(pos, posArq);
            if (folha.getTl() > 2 * N) {
                pai = localizaPai(info, folha);
                split(folha, pai, info);
            }
        }
    }

    //--------------------------------------------------------------------------
    public void inOrden(BTNode raiz) {
        if (raiz != null) {
            for (int i = 0; i < raiz.getTl(); i++) {
                inOrden(raiz.getLig(i));
                System.out.print("[" + raiz.getInfo(i) + "]");
            }
            inOrden(raiz.getLig(raiz.getTl()));
        }
    }
//--------------------------------------------------------------------------

    private BTNode pegaVizinho(int info, BTNode pai) {
        int pos = pai.procuraPosicao(info);
        return (pos >= pai.getTl()) ? pai.getLig(pos - 1) : pai.getLig(pos + 1);
    }
//--------------------------------------------------------------------------
    public boolean verPagIrmaDir(BTNode pai) {
        BTNode pDir = pai.getLig(pai.getTl());
        int cont = 0, i = 0;
        while (i < (2 * N + 2)) {
            if (pDir.getLig(i) != null) {
                cont++;
            }
            i++;
        }
        return (cont > N);

    }
//--------------------------------------------------------------------------
    public boolean verPagIrmaEsq(BTNode pai) {
        BTNode pDir = pai.getLig(pai.getTl()-1);
        int cont = 0, i = 0;
        while (i < (2 * N + 2)) {
            if (pDir.getLig(i) != null) {
                cont++;
            }
            i++;
        }
        return (cont > N);
    }
//--------------------------------------------------------------------------
    public BTNode getRaiz() {
        return raiz;
    }
//--------------------------------------------------------------------------

}
