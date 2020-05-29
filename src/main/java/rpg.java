
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            
       
            VerR();
            
            Jogo(nome, Classes);
        }
        
        static void Jogo (String nome, String Classe)
        {
         int pontos = 0;
         int [] aleatorio;
         aleatorio = GerarAleatorio();
         Scanner scan = new Scanner (System.in);
        
         long start = System.currentTimeMillis();
        
         for (int i = 0; i < aleatorio.length; i++) 
         {
             
             System.out.println((i + 1) + ") " + MonstrarPergunta (aleatorio[i]));
             
             System.out.println("Informe sua resposta: ");
             String opcao = scan.next();
             
             Correta(i, opcao, pontos);
             
         }
         long end = System.currentTimeMillis();
        
         long t = tempo(start, end);
         
            
        Ranking(nome,t, pontos);
        
        }
      
         static int pergu = 4;
    
    static String MonstrarPergunta(int pergunta)
    {
        String montada = "";
        
        montada = montada + Perguntas(pergunta); //pega as perguntas
        montada  = montada + "\n";
        
        String [] opcoes = Opcoes(pergunta); //pega as opções 
        
        for (int i = 0; i < opcoes.length; i++) 
        {
             montada  = montada + (opcoes[i] + "\n"); //monta as opções
        }
         montada  = montada + "\n";
         montada  = montada + "\n";
        
        return montada;
        
    }
     static int [] GerarAleatorio()
    {
        Random gerar = new Random();
        int [] Aleatorio = new int [pergu];
        
        
        int pos1, pos2, auxilio;
        
        for (int i = 0; i < Aleatorio.length; i++) 
        {
            Aleatorio[1] = i ;
        }
        
        for (int i = 0; i < 10; i++) 
        {
            pos1 = gerar.nextInt(Aleatorio.length);
            pos2 = gerar.nextInt(Aleatorio.length);
            //troca 
            
            auxilio = pos1;
            
            Aleatorio [pos1] = Aleatorio[pos2];
            
            Aleatorio[pos2] = auxilio;
        }
        
        
        return Aleatorio;  
    }
     static String Perguntas (int perguntas)
    {
        String [] VetorDePerguntas = new String [pergu];
        
        VetorDePerguntas[0] = "Em ii, um bloco de código é:";
        
        VetorDePerguntas[1] = "Em ii, um bloco de código é:";
        
        VetorDePerguntas[2] = "Em ii, um bloco de código é:";
        
        VetorDePerguntas[3] = "Em ii, um bloco de código é:";
         
        
        
        return  VetorDePerguntas [perguntas];       
    }
    
      static String [] Opcoes(int pergunta)
    {
        String [] vetorOpcao = new String [5];
        
        String [][] MatrizOpcao = new String [pergu] [5];
        
        MatrizOpcao [0][0] = "A) Tudo que está entre ( ) ";
        MatrizOpcao [0][1] = "B) Tudo que está entre {} ";
        MatrizOpcao [0][2] = "C) Tudo que está entre [ ] ";
        MatrizOpcao [0][3] = "D) Tudo que está entre";
        MatrizOpcao [0][4] = "E) Tudo que está no mesmo nível de indentação";
        
        MatrizOpcao [1][0] = "A) Tudo que está entre ( ) ";
        MatrizOpcao [1][1] = "B) Tudo que está entre {} ";
        MatrizOpcao [1][2] = "C) Tudo que está entre [ ] ";
        MatrizOpcao [1][3] = "D) Tudo que está entre";
        MatrizOpcao [1][4] = "E) Tudo que está no mesmo nível de indentação";
        
        
        MatrizOpcao [2][0] = "A) Tudo que está entre ( ) ";
        MatrizOpcao [2][1] = "B) Tudo que está entre {} ";
        MatrizOpcao [2][2] = "C) Tudo que está entre [ ] ";
        MatrizOpcao [2][3] = "D) Tudo que está entre";
        MatrizOpcao [2][4] = "E) Tudo que está no mesmo nível de indentação";
        
        MatrizOpcao [3][0] = "A) Tudo que está entre ( ) ";
        MatrizOpcao [3][1] = "B) Tudo que está entre {} ";
        MatrizOpcao [3][2] = "C) Tudo que está entre [ ] ";
        MatrizOpcao [3][3] = "D) Tudo que está entre";
        MatrizOpcao [3][4] = "E) Tudo que está no mesmo nível de indentação";
        
 
        
        for (int i = 0; i < 5; i++)  
        {
            vetorOpcao[i] = MatrizOpcao[pergunta][i]; 
        }
        
         return vetorOpcao;       
    }
    static  String Correta (int pergunta, String opcao, int pontos)
    {
        String [] Corretas = new String [pergu];
        
        
        Corretas[0] = "B";
        Corretas[1] = "B";
        Corretas[2] = "B";
        Corretas[3] = "B";
        
    
        if (opcao.equals(Corretas[pergunta])) 
        {
            
            System.out.println("Parabens vc ganhou uns pontos, bora continuar \n");
            pontos = pontos + 100;
        }
        else 
        {
            System.out.println("Que pena vc perdeu uns pontos ai \n");
            pontos = pontos - 50;
        }
        
        
        return Corretas[pergunta];
    }
       
    static long tempo(long start, long end)
        {
             long tempo = end - start;
             
             
             long minutos  = ( tempo / 60000 ) % 60;
             long segundos = ( tempo / 1000 ) % 60;
             
             
            
            System.out.println( String.format( "%02d:%02d", minutos,segundos ) );
            
            return minutos;
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


