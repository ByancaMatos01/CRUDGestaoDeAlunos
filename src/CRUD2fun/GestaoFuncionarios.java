package CRUD2fun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GestaoFuncionarios {
    int indice;
    Funcionario[] funcionarios;

    public GestaoFuncionarios() {
        this.funcionarios = new Funcionario[50];
        this.indice = 0;
    }

    void criar() {
        Scanner leia = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Corrigi o formato da data

        if (indice <= 50) {
            System.out.println("Digite ID: ");
            long id = leia.nextLong();
            System.out.println("Digite o nome: ");
            String nome = leia.next();

            System.out.println("Digite a matricula: ");
            String matricula = leia.next();

            System.out.println("Digite a admissao: (dd/MM/yyyy)"); // Corrigi o formato da data
            Date admissao = null;
            try {
                admissao = sdf.parse(leia.next());

            } catch (ParseException e) {
                System.out.println("Formato invalido");
                return;
            }
            System.out.println("Digite a demissao: (dd/MM/yyyy)"); // Corrigi o formato da data
            Date demissao = null;
            try {
                demissao = sdf.parse(leia.next());

            } catch (ParseException e) {
                System.out.println("Formato invalido");
                return;
            }
            System.out.println("Digite o salario: ");
            float salario = leia.nextFloat();
            System.out.println("Digite o horario");
            String horario = leia.next();

            Funcionario novofuncionario = new Funcionario(id, nome, matricula, demissao, admissao, salario, horario);
            funcionarios[indice] = novofuncionario;
            indice++;
        } else {
            System.out.println("Indice está lotado, não é mais possível adicionar um novo funcionario");
        }

    }

    void exibir() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a matricula do funcionario que deseja exibir: ");
        String matBusca = scanner.nextLine();

        for (int i = 0; i < indice; i++) {
            if (funcionarios[i].getmatricula().equals(matBusca)) {
                System.out.println(funcionarios[i]);
                return;
            }
        }

        System.out.println("O funcionário com a matricula " + matBusca + " não foi encontrado.");
    }

    void excluir() {

        Scanner leia = new Scanner(System.in);
        System.out.println("Digite a matricula");
        String buscaMatricula = leia.nextLine();
        for (int i = 0; i < indice; i++) {
            if (funcionarios[i].getmatricula().equals(buscaMatricula)) {
                for (int j = i; j < indice - 1; j++) {
                    funcionarios[j] = funcionarios[j + 1];
                }
                indice--;
                funcionarios[indice] = null;
                System.out.println("Funcionario com a matricula " + buscaMatricula + " foi removido");
                return;
            }
        }
        System.out.println("Funcionario com este registro não encontrado");

    }

    void atualizar() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Digite a matricula");
        String buscaMatricula = leia.nextLine();

        for (int i = 0; i < indice; i++) {
            if (funcionarios[i].getmatricula().equals(buscaMatricula)) {
                System.out.println("Digite o novo nome: ");
                String novoNome = leia.next();
                funcionarios[i].setnome(novoNome);

                System.out.println("Digite o novo id: ");
                long novoId = leia.nextLong();
                funcionarios[i].setid(novoId);

                System.out.println("Digite o novo salario");
                float novoSalario = leia.nextFloat();
                funcionarios[i].Setsalario(novoSalario);

                System.out.println("Digite novo horario");
                String novaHora = leia.next();
                funcionarios[i].sethorario(novaHora);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Digite a data da nova admissao: ");
                Date novaAdmissao = null;
                try {
                    novaAdmissao = sdf.parse(leia.next());

                } catch (ParseException e) {
                    System.out.println("Formato de data inválido. Os dados não foram atualizados ");
                }

                System.out.println("Digite a data da nova demissao: ");
                Date novaDemissao = null;
                try {
                    novaDemissao = sdf.parse(leia.next());

                } catch (ParseException e) {
                    System.out.println("Formato de data inválido. Os dados não foram atualizados ");
                }

                funcionarios[i].Setadmissao(novaAdmissao);
                funcionarios[i].Setadmissao(novaDemissao);

                System.out.println("Dados atualizados");
                return;

            }
        }
        System.out.println("Funcionario com este registro não encontrado");
    }

    public void menu() {
        while (true) {
            System.out.println("\n(C)riar  (E)xibir  (R)emover  (A)tualizar  (S)air");
            Scanner leia = new Scanner(System.in);
            String opcao = leia.nextLine().toUpperCase();
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
                    System.out.println("Opcao invalida, tente novamente! ");
            }

        }
    }
}
