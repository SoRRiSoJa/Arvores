/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NArea;

import BPtree.Param;

/**
 *
 * @author joao
 */
public class Node implements Param{

    private final int[] vInfo;
    private final Node[] vLig;
    private int tl;

    public Node()  {
        this.tl = 0;
        this.vInfo = new int[N - 1];
        this.vLig = new Node[N];
        for (int i = 0; i < N; i++) {
            vLig[i] = null;
        }

    }

    public Node(int info) {
        this.vInfo = new int[N - 1];
        this.vLig = new Node[N];
        this.vInfo[0] = info;
        for (int i = 0; i < N; i++) {
            vLig[i] = null;
        }
        tl = 1;

    }

    public int getInfo(int pos) {
        return vInfo[pos];
    }

    public void setvInfo(int pos, int info) {
        if (tl < N - 1 && pos < N - 1) {
            this.vInfo[pos] = info;
        }
    }

    public Node getvLig(int pos) {
        return vLig[pos];
    }

    public void setvLig(int pos, Node lig) {
        this.vLig[pos] = lig;
    }

    public int getTl() {
        return tl;
    }

    public void setTl(int val) {
        this.tl = val;
    }

    public int busca(int info) {
        int pos = 0;
        while (pos < tl && info > vInfo[pos]) {
            pos++;
        }
        return pos;
    }

    public void remaneja(int pos) {
        for (int i = tl; i > pos; i--) {
            vInfo[i] = vInfo[i - 1];
        }
    }
}
