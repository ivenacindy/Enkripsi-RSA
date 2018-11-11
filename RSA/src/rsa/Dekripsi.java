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
   
    public String getDecrypt(int[] cip,int d, int N){
        String dekrip;
        ConvertStringToInt t = new ConvertStringToInt();
        System.out.println("cip " + cip[4]);
        for(int i=0; i<cip.length; i++){
            System.out.println("d"+i+" "+cip[i]);
            int bag = (int) Math.pow(cip[i], d);
            System.out.println("Bagi "+bag);
            cip[i] = (int) (Math.pow(cip[i], d)%N);
            
            System.out.println("d"+i+" "+cip[i]);
        }
        dekrip = t.ConvString(cip);
        return dekrip;
    }
    
    public static void main(String[] args) {
        Dekripsi a = new Dekripsi();
        int[] cip = {23,18,1,14,7};
        int d = 11;
        int N = 34;
        System.out.println("HMM : "+ a.getDecrypt(cip,d ,N ));
    }
}
