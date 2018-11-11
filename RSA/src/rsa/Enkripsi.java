/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author ivenacindy
 */
public class Enkripsi {
    private int d;
    int e;
    Enkripsi en;
    GUI gui;
    
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

    static String cipher,str;
    
    int getE(int O){
        e =1;
        Random rand = new Random(); // generate a random number
        while(O % e == 0){
            do {
                e = rand.nextInt(O) - 1;
//                System.out.println(e);
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
    
    
    public static String Cipher (int[] x ){
        String str="";
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[i] : " + x[i]);
            str += x[i]+ " ";
        }
        cipher = str;
        return str;
    }
    
    public String getString(){
        return str;
    }
    
    public String getCipher (){
        return cipher;
    }
    public String getEncrypt(String plain, int E, int N){
        gui = new GUI();
        String enkrip = "";
        BigInteger nilai, a,n;
        n = BigInteger.valueOf(N);
        int i =0;
        ConvertStringToInt t = new ConvertStringToInt();
        int[] text = t.ConvInt(plain);
//        System.out.println("jj");
        for( i=0; i<text.length;i++){
//            System.out.print(text[i]);
//            System.out.println("E"+i+" "+text[i]);
//            System.out.println("E : "+ Math.pow(text[i], E) );
            a = BigInteger.valueOf(text[i]);
            nilai = a.pow(E);
            nilai = nilai.mod(n);
//            System.out.println("Bagi "+nilai);
            text[i] = nilai.intValue();
            enkrip += text[i]; 
//            System.out.println("e"+i+" "+text[i]);
        }
        
        String q = Enkripsi.Cipher(text);
        enkrip = t.ConvString(text);
        str = enkrip;
        return enkrip;
    }
    
    public void Encrypt (String plain, int p, int q){
        en = new Enkripsi();
        int o = en.getO(p, q);        
        int N = en.getN(p, q);
        int E = en.getE(o);
        int dodol = en.getD(o, E);
        System.out.println("D : " + dodol);
        System.out.println("N : " + N);
        en.getEncrypt(plain, E, N);
    }
    
    public static void main(String[] args) {
        Enkripsi n = new Enkripsi();
        int p=71, q = 557;
        int h =n.getO(p, q);
        System.out.println(n.getN(p, q));
        System.out.println("iniO"+h);
        int j= n.getE(h);
        System.out.println("ini E "+j);
        int dodol = n.getD(h, j);
        System.out.println("ini D " + dodol);
        String hm= n.getEncrypt("ivena", j, n.getN(p, q));
        System.out.println("HASIL ENCRYPT: "+ hm);
//        
//        Dekripsi m = new Dekripsi();
//        String hmm = m.getDecrypt(text, dodol, m.getN(p, q));
//        System.out.println("HASIL DECRYPT: "+hmm);
//    }
    }
}
