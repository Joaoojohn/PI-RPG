
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaop \
 */
public class rpg 
{
    static Scanner scan = new Scanner(System.in);
    
    
    public static void main(String[] args) 
    {
 
        String opcao;
        
        System.out.println("Olá! Seja bem vindo ao Reino Hello World! ");
        System.out.println("");
        System.out.println("");
        
        
            
         System.out.println("Escolha uma das opções a seguir: ");
        
         System.out.println("1: Jogar");
         System.out.println("2: Ranking");
         System.out.println("3: Créditos");
         System.out.println("4: Sair");
        
        do 
        {
            
         opcao = scan.next();

         switch (opcao) 
         {
             case "1":
                   System.out.println("Bora Jogar! ");
                   InformacaoUsu();
                   
                 break;
             
             case "2":
                 System.out.println("Bora Jogar! ");

                 break;
             case "3":
                 System.out.println("RPG produzido por: ");
                 System.out.println("João Pedro Santos Costa");
                 
                 break;
                 
             case "4":
                 System.out.println("Sair ");
                 
                 
                 break;
                 
             default:
                 System.out.println("Opção Invalida!");
        } 
        
        }while (opcao.equals("4") == false);
        
    }
    
        static void InformacaoUsu()
        {
            
            String nome, Classes;
            
            
            System.out.println("Antes começar o jogo, informe o seu nome: ");
            nome = scan.next();
            
            System.out.println(nome + " agora escolha uma classe desejada: ");
            Classes = scan.next();
            
          Perguntas(nome, Classes);
        }
        
        
        static void Perguntas(String nome, String classe)
       {
         long start = System.currentTimeMillis();
        
         
         
        ArrayList<String> respos = new ArrayList<>();
      
        ArrayList<Character> ale =  Aleatorio();
      
        
          char a = ale.get(0);
          char b = ale.get(1);
          char c = ale.get(2);
          char d = ale.get(3);
          char e = ale.get(4);
      
                  
        
        
        Collections.shuffle(ale);
        respos.add( a + " Do");
        respos.add( b + " While");
        respos.add( c + " If");
        respos.add( d + " For");
        respos.add( e + " Else");
        
        String resp;
        
        boolean  certa;
        
       do 
       {
         System.out.println("Em nossa lingua 'SE' corresponde a qual função abaixo (utilizando letras a letra correspondente)");
        Collections.shuffle(ale);
        respos.add( a + " Do");
        respos.add( b + " While");
        respos.add( c + " If");
        respos.add( d + " For");
        respos.add( e + " Else");
        
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
                 
        
        Collections.shuffle(ale);
         
      
           
        }while(resp.equals("e") || resp.equals("E")|| resp.equals("a")|| resp.equals("A")||
               resp.equals("B")|| resp.equals("b") || resp.equals("d")|| resp.equals("D"));
       
       
         long end = System.currentTimeMillis();
           
        tempo(start, end);
       
    }
        
        
        
        static void tempo(long start, long end)
        {
             long tempo = end - start;
             
             
             long minutos  = ( tempo / 60000 ) % 60;
             long segundos = ( tempo / 1000 ) % 60;
            
            System.out.println( String.format( "%02d:%02d", minutos,segundos ) );
        }
        
        
        static ArrayList Aleatorio()
        {
                Random r = new Random();
        
        char a ;
           char b;
           char c;
           char d;
           char e;
          
            a = (char)(r.nextInt(5) + 'A');
            b = (char)(r.nextInt(5) + 'A');
            c = (char)(r.nextInt(5) + 'A');
            d = (char)(r.nextInt(5) + 'A');
            e = (char)(r.nextInt(5) + 'A');  
           
           
      if (a == b || a == c || a == d || a == e) 
       {
            while(a == b || a == c || a == d || a == e)
            {
                a = (char)(r.nextInt(5) + 'A');
            }
       }
           
       if (b == a || b == c || b == d || b == e) 
        {
            while(b == a || b == c || b == d || b == e)
            {
                b = (char)(r.nextInt(5) + 'A');
            }
       }
      
       if (c == b || c == a || c == d || c == e) 
       {
            while(c == b || c == a || c == d || c == e)
            {
                c = (char)(r.nextInt(5) + 'A');
            }
       }
           
       if (d == b || d == c || d == a || d == e) 
        {
            while(d == b || d == c || d == a || d == e)
            {
                d = (char)(r.nextInt(5) + 'A');
            }
       }
      
      
        if  (e == b || e == c || e == d || e == a) 
        {
            while(e == b || e == c || e == d || e == a)
            {
                e = (char)(r.nextInt(5) + 'A');
            }
       }
      
        ArrayList<Character> respos = new ArrayList<>();
              respos.add(a);
              respos.add(b);
              respos.add(c);
              respos.add(d);
              respos.add(e);
        
            
            
        return respos;
        
        }
}


