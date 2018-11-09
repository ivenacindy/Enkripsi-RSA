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
    
    public static void main(String[] args) {
        Enkripsi n = new Enkripsi();
        int h =n.getO(7, 11);
        System.out.println("iniO"+h);
        int j= n.getE(h);
        System.out.println("ini E"+j);
    }
}
