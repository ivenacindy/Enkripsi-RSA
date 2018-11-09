/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

/**
 *
 * @author ivenacindy
 */
public class Enkripsi {
    private int p,q,d;
    int e;
    
    int getN(int p, int q){
        return p*q;
    }
    
    int getO(int p, int q){
        return ((p-1)*(q-1));
    }
    
    int getE(int O){
        e = 0;
        int i=0;
        for(i=2;i<O;i++){
            if(i)
        }
        return e;
    }
}
