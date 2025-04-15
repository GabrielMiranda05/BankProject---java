import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static ArrayList<ContaBancaria> contas = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
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
                    case 1 -> criarConta(scanner);
                    case 2 -> realizarDeposito(scanner);
                    case 3 -> sacar(scanner);
                    case 4 -> exibirInformacoes(scanner);
                    case 5 -> {
                        System.out.println("Encerrando o sistema. Até mais!");
                        running = false;
                    }
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }

    private static void criarConta(Scanner scanner) {
        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();
        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); 
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
        scanner.nextLine(); 
        System.out.print("Digite o valor do depósito: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 

        for (ContaBancaria conta : contas) {
            if (conta.getIdConta() == numeroConta) {
                conta.depositar(valor);
                System.out.println("Depósito realizado com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    private static void sacar(Scanner scanner) {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite o valor do saque: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 

        for (ContaBancaria conta : contas) {
            if (conta.getIdConta() == numeroConta) {
                if (conta.getSaldo() >= valor) {
                    conta.sacar(valor);
                    System.out.println("Saque realizado com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente.");
                }
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    private static void exibirInformacoes(Scanner scanner) {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();

        for (ContaBancaria conta : contas) {
            if (conta.getIdConta() == numeroConta) {
                conta.exibirInformacoes();
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}
