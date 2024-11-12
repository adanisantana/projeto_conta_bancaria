package conta.model;

public class ContaCorrente extends Conta {
	float limite;
	float taxaDeManutencao;
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular,float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
		
	}
	 @Override
		public void visualizar() {
			super.visualizar();
		}
	

}
