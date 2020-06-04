
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
        System.out.print("| Opção 4 - Instruções        |\n");
        System.out.print("| Opção 5 - Sair              |\n");
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
                 System.out.println("Este RPG foi produzido por:  ");
                 System.out.println("João Pedro Santos Costa, Turma B");
                 
                 break;
                 
             case "4":
                 System.out.println("O jogo é bem simples, basta escolher sua Classe\n"
                         + "e responder as perguntas. Com o decorrer do jogo, você ira ganhar ou perder pontos.\n"
                         + "A Classe te ajuda de acordo com sua escolha. Você pode ganhar Bonus de pontuação\n"
                         + "poderá responder errar ate 2 perguntas sem perder pontos, na outra poderá pular 1 fase. \n"
                         + "No final do jogo, será apresentado um arquivo com o nome de Todos jogadores, pontuação, e o Tempo levado");
                 break;
                 
             case "5":
                 System.out.println("Sair ");
                 
                 
                 break;
                 
             default:
                 System.out.println("Opção Invalida!");
                 
                 
                 
        } 
        
        }while (opcao.equals("5") == false);
    }
    static void InformacaoUsu()
        {
            String nome = "", Classes = "";
            String Pontuador = "Pontuador";
            String Errar = "Errar";
            
            
            System.out.println("Antes começar o jogo, informe o seu nome: \n");
            nome = scan.next();
            
            System.out.println("\n" + nome + " Agora escolha uma Classe desejada. Você tem 2 opções: \n"
               + Pontuador + " 1) ---> Quando você acerta 3 perguntas, recebe um bonus de 300 pontos\n"
               + Errar + " 2) ---> Caso você erre 3 vezes, não perderá pontos, e ainda ganhará 50 pontos");
            
            do
            {
                Classes = scan.next();
                
                if (Classes.equals("1")) 
                {
                     Classes = Pontuador;
                     
                      break;
                }
                else if (Classes.equals("2")) 
                {
                     Classes = Errar;
                     break;
                }
                else
                {
                    System.out.println("Opcão invalida");
                }
                
               
             }while (Classes.equals("1") == false || Classes.equals("2") == false); 
            
            
           
           long segundos = 0;
           
           long start = System.currentTimeMillis();
           
           System.out.println("Prepare- se, o Relogio vai começar a contar\n"
                   + "Prove que você é um progrador acima da média!"
                   + "\nnós precisamos de você \n ");
            
            do 
            {
              long end = System.currentTimeMillis(); 
                
              long tempo = end - start;
                
              segundos = ( tempo / 1000 ) % 60;
                 
            } while (segundos < 1);
             
            
            Jogo(nome, Classes);
        }
        
    static void Jogo (String nome, String Classe)
        {
         Scanner scan = new Scanner (System.in);
              
         int pontos = 0;
         int pontuador = 0;
         int erro = 0;
                    
                    
         int [] aleatorio;
         aleatorio = GerarAleatorio();
        
         long start = System.currentTimeMillis();
        
         for (int i = 0; i < aleatorio.length; i++) 
         {
             System.out.println((i + 1) + ") " + MostrarPergunta (aleatorio[i]));
             
             
             String Certa = Correta(aleatorio[i]);
             
             
             System.out.println("Informe sua resposta: \n");
             String opcao = scan.next();
            
            
             if (opcao.equals(Certa)) 
             {
                pontuador++;
                if (Classe.equals("Pontuador")) 
                 {
                    pontos = pontos + 100;
                    
                    System.out.println("Parabens você acertou!: " + pontos + "\n");
                     

                    if(pontuador == 3)
                     {
                         
                       pontos = pontos + 300;
                   
                       System.out.println("Parabens você acertou, e ganhou um Bonus de 300 pontos. Seus Pontos: " + pontos + "\n");
               
                                
                       pontuador = 0;
                    }
                }
                else
                {
                     pontos = pontos + 100;
                     System.out.println("Parabens você acertou. Seus pontos: " + pontos + "\n");
                        
                }    
             }
                 
              else if (opcao.equals(Certa) == false) 
              {
                 erro++;
                   
                  if (Classe.equals("Errar")) 
                  {
                      if(erro == 3)
                        {
                              pontos = pontos + 50;
                        
                              System.out.println("Infelizmente Você errou. Mas acomulou 3 erros e recebeu um bonus de 50 pontos: " + pontos + "\n");
                                   
                    
                              erro = 0;
                        }
                      
                  }
                  else
                      {
                          pontuador = 0;
                          
                          pontos = pontos - 100; 
                          System.out.println("Que pena vc errou, Seus pontos atuais: " + pontos + "\n");
                                
                      }
                 
               }
         }
         
         long end = System.currentTimeMillis();
        
         tempo(start, end, nome, pontos, Classe);
         
        }
      
    static int pergu = 7;
    
    static String MostrarPergunta(int pergunta)
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
        
        for (int i = 0; i < 500; i++) 
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
        
        VetorDePerguntas[0] = "Teste 1:\n";
        
        VetorDePerguntas[1] = "teste 2:\n";
        
        VetorDePerguntas[2] = "teste 3:\n";
        
        VetorDePerguntas[3] = "teste 4:\n";
         
        VetorDePerguntas[4] = "teste 5:\n";
        
        VetorDePerguntas[5] = "teste 6: \n";
        
         VetorDePerguntas[6] = "teste 6: \n";
    
    
      
        
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
        
        
        MatrizOpcao [4][0] = "A) Tudo que está entre ( ) ";
        MatrizOpcao [4][1] = "B) Tudo que está entre {} ";
        MatrizOpcao [4][2] = "C) Tudo que está entre [ ] ";
        MatrizOpcao [4][3] = "D) Tudo que está entre";
        MatrizOpcao [4][4] = "E) Tudo que está no mesmo nível de indentação";
        
        MatrizOpcao [5][0] = "A) Tudo que está entre ( ) ";
        MatrizOpcao [5][1] = "B) Tudo que está entre {} ";
        MatrizOpcao [5][2] = "C) Tudo que está entre [ ] ";
        MatrizOpcao [5][3] = "D) Tudo que está entre";
        MatrizOpcao [5][4] = "E) Tudo que está no mesmo nível de indentação";
        
        MatrizOpcao [6][0] = "A) Tudo que está entre ( ) ";
        MatrizOpcao [6][1] = "B) Tudo que está entre {} ";
        MatrizOpcao [6][2] = "C) Tudo que está entre [ ] ";
        MatrizOpcao [6][3] = "D) Tudo que está entre";
        MatrizOpcao [6][4] = "E) Tudo que está no mesmo nível de indentação";
        
        
    
 
        
        for (int i = 0; i < 5; i++)  
        {
            vetorOpcao[i] = MatrizOpcao[pergunta][i]; 
        }
        
         return vetorOpcao;       
    }
    static  String Correta (int pergunta)
    {
        String [] Corretas = new String [pergu];
        
        Corretas[0] = "B";
        Corretas[1] = "B";
        Corretas[2] = "B";
        Corretas[3] = "B";
        Corretas[4] = "B";
        Corretas[5] = "B";
        Corretas[6] = "B";
      
      
    
        return Corretas[pergunta];
   }
                                    
    static long tempo(long start, long end, String nome, int pontos, String classe)
        {
             long tempo = end - start;
             
             long minutos  = ( tempo / 60000 ) % 60;
             long segundos = ( tempo / 1000 ) % 60;
             
             
            System.out.println( String.format( "Seu tempo foi: " + "%02d:%02d", minutos,segundos ) );
            
            Ranking(nome, minutos, segundos, pontos, classe);
            
            FeedBack(nome, pontos);
                
            
            return minutos;
        }
    
    static void FeedBack(String nome, int pontos)
    {
           long segundos = 0;
           
           long start = System.currentTimeMillis();
           
           System.out.println("PARABÉNS " + nome + " VOCÊ TERMINOU DE RESPONDER TODAS AS PERGUNTAS DO NOSSO REINO!\n"
                   + "Não importa seu resultado, o importante é sempre estudar e se manter focado\n");
            
           if (pontos < 350) 
           {
               System.out.println("\nSua pontuação final foi: " + pontos + " Procure melhorar mais alguns comandos, como: \n"
                       + "Repetição \n"
                       + "Função \n"
                       + "Condição\n"
                       + "E O PRINCIPAL: Sua Lógica :)");
           }
           else if (pontos > 350 && pontos < 500 )
           {
               System.out.println("\nVocê foi muito bem na pontuação " + nome + " Com um total de " + pontos +" pontos.\n "
                       + "Mas isso não quer dizer nada! Busque sempre estudar");
           }
           
           else if (pontos >= 500 && pontos < 600)
           {
               System.out.println("\nUau, muito bem!! " + nome + " Com um total de " + pontos +" pontos.\n "
                       + "Mas isso não quer dizer nada! Nunca se dê o luxo de parar de estudar!!");
           }
           else if (pontos >= 600 && pontos <= 700)
           {
               System.out.println("\nCom Certeza você está entre os melhores, muito bem!! " + nome + " Com um total de " + pontos +" pontos!!.\n"
                       + "Mas isso não quer dizer nada! Nunca se dê o luxo de parar de estudar!! E ajudar seus colegas\n"
                       + "Nós temos orgulho de ter você fazendo parte de nosso reino!");
           }
           else 
               System.out.println("Alem de ser um Programador estudioso e focado, e conseguiu ganhar mais pontos, Escolhendo a Classe que dava mais pontos \n"
                       + "seu resultado final: " + pontos + "Não perca o foco e a vontade de estudar. e Não se esqueça de ajudar os amigos!!\n"
                               + "Nós temos orgulho de ter você fazendo parte de nosso reino!");
           
           
            do 
            {
              long end = System.currentTimeMillis(); 
                
              long tempo = end - start;
                
              segundos = ( tempo / 1000 ) % 60;
                 
            } while (segundos < 10);
            
           
            
            
            System.out.println("\nDeseja ver o Ranking " + nome + "? Compare seu resultado com outros Programadores!\n"
                        + "1) Ver o Ranking\n"
                        + "2) Não" );
                
                
                String opcao = scan.next();
                
                if (opcao.equals("1")) 
                {
                    VerR();
                }
                else 
                {
                    System.out.println("Pressione 5 para sair OU 1 para voltar a jogar");
                }
   
    
    
    
    
    
    }
   static void Ranking(String nome, long minutos, long segundos, int pts, String classe)
        {
           try
            { 
              FileOutputStream arquivo = new FileOutputStream("ranking.txt", true); //criação do arquivo
                   
              PrintWriter pr = new PrintWriter(arquivo); //criar para escrever no arquivo
                    
              pr.println("Nome: " + nome +" \n"
                       + " Classe Escolhida: " + classe + "\n" 
                       + " Minutos: " + minutos + " Segundos: " + segundos +  "\n"
                       + " Pontuação final: "+ pts + "\n" + "\n");  //Escrita no Arquivo
                     
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


