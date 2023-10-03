package CRUD1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GestaoAlunos {
	
	 int indice;
	  Aluno[] alunos;
	  
	  public GestaoAlunos() {
		  this.alunos=new Aluno[50];
		  this.indice=0;
		  
	  }
	  
	  void criar() {
		  Scanner leia=new Scanner (System.in);
		  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		  if(indice<=50) {
			  System.out.println("Digite o id" );
			  long id=leia.nextInt();

			  System.out.println("Digite nome");
			  String nome = leia.next();

			  System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
			  Date nascimento = null;
			  try {
				  nascimento = sdf.parse(leia.next());
			  } catch (ParseException e) {
				  System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
				  return;
			  }

			  System.out.print("Digite o RA do aluno: ");
			  String ra = leia.next();

			  Aluno novoAluno = new Aluno(id, nome,nascimento, ra);
			  alunos[indice] = novoAluno;
			  indice++;
		  } else {
			  System.out.println("A turma está cheia, não é possível adicionar mais alunos.");
		  }
	  }

	  void exibir() {
		  Scanner scanner = new Scanner(System.in);
		  System.out.print("Digite o RA do aluno que deseja exibir: ");
		  String raBusca = scanner.nextLine();

		  for (int i = 0; i < indice; i++) {
			  if (alunos[i].getRa().equals(raBusca)) {
				  System.out.println(alunos[i]);
				  return;
			  }
		  }

		  System.out.println("Aluno com RA " + raBusca + " não encontrado.");
	  }
	
	void excluir() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o RA do aluno que deseja excluir: ");
		String raBusca = scanner.nextLine();

		for (int i = 0; i < indice; i++) {
			if (alunos[i].getRa().equals(raBusca)) {
				for (int j = i; j < indice - 1; j++) {
					alunos[j] = alunos[j + 1];
				}
				indice--;
				alunos[indice] = null;
				System.out.println("Aluno com RA " + raBusca + " removido com sucesso.");
				return;
			}
		}

		System.out.println("Aluno com RA " + raBusca + " não encontrado.");
	}

	void atualizar() {
		Scanner leia= new Scanner(System.in);
		System.out.println("Digite o  RA");
		String buscaRa =leia.nextLine();

		for(int i=0; i<indice; i++) {
			if(alunos[i].ra.equals(buscaRa)) {
				System.out.println("Digite o novo nome: ");
				String novoNome = leia.next();
				alunos[i].setNome(novoNome);

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.print("Digite a nova data de nascimento (dd/MM/yyyy): ");
				Date novaData = null;
				try {
					novaData = sdf.parse(leia.next());
					alunos[i].setNascimento(novaData);
				} catch (ParseException e) {
					System.out.println("Formato de data inválido. Os dados não foram atualizados.");
				}

				System.out.println("Dados atualizados com sucesso.");
				return;
			}
		}

		System.out.println("Aluno com RA " + buscaRa + " não encontrado.");
	}   
	public void menu() {
		while (true) {
			System.out.println("\n(C)riar   (E)xibir   (R)emover   (A)tualizar   (S)air");
			Scanner scanner = new Scanner(System.in);
			String opcao = scanner.nextLine().toUpperCase();
			char letra = opcao.charAt(0);

			switch (letra) {
			case 'C':
				criar();
				break;
			case 'E':
				exibir();
				break;
			case 'R':
				excluir();
				break;
			case 'A':
				atualizar();
				break;
			case 'S':
				System.exit(0);
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}
	
	}

