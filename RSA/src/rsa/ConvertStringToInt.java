/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.util.Arrays;

/**
 *
 * @author ivenacindy
 */
public class ConvertStringToInt {
    char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
                    'n','o','p','q','r','s','t','u','v','w','x','y','z',
                    '1','2','3','4','5','6','7','8','9','0',' ',',','.',
                    '?','!','@','#','$','%','^','&','*','(',')','-','_',
                    '=','+','{','}','[',']','\\','|',':',';','\'','"','/','<','>',
                    'A','B','C','D','E','F','G','H','I','J','K','L','M',
                    'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
    public int[] ConvInt(String text){
        char t[] = text.toCharArray();
        
        int length = t.length;
        int[] c= new int[length];
        int j;
        for(int i=0;i<t.length;i++){
            j=0;
            while(t[i]!=alpha[j] && j<alpha.length){
                j++;
            }
            c[i]=j+10;
            if(c[i]>92){
                c[i] -=93;
            }
        }
        return c;
    }
    
    public String ConvString(int[] c){
        String t="";
        char[] T= new char[c.length];
        for(int i=0;i<c.length;i++){
            T[i]= alpha[c[i]];
            t += T[i];
        }
        return t;
    }
    
    public static void main(String[] args) {
        ConvertStringToInt kata = new ConvertStringToInt();
        String nama = "ivena";
        int[] t = kata.ConvInt(nama);
        System.out.println("int "+Arrays.toString(t));
        String namaH = kata.ConvString(t);
        System.out.println(namaH);
    }
}
