import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static ArrayList<ContaBancaria> contas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== Sistema Bancário ===");
            System.out.println("1. Criar Conta");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Saque");
            System.out.println("4. Exibir Informações da Conta");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    criarConta(scanner);
                    break;
                case 2:
                    realizarDeposito(scanner);
                    break;
                case 3:
                    System.out.println("Opção de realizar saque ainda não implementada.");
                    break;
                case 4:
                    System.out.println("Opção de exibir informações ainda não implementada.");
                    break;
                case 5:
                    System.out.println("Encerrando o sistema. Até mais!");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void criarConta(Scanner scanner) {
        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();
        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); // Consumir quebra de linha
        System.out.println("Digite o id da conta (2 numero): ");
        int idConta = scanner.nextInt();
        scanner.nextLine();

        ContaBancaria novaConta = new ContaBancaria(nomeTitular, saldoInicial, idConta);
        contas.add(novaConta);
        System.out.println("Conta criada com sucesso!");
    }

    private static void realizarDeposito(Scanner scanner) {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha
        System.out.print("Digite o valor do depósito: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir quebra de linha

        for (ContaBancaria conta : contas) {
            if (conta.getIdConta() == numeroConta) {
                conta.depositar(valor);
                System.out.println("Depósito realizado com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}
