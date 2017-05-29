/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NArea;

/**
 *
 * @author joao
 */
public class NArea {

    private Node root;

    public NArea() {
        this.root = null;
    }

    public void insere(int info) {
        Node p, ant = null;
        int pos = 0;
        boolean flag = false;
        if (root == null) {
            root = new Node(info);
        } else {
            p = root;
            while (p != null && !flag) {
                if (p.getTl() < (Node.N - 1)) {
                    pos = p.busca(info);
                    p.remaneja(pos);
                    p.setvInfo(pos, info);
                    p.setTl(p.getTl() + 1);
                    flag = true;
                } else {
                    ant = p;
                    pos = p.busca(info);
                    p = p.getvLig(pos);
                }
            }
            if (!flag) {
                ant.setvLig(pos, new Node(info));
            }
        }
    }

    public Node getRaiz() {
        return root;
    }

    public void inOrden(Node raiz) {
        if (raiz != null) {
            for (int i = 0; i < raiz.getTl(); i++) {
                inOrden(raiz.getvLig(i));
                System.out.print("[" + raiz.getInfo(i) + "]");
            }
            inOrden(raiz.getvLig(raiz.getTl()));
        }
    }

}
