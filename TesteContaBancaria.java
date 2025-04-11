public class TesteContaBancaria {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria(1000,777777, "Gabriel Miranda", "senhaforte@123", 99);

        conta1.depositar(500);
        System.out.println("Saldo atual: " + conta1.getSaldo());
        conta1.depositar(-10);

        conta1.sacar(200);
        System.out.println("Saldo atual: " + conta1.getSaldo());
        conta1.sacar(1500);
        conta1.sacar(-10);
    }
}
