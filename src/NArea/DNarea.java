/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NArea;

import BPtree.Param;

/**
 *
 * @author Aluno
 */
public class DNarea implements Param{
    NNDarea raiz;

    public DNarea() {
        raiz=null;
    }
    public void insere(int info){
    
    NNDarea p,ant=null;
        if(raiz==null){
            raiz=new NNDarea(info);
        }else{
            p=raiz;
            while(p!=null){
                if(p.getTl()<N-1){
                
                
                }
            }
            
        }
    }
    public NNDarea busca(int info){
        NNDarea aux=raiz;
        ListInfoNo auxInfo;
        while(aux.getlLig()!=null){
            
        }
        return null;
    }
    
}
