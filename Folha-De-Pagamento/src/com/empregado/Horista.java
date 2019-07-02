package com.empregado;

import java.util.Scanner;

public class Horista extends Empregado {
	
	Scanner input = new Scanner(System.in);
	
	
	public Horista(int numeroEmpregado, String nome, String endereco, int metodoPagamento, int isSindicato, int tipo) {
		super(numeroEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo);
	}
	
	// Agenda Padrão
	private int frequencia = 1;
	private int diaSemana = 5;
	private String agenda = "Semanal - Padrão" + "	 Frequência: A cada " + this.frequencia + " semana(s)" + "	 Dia da semana: " + this.diaSemana;

	// Salário
	private double salarioHorista = 0;
	private double salarioHora = 0;
	
	@Override
	public void salario() {
		System.out.print("\nInforme o salário por hora trabalhada:\nExemplo: 1.5 - 3\nR$ ");
		double salarioTemp = input.nextDouble();
		input.nextLine();
		
		this.salarioHora = salarioTemp;
		
	}
	
	public void cartaoPonto() {	
		
		System.out.println("\nHorário Entrada:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
		int cartaoPontoE = input.nextInt();
		
		System.out.println("\nHorário Saída:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
		int cartaoPontoS = input.nextInt();
		
		// Calcula o salário
		this.salarioHorista = salarioHorista + (calculaSalario(salarioHora, cartaoPontoE, cartaoPontoS));
		
		System.out.println("\nCartão de Ponto registrado com sucesso!\n");		
	}
	
	// Calcula o salário de acordo com o cartão ponto
	public static double calculaSalario(double salarioHora, int entrada, int saida) {
		double salario;
		
		int horaTrabalhada = saida - entrada;
		float minutos = horaTrabalhada % 100;
		
		if (horaTrabalhada <= 800) {
		
			if (minutos < 10) {
				minutos = minutos / 10;
			} else {
				minutos = minutos / 100;
			}
			
			salario = ((horaTrabalhada / 100) * salarioHora) + (minutos * salarioHora);
		} else {
			int horaExtra = horaTrabalhada - 800;
			
			if (minutos < 10) {
				minutos = minutos / 10;
			} else {
				minutos = minutos / 100;
			}
			
			salario = (8 * salarioHora + ((horaExtra / 100) * (salarioHora * 1.5)) + (minutos * (horaExtra * 1.5)));
			
		}
		
		return salario;
	}
	
	//======================================= Get/Set =================================================

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}
	
	public double getSalarioHorista() {
		return salarioHorista;
	}
	
	@Override
	public String toString() {
		String string;
		
		string = super.toString();
		
		string += "Tipo: Horista		Salário Hora: R$ " + this.salarioHora;
		string += "\n--------------------------------------------------------------------------------------------------------\n";
		string += "Agenda de Pagamento: " + this.agenda;
		string += "\n________________________________________________________________________________________________________\n";
		string += "Salário Líquido: R$ " + salarioHorista;
		
		return string;
	}

}