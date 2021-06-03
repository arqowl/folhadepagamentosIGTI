package entidades;

import java.util.ArrayList;
import java.util.*;

public class Funcionario extends Pessoa {

	//Atributos
	
	//Construtores
	public Funcionario(String nome, String matricula, double salarioBruto) {
		super(nome, matricula, salarioBruto);
	}
	public Funcionario() {
		super();
	}
	
	//Getters and Setters
	



	//M�todos
	public Funcionario cadastroFuncionario() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("******Voc� est� cadastrando um funcion�rio na empresa******\n");
		System.out.println("Digite o nome do funcion�rio que voc� quer cadastrar");
		String nomeFuncionario = entrada.nextLine();
		System.out.println("Digite o sal�rio bruto do funcion�rio");
		double salarioBrutoFuncionario = entrada.nextDouble();
		System.out.println("Digite a Matr�cula do funcion�rio");
		String matriculaFuncionario = entrada.next();
		
		
		Funcionario funcionario = new Funcionario(nomeFuncionario, matriculaFuncionario, salarioBrutoFuncionario);
		

		return funcionario;
	}
	
	public void consultaFuncionario(ArrayList<Funcionario> funcionarios) {
		System.out.println("******Voc� est� consultando os Funcion�rios cadastrados******");
		if(!funcionarios.equals(null))
			for(int i=0; i<funcionarios.size();i++) {
				System.out.println("�ndice: "+i+". A empresa possui o funcion�rio de nome "
						+funcionarios.get(i).getNome()+" de matr�cula "
						+funcionarios.get(i).getMatricula()+" de sal�rio R$"
						+funcionarios.get(i).getSalarioBruto());
				
			} else{
				System.out.println("N�o existe nenhum Funcion�rio cadastrado");
			}
	}
	
	public double primeiraAliquotaINSS(double salarioBruto) {
		double total = 0;
		double limiteSuperior = 1045.0;
		double primeiraAliquota = 0.075;
		if(salarioBruto <= limiteSuperior) {
			total =  salarioBruto*primeiraAliquota;
		} else if(salarioBruto<0) {
			System.out.println("Sal�rio negativo inv�lido");
			System.out.println(total);
		} else {
			total = limiteSuperior*primeiraAliquota;
		}
		
		return total;
	}
	
	
	public double segundaAliquotaINSS(double salarioBruto) {
		double total = 0;
		double segundaAliquota = 0.09;
		double limiteSuperior = 2089.60;
		double limiteInferior = 1045.01;
		if(salarioBruto <= limiteSuperior&&salarioBruto>=limiteInferior) {
			total = (salarioBruto - limiteInferior)*segundaAliquota;
		} else if(salarioBruto>limiteSuperior) {
			total = (limiteSuperior - limiteInferior)*segundaAliquota;
		}
		return total;
	}
	
	public double terceiraAliquotaINSS(double salarioBruto) {
		double total = 0;
		double limiteInferior = 2089.61;
		double limiteSuperior = 30134.40;
		double terceiraAliquota = 0.12;
		if(salarioBruto <= limiteSuperior&&salarioBruto>=limiteInferior) {
			total = (salarioBruto - limiteInferior)*terceiraAliquota;
		} else if(salarioBruto>limiteSuperior) {
			total = (limiteSuperior - limiteInferior)*terceiraAliquota;
		}
		
		return total;
	}
	
	public double quartaAliquotaINSS(double salarioBruto) {
		double total = 0;
		double limiteInferior = 30134.41;
		double limiteSuperior = 6101.06;
		double quartaAliquota = 0.14;
		if(salarioBruto <= limiteSuperior&&salarioBruto>=limiteInferior) {
			total = (salarioBruto - limiteInferior)*quartaAliquota;
		} else if(salarioBruto>limiteSuperior) {
			total = (limiteSuperior - limiteInferior)*quartaAliquota;
		}
		return total;
	}
	
	public double descontoINSS(double salarioBruto) {
		return primeiraAliquotaINSS(salarioBruto)+segundaAliquotaINSS(salarioBruto)
				+terceiraAliquotaINSS(salarioBruto+quartaAliquotaINSS(salarioBruto));
	}
	
	public double descontoIRRF(double salarioBruto) {
		double total = 0;
		double salarioMenosINSS = salarioBruto - descontoINSS(salarioBruto);
		
		if(salarioMenosINSS<=1903.98) {
			System.out.println("Voc� n�o precisa pagar IRRF");
		} else if(salarioMenosINSS>=1903.99&&salarioMenosINSS<=2826.65) {
			total = salarioMenosINSS*0.075 - 142.80;
		} else if(salarioMenosINSS>=2826.66&&salarioMenosINSS<=3751.05) {
			total = salarioMenosINSS*0.15 - 354.80;
		} else if(salarioMenosINSS>=3751.06&&salarioMenosINSS<=4664.68) {
			total = salarioMenosINSS*0.225 - 636.13;
		} else if(salarioMenosINSS<=0) {
			System.out.println("N�o � poss�vel calcular sal�rio 0 ou negativo");
		} else if(salarioMenosINSS>=4664.69) {
			total = salarioMenosINSS*0.275 - 869.36;
		}
		
		return total;
	}
	
	public double calculaSalarioLiquido(double salarioBruto) {		
		return salarioBruto-descontoIRRF(salarioBruto)-descontoINSS(salarioBruto);
	}
	
	public void imprimeContracheque(ArrayList<Funcionario> funcionarios) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o �ndice do funcion�rio que voc� quer imprimir o Contracheque");
		int indiceFuncionario = entrada.nextInt();
		System.out.println("***Impress�o de Contracheque***");
		System.out.println("");
		System.out.println("Funcion�rio: "+funcionarios.get(indiceFuncionario).getNome());
		System.out.println("Matr�cula: "+funcionarios.get(indiceFuncionario).getMatricula());
		System.out.println("Sal�rio Bruto: "+funcionarios.get(indiceFuncionario).getSalarioBruto());
		System.out.println("Desconto INSS: "+descontoINSS(funcionarios.get(indiceFuncionario).getSalarioBruto()));
		System.out.println("Desconto IRRF: "+descontoIRRF(funcionarios.get(indiceFuncionario).getSalarioBruto()));
		System.out.println("Sal�rio L�quido: "+calculaSalarioLiquido(funcionarios.get(indiceFuncionario).getSalarioBruto()));

	}
	


}
