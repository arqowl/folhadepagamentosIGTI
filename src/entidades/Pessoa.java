package entidades;

public abstract class Pessoa {
	
	//Atributos[
	String nome;
	String matricula;
	double salarioBruto;

	
	
	//Construtores
	public Pessoa(String nome, String matricula, double salarioBruto) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.salarioBruto = salarioBruto;
	}
	
	public Pessoa() {
		
	}


	
	//Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	
	
	//Métodos

}