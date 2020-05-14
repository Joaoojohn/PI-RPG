
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
public class Menu 
{
    public static void main(String[] args) 
    
    {
        Scanner scan = new Scanner(System.in);
        
        String opcao;
        
        System.out.println("Olá! Seja bem vindo ao Reino Hello World! ");
            
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
                 break;
             
             case "2":
                 System.out.println("Bora Jogar! ");

                 break;
             case "3":
                 System.out.println("RPG produzido por: ");
                 System.out.println("João Pedro e Guilherme Piovesan ");
                 
                 break;
        } 
        
        }while (opcao.equals("4") == false);
    
    }
    
}
