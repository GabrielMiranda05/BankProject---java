public class ContaCorrente extends ContaBancaria{
    public ContaCorrente (double saldoInicial, int idConta, String nomeTitular, String senha, int agencia){
        super(saldoInicial, idConta, nomeTitular, senha, agencia);
    }

    public void usarChequeEspecial(double valor){
        if (valor <= 0){
            System.out.println("Erro: o valor deve ser maior que zero.");
        }else if(this.getSaldo() - valor < -500){
            System.out.println("Erro: limite de cheque especial excedido");
        }else {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Cheque especial usado com sucesso");
        }
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Limite de cheque especial: R$500,00");
    }
}
