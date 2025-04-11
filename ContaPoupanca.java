public class ContaPoupanca extends ContaBancaria{
    public ContaPoupanca (double saldoInicial, int idConta, String nomeTitular, String senha, int agencia){
        super(saldoInicial, idConta, nomeTitular, senha, agencia);
    }

    public void adicionarRendimento(){
        double rendimento = getSaldo() * 0.005;
        setSaldo(getSaldo() + rendimento);
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Rendimento disponivel: 0,5%");
    }
}

