package conta.controller;
import conta.model.Conta;
import conta.repository.ContaRepository;
import java.util.ArrayList;

public class contaController implements ContaRepository {
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	
	
	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarTodas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastrar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void listarTodas() {
		for(var conta:listaContas) {
			conta.visualizar();
		}
	}

}
