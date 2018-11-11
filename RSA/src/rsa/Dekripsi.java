/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.math.BigInteger;

/**
 *
 * @author ivenacindy
 */
public class Dekripsi {
    private int p,q,d;
    int N;
    Dekripsi de;
    
    int getN(int p, int q){
        return p*q;
    }
    
    static String plain;
    
    public String getPlain(){
        return plain;
    }
   
    public String getDecrypt(int[] cip, int d, int N){
        String dekrip;
        BigInteger nilai, a, n;
        n = BigInteger.valueOf(N);
        ConvertStringToInt t = new ConvertStringToInt();
        System.out.println("cip " + cip[4]);
        for(int i=0; i<cip.length; i++){
            System.out.println("d"+i+" "+cip[i]);
            a = BigInteger.valueOf(cip[i]);
            nilai = a.pow(d);
            nilai = nilai.mod(n);
            System.out.println("Bagi "+nilai);
            cip[i] = nilai.intValue();            
            System.out.println("e"+i+" "+cip[i]);
        }
        dekrip = t.ConvString(cip);
        plain = dekrip;
        System.out.println("plain "+ plain);
        return dekrip;
    }
    
    public void Decrypt (String cip, int d, int N){
        String[] kata = cip.split(" ");
        int cipher[] = new int[kata.length] ;
        for (int i = 0; i < kata.length; i++) {
            System.out.println("kata : " + kata[i]);
            String a = kata[i];
            cipher[i] = Integer.parseInt(a);
        }
        getDecrypt(cipher, d, N);
    }
    
    
    public static void main(String[] args) {
        Dekripsi a = new Dekripsi();
        int[] cip = {24533,8751,28007,23380,268};
        int d = 877;
        int N = 1207;
        a.Decrypt("864 902 698 1128 1117", d, N);
//        System.out.println("HMM : "+ a.getDecrypt(cip,d ,N ));
    }
}
