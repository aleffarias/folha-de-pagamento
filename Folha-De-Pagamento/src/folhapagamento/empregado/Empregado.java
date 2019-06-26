package folhapagamento.empregado;

import java.util.Scanner;

public abstract class Empregado {
	private int numeroEmpregado;
	private String nome;
	private String endereco;
	private int tipo;
	private int metodoPagamento;
	private int isSindicato = 0;

	Sindicato sindicato = new Sindicato();
	
	 static Scanner input = new Scanner(System.in);
	
	// Construtor
	public Empregado(int numeroEmpregado, String nome, String endereco, int tipo, int metodoPagamento, int isSindicato) {
		this.numeroEmpregado = numeroEmpregado;
		this.nome = nome;
		this.endereco = endereco;
		this.tipo = tipo;
		this.metodoPagamento = metodoPagamento;
		this.isSindicato = isSindicato;
	}
	
	public void alterarDetalhes(int opcao) {
		switch(opcao) {
		case 1:
			System.out.println("Digite o nome do empregado:");
			 String nome = input.nextLine();
			
			 setNome(nome);
			 
			break;
		
		case 2:
			 System.out.println("\nDigite o endereço do empregado:");
			 String endereco = input.nextLine();
			
			 setEndereco(endereco);
			 
			break;
		
		case 3:
			System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
			int metodoPagamento = input.nextInt();
			input.nextLine();
			 
			setMetodoPagamento(metodoPagamento);			
			
			break;
		
		case 4:
			System.out.println("\nPertence ao sindicato?\n(1) - Sim\n(0) - Não");
			int isSindicato = input.nextInt();
			input.nextLine();
			
			setIsSindicato(isSindicato);
			
			if (isSindicato == 1) {
			  System.out.print("Digite o valor da taxa sindical:\nR$ ");
			  double taxaSindical = input.nextDouble();
			  input.nextLine();
			  
			  sindicato.setNumeroSindicato(getNumeroEmpregado());
			  sindicato.setTaxaSindical(taxaSindical);
			  
			  setNumeroEmpregado(getNumeroEmpregado() + 1);
			}
			
			break;
		}
	}
	
	public abstract void salario();

	
	//======================================= Get/Set =================================================
	
	public int getNumeroEmpregado() {
		return this.numeroEmpregado;
	}
	
	public void setNumeroEmpregado(int numeroEmpregado) {
		this.numeroEmpregado = numeroEmpregado;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	public int getMetodoPagamento() {
		return this.metodoPagamento;
	}
	
	public void setMetodoPagamento(int metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	
	
	public int getIsSindicato() {
		return this.isSindicato;
	}
	
	public void setIsSindicato(int isSindicato) {
		this.isSindicato = isSindicato;
	}
	
	
	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}
	
}