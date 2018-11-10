/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.util.Random;

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
    
    private static boolean isPrime(int inputNum){
        if (inputNum <= 3 || inputNum % 2 == 0) 
            return inputNum == 2 || inputNum == 3; //this returns false if number is <=1 & true if number = 2 or 3
        int divisor = 3;
        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0)) 
            divisor += 2; //iterates through all possible divisors
        return inputNum % divisor != 0; //returns true/false
    }

    
    int getE(int O){
        e =1;
        Random rand = new Random(); // generate a random number
        while(O % e == 0){
            do {
                e = rand.nextInt(O) - 1;
                System.out.println(e);
            }while(!isPrime(e));
        }
        return e;
    }
    
    int getD(int O, int E){
        int x, i=0;
        do{
            i++;
            x = 1+(i*O);
        }while(x%E!=0);
        d=x/E;
        return d;
    }
    
    public String getEncrypt(String plain, int E, int N){
        String enkrip;
        ConvertStringToInt t = new ConvertStringToInt();
        int[] text = t.ConvInt(plain);
        System.out.println("jj");
        for(int i=0; i<text.length;i++){
            System.out.print(text[i]);
            //System.out.println("E"+i+" "+text[i]);
            text[i] = (int) (Math.pow(text[i], E)%N);
            System.out.println("e"+i+" "+text[i]);
        }
        enkrip = t.ConvString(text);
        
        return enkrip;
    }
    
    public static void main(String[] args) {
        Enkripsi n = new Enkripsi();
        int h =n.getO(7, 3);
        System.out.println("iniO"+h);
        int j= n.getE(h);
        System.out.println("ini E "+j);
        int dodol = n.getD(h, j);
        System.out.println("ini D " + dodol);
        String hm= n.getEncrypt("ivena cindy", j, n.getN(7,3));
        System.out.println("HASIL ENCRYPT: "+hm);
        
        Dekripsi m = new Dekripsi();
        String hmm = m.getDecrypt(hm, dodol, m.getN(7,3));
        System.out.println("HASIL DECRYPT: "+hmm);
    }
}
