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
public class Dekripsi {
    private int p,q,d;
    int N;
    
    int getN(int p, int q){
        return p*q;
    }
    
    public String getDecrypt(String enkrip, int d, int N){
        String dekrip;
        char[] dec = enkrip.toCharArray();
        for(int i=0; i<dec.length; i++){
            dec[i] = (char) (Math.pow(dec[i], d)%N);
        }
        dekrip = String.valueOf(dec);
        return dekrip;
    }
}
