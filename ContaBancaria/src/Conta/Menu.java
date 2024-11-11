package conta;
import java.util.Scanner; 
import conta.model.Conta;
import conta.util.Cores;
import conta.model.ContaPoupanca;
import conta.model.ContaCorrente;
import java.io.IOException;
import java.util.InputMismatchException;
import conta.controller.*;

public class Menu {
	ContaController contas = new ContaController();

	public static void main(String[] args) {
		
		//Teste da classe conta
		Conta c1 = new Conta(1, 123, 1, "Margarida", 2500.0f);
		c1.visualizar();
		c1.sacar(500);
		c1.visualizar();
		c1.depositar(100);
		c1.visualizar();
		
		
		//Teste da Conta Corrente
		ContaCorrente c2 = new ContaCorrente(2,456,1,"Zilda",1500.0f,200.0f,0.3f);
		c2.visualizar();
		c1.sacar(50);
		c2.visualizar();
		
		ContaPoupanca cp1 = new ContaPoupanca(3,675,2,"Maria",5000.0f,0);
		cp1.visualizar();
		c1.depositar(400);
		
		
		
		Scanner leia = new Scanner(System.in);
		
		int opcao;

		while (true) {
			
			System.out.println(Cores.TEXT_WHITE+ Cores.ANSI_BLUE_BACKGROUND);
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO PROSPERIDADE                   ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");
			
			try { 
				opcao = leia.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("\nDigite valores Inteiros!");
					leia.nextLine();
					opcao = 0;
				}

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
                 leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Criar Conta\n\n");	
					keyPress();
					break;
				case 2:
					System.out.println("Listar todas as Contas\n\n");
					
					keyPress();
					break;
				case 3:
					System.out.println("Consultar dados da Conta - por número\n\n");
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar dados da Conta\n\n");
					keyPress();
					break;
				case 5:
					System.out.println("Apagar a Conta\n\n");
					keyPress();
					break;
				case 6:
					System.out.println("Saque\n\n");
					keyPress();
					break;
				case 7:
					System.out.println("Depósito\n\n");
					keyPress();
					break;
				case 8:
					System.out.println("Transferência entre Contas\n\n");
					keyPress();
					break;
				default:
					System.out.println("\nOpção Inválida!\n");
					keyPress();
					break;
			}
		}
	}
    
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Daniella Santana ");
		System.out.println("Generation Brasil - mariano.dani@hotmail.com");
		System.out.println("github.com/adanisantana");
		System.out.println("*********************************************************");}
	
	public static void keyPress() {
 			try {
 				System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
 				System.in.read();
 				
 			}catch(IOException e){
 				System.out.println("Você pressionou uma tecla diferente de enter");
 			

 			}
	}
	}
 	
 		
