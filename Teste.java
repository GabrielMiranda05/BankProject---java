public class Teste {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaPoupanca(1000, 123, "Gabriel","senhaForte@123",001);
        ContaBancaria conta2 = new ContaCorrente(1200, 456, "Gustavo","senhaForte@321",002);

        ContaBancaria[] contas = {conta1, conta2};

        for (ContaBancaria conta : contas) {
            System.out.println("------------------------");
            conta.exibirInformacoes();
            System.out.println("------------------------");
        }
    }

}
