
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
         
        System.out.print("*****Olá! Seja bem vindo ao Reino Hello World!*****\n\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("| Opção 1 - Jogar             |\n");
        System.out.print("| Opção 2 - Ranking           |\n");
        System.out.print("| Opção 3 - Créditos          |\n");
        System.out.print("| Opção 4 - Sair              |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("Digite uma opção: ");
        
        
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
                 VerR();

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
         
         int pontos = 0;
        
         
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
                 pontos = 100;
                 
                 break;
                 
             default: 
                 certa = false;
                 System.out.println("Resposta Errada. Tentativa: ");    
         }    
                 
        
        Collections.shuffle(ale);
           
        }while(resp.equals("e") || resp.equals("E")|| resp.equals("a")|| resp.equals("A")||
               resp.equals("B")|| resp.equals("b") || resp.equals("d")|| resp.equals("D"));
       
         long end = System.currentTimeMillis();
           
         
         
         long t = tempo(start, end);
         
       
        Ranking(nome,t, pontos);
       
       VerR();
    }
        
        static long tempo(long start, long end)
        {
             long tempo = end - start;
             
             
             long minutos  = ( tempo / 60000 ) % 60;
             long segundos = ( tempo / 1000 ) % 60;
             
             
            
            System.out.println( String.format( "%02d:%02d", minutos,segundos ) );
            
            return minutos;
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
        
        static void Ranking(String nome,long tempo, int pts)
        {
           try
            { 
              FileOutputStream arquivo = new FileOutputStream("ranking.txt", true); //criação do arquivo
                   
              PrintWriter pr = new PrintWriter(arquivo); //criar para escrever no arquivo
                    
              pr.println("Nome: " + nome + " Tempo: " + tempo + " Pontuação final: "+ pts);  //Escrita no Arquivo
                     
              pr.flush(); //Manda o Salvar no HD, sem ficar em buffer
              pr.close(); //fecha o PrintWriter
          
              arquivo.close();//fecha o arquivo 
            }
            catch(Exception io)
            {   
              System.out.println("Erro ao gravar resultado do Ranking");
            }
        }

        static void VerR ()
        {
            try
            {
                FileInputStream arquivo = new FileInputStream("ranking.txt");
                InputStreamReader input = new InputStreamReader(arquivo);
                
                BufferedReader br = new BufferedReader(input);
                
                String linha;
                
                do {
                    linha = br.readLine();
                    
                    if (linha != null) 
                    {
                        
                        
                        System.out.println(linha);
                       
                    }
                } while (linha != null);
            }
            catch(Exception e)
            {
                System.out.println("Falha ao ver Ranking");
            }
        
        }
}


