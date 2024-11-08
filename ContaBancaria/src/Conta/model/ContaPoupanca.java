package conta.model;

public class ContaPoupanca extends Conta {
	private int aniversarioDaConta;
	float juros;
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular,float saldo,int aniversarioDaConta) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversarioDaConta = aniversarioDaConta;
	}

	public int getDataAniversario() {
		return aniversarioDaConta;
	}

	public void setDataAniversario(int aniversarioDaConta) {
		this.aniversarioDaConta = aniversarioDaConta;
	}
	
	@Override
		public void visualizar() {
			super.visualizar();
			System.out.println("Aniversário da conta "+ this.aniversarioDaConta);
	}

}
