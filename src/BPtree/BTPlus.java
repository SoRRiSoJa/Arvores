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
public class BTPlus implements Param {

    private BPNode raiz;

    public BTPlus() {
        this.raiz = null;
    }

    /* Retorna o nodo folha com a informação em info
     * BPNode navega_ate_folha(int)
     * @param info
     * Retorna o nodo folha em que se encontra a informação
     */
    public BPNode navega_ate_folha(int info) {
        BPNode p = raiz;
        int i = 0;
        while (p.getLig(0) != null && p.getInfo(i) != info) {
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

    /* Retorna o nodo pai para folha com a informação info
     * BPNode localizaPai(BPNode, int)
     * @param folha
     * @param info
     * Retorna o nodo pai para o nodo folha com a info
     */
    public BPNode localizaPai(BPNode folha, int info) {
        BPNode p = raiz, pai = p;
        int i;
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

    private void split(BPNode folha, BPNode pai, int info) {
        BPNode caixa1, caixa2, cxProx, cxAnt;
        int i, pos, n = N;
        int TL1;
        caixa1 = new BPNode();
        caixa2 = new BPNode();
        if (folha.isFolha()) {
            TL1 = (int) Math.round((n - 1) / 2.0);//parte inteira
        } else {
            TL1 = (int) Math.round((n / 2.0) - 1);//arredondamento para cima
        }
        for (i = 0; i < TL1; i++)//cria /menores pra caixa 1
        {
            caixa1.setInfo(i, folha.getInfo(i));
            caixa1.setLig(i, folha.getLig(i));
        }
        caixa1.setTl(i);
        caixa1.setLig(caixa1.getTl() - 1, folha.getLig(caixa1.getTl() - 1));
        int j = 0;
        for (; i < n; i++)//restante caixa 2
        {
            caixa2.setInfo(j, folha.getInfo(i));
            caixa2.setLig(j, folha.getLig(i));
            j++;
        }
        caixa2.setLig(j, folha.getLig(n - 1));
        caixa2.setTl(j);
        if (pai == folha) // primeiro split
        {
            if (folha.isFolha()) {
                folha.setInfo(0, caixa2.getInfo(0));   // insere na folha o menor eelmenento da 2 caixa                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
                folha.setLig(0, caixa1);// liga na posicao 0 a caixa 1
                folha.setLig(1, caixa2);// posicao 1 caixa 2
                caixa1.setProx(caixa2);
                folha.setTl(1);
            } else {
                folha.setInfo(0, caixa2.getInfo(0));
                folha.setLig(0, caixa1); //liga as caixa 1 e 2 
                folha.setLig(1, caixa2);
                caixa1.setProx(caixa2);
                folha.setTl(2);
                caixa2.remanejaSplit(0);
                caixa2.setTl(caixa2.getTl() - 1);
            }
        } else {
            info = caixa2.getInfo(0);// pega o menor valor
            pos = pai.procuraPosicao(info);// procura posicao
            cxProx = pai.getLig(pos + 1);// para pegar o N da PROXIMA posicao
            pai.remaneja(pos);
            pai.setTl(pai.getTl() + 1);

            pai.setInfo(pos, info);
            pai.setLig(pos, caixa1);
            pai.setLig(pos + 1, caixa2);
            caixa1.setProx(caixa2);

            if (pos == 0)// INICIO
            {
                caixa2.setProx(cxProx);
            } else {
                cxAnt = pai.getLig(pos - 1);// pega o no anterior
                cxAnt.setProx(caixa1);
                caixa2.setProx(cxProx);
            }

            if (pai.getTl() > n)//overflow
            {
                folha = pai;
                pai = localizaPai(pai, info);
                split(folha, pai, info);
            }
        }
    }

    public void insere(int info) {
        BPNode no, pai;
        int pos;
        if (raiz == null) {
            raiz = new BPNode(info);
        } else {
            no = navega_ate_folha(info);
            pos = no.procuraPosicao(info);
            no.remaneja(pos);
            no.setTl(no.getTl() + 1);
            no.setInfo(pos, info);

            if (no.getTl() > N - 1)// N é sempre para LIGAÇÃO !
            {
                pai = localizaPai(no, info);
                split(no, pai, info);
            }

        }

    }
    public void inOrden(BPNode raiz) {
        while(raiz.getLig(0)!=null){
            raiz=raiz.getLig(0);
        }
        while(raiz!=null){
            raiz.exibeNo();
            raiz=raiz.getProx();
        }
            
    }
    public BPNode getRaiz(){
        return this.raiz;
    }

}
