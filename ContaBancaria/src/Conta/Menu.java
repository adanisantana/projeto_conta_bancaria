package conta;

import java.util.Scanner;
import conta.util.Cores;
import conta.model.ContaPoupanca;
import conta.model.ContaCorrente;
import java.io.IOException;
import java.util.InputMismatchException;
import conta.controller.ContaController;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
			
		System.out.println("\n Criar contas");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(),123, 1, "João da Silva",1000.0f,100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(),124, 1, "Maria da Silva",2000.0f,100.0f );
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(),125,2, "Mariana dos Santos", 4000.0f,12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(),125, 2,"Juliana Ramos",8000.0f,15);
		contas.cadastrar(cp2);
		
		while (true) {

			System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLUE_BACKGROUND);
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
			} catch (InputMismatchException e) {
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
				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o tipo de conta: ");
					tipo = leia.nextInt();

				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite de crédito: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniversário: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}

				keyPress();
				break;

			case 2:
				System.out.println("Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null ) {
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o número da agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o número do titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					System.out.println("Digite o saldo da conta: ");
					saldo= leia.nextFloat();
					
					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o limite de crédito: ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo,titular, saldo, limite ));
						
					}
					case 2 ->{
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido");
					}
					}
				
					
				}
				else {
					System.out.println("Conta não foi encontrada");
				}
				
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");
				System.out.println("Digite o número da conta:");
				numero = leia.nextInt();
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println("Saque\n\n");
				
				System.out.println("Digite o numero da conta");
				numero = leia.nextInt();
				do {
					System.out.println("Digite o valor do Saque:");
					valor= leia.nextFloat();
				}while(valor<=0);
				contas.sacar(numero, valor);
				keyPress();
				break;
			case 7:
				System.out.println("Depósito\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor do Depósito R$: ");
					valor = leia.nextFloat();
				}while(valor<=0);
				contas.depositar(numero,valor);
				
				keyPress();
				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				System.out.println("Digite o número da conta de Destino: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.println("Digite o valor da Transferência (R$): ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				
				contas.transferir(numero, numeroDestino,valor );
				
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
		System.out.println("*********************************************************");
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter");

		}
	}
}
