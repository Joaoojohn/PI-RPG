
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
    
    //Menu
    public static void main(String[] args) 
    {
        String opcao;
        
           long segundos = 0;
           
           // Cronometro para aparecer a mensagem durante 4 segundos
           long start = System.currentTimeMillis();
           
           
            System.out.print("*****Olá! Seja bem vindo ao Reino Hello World! Prove que você é um dos melhores Programadores!!*****\n\n");
            
            do 
            {
              long end = System.currentTimeMillis(); 
                
              long tempo = end - start; //pega o tempo de inicio do contador e subtrai pelo final dele
                
              segundos = ( tempo / 1000 ) % 60; // Converte os Millis Segundos em Segundos
                 
            } while (segundos < 4); // Condição do Cronometro
             
        
        //Menu com opção de jogar, Creditos, Instruções, Ver o Ranking e Sair
         
      
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
    
    
    
    //Informação do Usuário
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
            
            
           // Cronometro para aparecer a mensagem durante 5 segundos
           long segundos = 0;
           
           long start = System.currentTimeMillis();
           
           System.out.println("Prepare- se, o Relogio vai começar a contar\n"
                   + "Prove que você é um progrador acima da média!"
                   + "\nnós precisamos de você \n ");
            
            do 
            {
              long end = System.currentTimeMillis(); 
                
              long tempo = end - start; //pega o tempo de inicio do contador e subtrai pelo final dele
                
              segundos = ( tempo / 1000 ) % 60; // Converte os Millis Segundos em Segundos
                 
            } while (segundos < 5); // Condição do Cronometro
             
            
            Jogo(nome, Classes); //Chama a função de jogar 
        }
        
    
    //Aonde o Jogo acontece
    static void Jogo (String nome, String Classe)
        {
         Scanner scan = new Scanner (System.in);
              
         int pontos = 0;
         int pontuador = 0;
         int erro = 0;
                    
                    
         int [] aleatorio; // cria um vetor para pegar a resposta da função de Gerar Perguntas Aleatórias 
         aleatorio = GerarAleatorio(); // Pega a Reposta da função
        
         long start = System.currentTimeMillis(); // inicia o Cronometro do Jogo
        
         for (int i = 0; i < aleatorio.length; i++)  // Para cada cada pergunta Aleatoria do tamanho total de perguntas(7) ele chama a pergunta montada e compara as respostas do usario 
         {                                          // com a função que tem todas as perguntas certas
             
             System.out.println((i + 1) + ") " + MostrarPergunta (aleatorio[i]));  //chama a função que monta a pergunta, passando o numero da pergunta (gerado aleatoriamente) 
             
             String Certa = Correta(aleatorio[i]); // pega a resposta correta de acordo com o numero com o numero da pergunta
             
             System.out.println("Informe sua resposta: \n");
             String opcao = scan.next();
            
             if (opcao.equals(Certa))  // compara a resposta do usuario com a Resposta correta guardada na função "Correta"
             {                        // marca os pontos de acordo com a Classe escolhida pelo jogador 
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
         
         long end = System.currentTimeMillis(); //Encerra o Cronometro do jogador
        
         tempo(start, end, nome, pontos, Classe); //manda para a função Tempo, para calcular os minutos e segundos do usuario 
         
        }
      
    static int pergu = 7; // total de perguntas existente dentro do jogo
    
     //Monta a pergunta
    static String MostrarPergunta(int pergunta)
    {
        String montada = "";
        
        montada = montada + Perguntas(pergunta); //pega as perguntas na função de Perguntas, contatena com a String montada
        montada  = montada + "\n";
        
        String [] opcoes = Opcoes(pergunta); //pega as opções de acordo com a numeração da pergunta 
        
        for (int i = 0; i < opcoes.length; i++) 
        {
             montada  = montada + (opcoes[i] + "\n"); //monta as opções com as perguntas com as respectivas numeração 
        }
         montada  = montada + "\n";
         montada  = montada + "\n";
        
        return montada;
        
    }
    
    //gerar as perguntas aleatorias 
     static int [] GerarAleatorio()
    {
        Random gerar = new Random();
        int [] Aleatorio = new int [pergu]; // Cria um Vetor com o tamanho de quantidade de perguntas
        
        
        int pos1, pos2, auxilio; 
        
        for (int i = 0; i < Aleatorio.length; i++) 
        {
            Aleatorio[1] = i ; // preenche o vetor
        }
        
        for (int i = 0; i < 1000; i++)  //Quantidade de vezes que as perguntas serão embaralhadas 
        {
            pos1 = gerar.nextInt(Aleatorio.length);
            pos2 = gerar.nextInt(Aleatorio.length);
            //troca 
            auxilio = pos1; //guarda o valor da posição 1
            
            Aleatorio [pos1] = Aleatorio[pos2]; //troca o valor de 1 para 2
            
            Aleatorio[pos2] = auxilio; //troca o valor de 2 para o valor que estava na 1
        }
        
        
        return Aleatorio;  
    }
     
     
     //perguntas
     static String Perguntas (int perguntas)
    {
        String [] VetorDePerguntas = new String [pergu]; //cria um vetor com o tamanho de perguntas
        
        //para cada indice do Vetor, é colocado uma pergunta
        
        VetorDePerguntas[0] = "Em Java, um bloco de código é:\n";
        
        VetorDePerguntas[1] = "Em uma aplicação Java, um vetor n foi criado por meio da instrução double n=new double [ 3 ] ; \n"
                + "e alimentado com 3 valores reais. \n"
                + "Para exibir o conteúdo da segunda posição (índice) deste vetor utiliza-se a instrução 2:\n";
        
        VetorDePerguntas[2] = "Qual valor uma função VOID retorna?\n";
        
        VetorDePerguntas[3] = "Qual o unico código correto?\n";
         
        VetorDePerguntas[4] = "Quando se deve usar o FOR ou WHILE?\n";
        
        VetorDePerguntas[5] = "Quando devo usar o 'Else If'? \n";
        
        VetorDePerguntas[6] = "Quando vamos chamar um Objeto pela primeira vez, depois do sinal de '=' devemos colocar:   \n";
    
    
      
        
        return  VetorDePerguntas [perguntas];       
    }

     
      //Opções 
      static String [] Opcoes(int pergunta)
    {
        String [] vetorOpcao = new String [5]; //cria um vetor de acordo com a quantidade de opções (a,b,c,d,e)
        
        String [][] MatrizOpcao = new String [pergu] [5]; // cria uma matriz com a quantidade d perguntas, e quantidade de opções (5)
        
        
        //para cada pergunta, e adicionado uma opção. o Primeiro indice da Matriz, é o numero da pergunta, o segundo, são as opções
        MatrizOpcao [0][0] = "A) Tudo que está entre ( ) ";
        MatrizOpcao [0][1] = "B) Tudo que está entre { } ";
        MatrizOpcao [0][2] = "C) Tudo que está entre [ ] ";
        MatrizOpcao [0][3] = "D) Tudo que está entre";
        MatrizOpcao [0][4] = "E) Tudo que está no mesmo nível de indentação";
        
        MatrizOpcao [1][0] = "A) System.out.println{n(1)}";
        MatrizOpcao [1][1] = "B) System.out.Format(n[1])";
        MatrizOpcao [1][2] = "C) JOptionPane.ShowWindows(0, n[2])";
        MatrizOpcao [1][3] = "D) System.out.println(n[1])";
        MatrizOpcao [1][4] = "E) JOptionPane.showMessageDialog(null,n[2])";
        
        
        MatrizOpcao [2][0] = "A) Um valor aleatório";
        MatrizOpcao [2][1] = "B) Int ";
        MatrizOpcao [2][2] = "C) Nenhum";
        MatrizOpcao [2][3] = "D) String";
        MatrizOpcao [2][4] = "E) Void não existe";
        
        MatrizOpcao [3][0] = "A) static void Funcao(int n1, int n2)\n"
                + "{\n"
                + "int total = n1 + n2; \n"
                + "return total;\n"
                + "}\n";
        MatrizOpcao [3][1] = "B) static void Funcao()\n"
                + "int total = n1 + n2; \n";
        MatrizOpcao [3][2] = "C) static void Funcao(int n1, int n2)\n"
                + "int total = n1 + n2;\n"; 
        MatrizOpcao [3][3] = "D) static void Funcao(int n1, int n2)\n"
                + "{\n"
                + "int total = n1 + n2;\n"
                + "}";
        
        MatrizOpcao [3][4] = "E) static int Funcao(int n1, int n2)\n"
                + "int total = n1 + n2;\n";
        
        
        MatrizOpcao [4][0] = "A) Utiliza- se  o for quando sabe a quantidade de vezes que irá repetir, e o while quando você não sabe exatamente mas tem uma condição de parada.";
        MatrizOpcao [4][1] = "B) Tanto faz";
        MatrizOpcao [4][2] = "C) Os 2 fazem a mesma coisa";
        MatrizOpcao [4][3] = "D) O While se usa quando não sabe quando vai parar, ja o For, não precisa disso";
        MatrizOpcao [4][4] = "E) o For só é usado para incrementar Vetores e Matrizes, já o While serve para tudo";
        
        MatrizOpcao [5][0] = "A) Qualquer hora";
        MatrizOpcao [5][1] = "B) Coloca- se normalmente depois do Else ";
        MatrizOpcao [5][2] = "C) Não se pode usar esse comando";
        MatrizOpcao [5][3] = "D) O correto a se utilizar o 'If Else'";
        MatrizOpcao [5][4] = "E) Quando se existe mais de uma condição possivel";
        
        MatrizOpcao [6][0] = "A) new ";
        MatrizOpcao [6][1] = "B) o nome do Objeto ";
        MatrizOpcao [6][2] = "C) Passar os parametros";
        MatrizOpcao [6][3] = "D) NEW";
        MatrizOpcao [6][4] = "E) Throw new argument execepcion";
        
        
    
 
        
        for (int i = 0; i < 5; i++)   
        {
            vetorOpcao[i] = MatrizOpcao[pergunta][i];  // pega somente a opção da Matriz, e armazena no Vetor 
        }
        
         return vetorOpcao;       
    }
    
    //Respostas Corretas  
    static  String Correta (int pergunta)
    {
        String [] Corretas = new String [pergu]; //Cria um Vetor com o tamanho de quantidade das perguntas 

        //Cada indice do Vetor, é o numero da pergunta, e é atribuida uma letra correta
        Corretas[0] = "b";
        Corretas[1] = "d";  
        Corretas[2] = "c";
        Corretas[3] = "d";
        Corretas[4] = "a";
        Corretas[5] = "e";
        Corretas[6] = "a";

        return Corretas[pergunta];
   }
               
    //Tempo
    static long tempo(long start, long end, String nome, int pontos, String classe)
        {
             long tempo = end - start; //faz o calculo subtraindo o inicio e o fim  
             
             long minutos  = ( tempo / 60000 ) % 60; //converte os milli segundos em Minutos
             long segundos = ( tempo / 1000 ) % 60; //converte os milli segundos em Segundos
             
             
            System.out.println( String.format( "Seu tempo foi: " + "%02d:%02d", minutos,segundos ) );
            
            Ranking(nome, minutos, segundos, pontos, classe); // passa o tempo e os dados do usuario para a o Ranking 
            
            FeedBack(nome, pontos); // chama a Função FeedBack para o usuario
                
            return minutos;
        }
    
    
    //FeedBack
    static void FeedBack(String nome, int pontos)
    {
           long segundos = 0;
           
           long start = System.currentTimeMillis(); // inicia o Cronometro que as mensagens ficaram na tela 
           
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
               System.out.println("Alem de ser um Programador estudioso e focado, conseguiu ganhar mais pontos, Escolhendo a Classe que dava mais pontos \n"
                       + "seu resultado final: " + pontos + " Não perca o foco e a vontade de estudar. e Não se esqueça de ajudar os amigos!!\n"
                               + "Nós temos orgulho de ter você fazendo parte de nosso reino!");
           
           
            do 
            {
              long end = System.currentTimeMillis(); 
                
              long tempo = end - start;
                
              segundos = ( tempo / 1000 ) % 60;
                 
            } while (segundos < 10); //Conndição do Cronometro 
            
           
            
            
            System.out.println("\nDeseja ver o Ranking " + nome + "? Compare seu resultado com outros Programadores!\n" // Vê qual vai ser a proxima ação do Usuario
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
    
    //Ranking
   static void Ranking(String nome, long minutos, long segundos, int pts, String classe)
        {
           try //tenta salvar o arquivo
            { 
              FileOutputStream arquivo = new FileOutputStream("ranking.txt", true); //Cria um arquivo de texto 
                   
              PrintWriter pr = new PrintWriter(arquivo); // Chama o objeto que ira escrever no arquivo 
                    
              pr.println("Nome: " + nome +" \n"
                       + " Classe Escolhida: " + classe + "\n" 
                       + " Minutos: " + minutos + " Segundos: " + segundos +  "\n"
                       + " Pontuação final: "+ pts + "\n" + "\n");  //Essas informações ficaram salvas no Arquivo
                     
              pr.flush(); //Manda o Salvar no HD, sem ficar em buffer (em espera)
              pr.close(); //fecha o PrintWriter
              arquivo.close();//fecha o arquivo 
              
            }
            catch(Exception io)//Caso ocorra um erro ao salvar o arquivo, está mensagem é apresentada
            {   
              System.out.println("Erro ao gravar resultado do Ranking");
            }
        }

   
   //ver o Ranking 
   static void VerR ()
        {
            try //tenta ler o arquivo
            {
                FileInputStream arquivo = new FileInputStream("ranking.txt"); //Chama o arquivo desejado
                InputStreamReader input = new InputStreamReader(arquivo); //Chama o objeto que ira ler o Arquivo
                
                BufferedReader br = new BufferedReader(input);
                
                String linha;
                
                do {
                    linha = br.readLine(); 
                    
                    if (linha != null) 
                    {
                        System.out.println(linha);
                    }
                } while (linha != null); // Lê cada linha do arquivo e exibe para o usuario enquanto tiver conteudo para ser lido
            }
            catch(Exception e) //caso ocorra um erro ao ler o arquivo essa mensagem é exibida
            {
                System.out.println("Falha ao ver Ranking");
            }
        
        }
}


