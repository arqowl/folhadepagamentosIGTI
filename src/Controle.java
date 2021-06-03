import java.util.ArrayList;
import java.util.Scanner;
import entidades.*;

public class Controle {
	
	public void iniciar() {
		boolean chave = true;
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		Funcionario funcionario = new Funcionario("","", 0);
		
		Scanner entrada = new Scanner(System.in);
		
		while(chave) {
			imprimirMenu();
			int menu = entrada.nextInt();
			
			switch (menu) {
			case 1:
				funcionarios.add(funcionario.cadastroFuncionario());
				break;
			case 2:
				funcionario.consultaFuncionario(funcionarios);
				break;
			case 3:
				funcionario.imprimeContracheque(funcionarios);
				break;

			default:
				chave = false;
				System.out.println("Fim do programa.");
				entrada.close();
				break;
			}
		}
	}
	
	public void imprimirMenu() {
		System.out.println("********Menu de Contracheque********");
		System.out.println("Para cadastrar um funcionário digite - 1");
		System.out.println("Para visualizar os funcionários cadastrados digite - 2");
		System.out.println("Para imprimir o contracheque de um funcionário - 3");
		System.out.println("Para sair digite outro número");
		
		
	}

}
