

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaop
 */
public class Perguntas 
{
    static Scanner scan = new Scanner (System.in);
    static void Perguntas()
        {
           ArrayList<String> respos = new ArrayList<String>();
       
        respos.add("A: Do");
        respos.add("B: While");
        respos.add("C: If");
        respos.add("D: For");
        respos.add("E: Else");
        
        String resp;
        
        boolean  certa;
        
       do 
       {
         System.out.println("Em nossa lingua 'SE' corresponde a qual função abaixo (utilizando letras a letra correspondente)");
         System.out.println(respos);
   
         resp = scan.next();

         switch(resp)
         {
             case "c":
             case "C":
                 certa = true;
                 System.out.println("Resposta Correta na tentativa:  ");    
                 
                 break;
                 
             default: 
                 certa = false;
                 System.out.println("Resposta Errada. Tentativa: ");    
         }    
                 
        Collections.shuffle(respos);
           
           
        }while(resp.equals("e") || resp.equals("E")|| resp.equals("a")|| resp.equals("A")||
               resp.equals("B")|| resp.equals("b") || resp.equals("d")|| resp.equals("D"));
    }
}
