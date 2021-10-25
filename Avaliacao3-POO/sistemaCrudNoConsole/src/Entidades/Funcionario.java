package Entidades;

public class Funcionario {
	
	private int id;
	private String nomeDoFuncionario;
	private double salarioDoFuncionario;
	
	// Construtores
	public Funcionario() {
	}
	public Funcionario(int id, String nomeDoFuncionario, double salarioDoFuncionario) {
		super();
		this.id = id;
		this.nomeDoFuncionario = nomeDoFuncionario;
		this.salarioDoFuncionario = salarioDoFuncionario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNomeDoFuncionario() {
		return nomeDoFuncionario;
	}
	public void setNomeDoFuncionario(String nomeDoFuncionario) {
		this.nomeDoFuncionario = nomeDoFuncionario;
	}
	
	public double getSalarioDoFuncionario() {
		return salarioDoFuncionario;
	}
	public void setSalarioDoFuncionario(double salarioDoFuncionario) {
		this.salarioDoFuncionario = salarioDoFuncionario;
	}
	
	// Regra de negocio - Aumentar o salario do funcionario 
	public void aumentarSalario(Double percentual) {
		salarioDoFuncionario = salarioDoFuncionario + (salarioDoFuncionario * percentual / 100.0);
	}
	// ToString pra impressao na lista
	public String toString() {
		return getId() + ", " + getNomeDoFuncionario() + ", " + String.format("%.2f", getSalarioDoFuncionario());
	}
	
}
