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
        ConvertStringToInt t = new ConvertStringToInt();
        int[] text = t.ConvInt(enkrip);
        for(int i=0; i<text.length; i++){
            text[i] = (int) (Math.pow(text[i], d)%N);
            text[i] -= 10;
            if(text[i]<0){
                text[i] +=93;
            }
            System.out.println("d"+i+" "+text[i]);
        }
        dekrip = t.ConvString(text);
        return dekrip;
    }
}
