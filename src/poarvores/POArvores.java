/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poarvores;

import BPtree.BTPlus;
import NArea.NArea;

/**
 *
 * @author joao
 */
public class POArvores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BTPlus arvore = new BTPlus();
        
        arvore.insere(10);
        arvore.insere(30);
        arvore.insere(77);
        arvore.insere(83);
        arvore.insere(44);
        arvore.insere(32);
        arvore.insere(21);
        arvore.insere(15);
        arvore.insere(17);
        arvore.insere(74);
        
        System.out.print("Inseridno valores:");
        
        System.out.println("");
        System.out.println("inOrden:");
        arvore.inOrden(arvore.getRaiz());
    }

    
}
