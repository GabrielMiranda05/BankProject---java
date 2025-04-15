public class ContaBancaria {
    private double saldo;
    private int idConta;
    private String nomeTitular;
    private String senha;
    private int agencia;

    public ContaBancaria(double saldoInicial, int idConta, String nomeTitular, String senha, int agencia) {
        this.saldo = saldoInicial;
        this.idConta = idConta;
        this.nomeTitular = nomeTitular;
        this.senha = senha;
        this.agencia = agencia;
    }

    public ContaBancaria(String nomeTitular, double saldoInicial, int idConta) {
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial;
        this.idConta = idConta; 
    }

    public void exibirInformacoes() {
        System.out.println("Titular: " + nomeTitular);
        System.out.println("Agência: " + agencia);
        System.out.println("ID da Conta: " + idConta);
        System.out.println("Saldo: " + saldo);
    }


    public void depositar(double valor){
        if(valor <= 0){
            System.out.println("Erro: o valor do deposito deve ser maior que zero.");
        }else{
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        }
    }

    public void sacar(double valor){
        if (valor <= 0){
            System.out.println("Erro: o valor de saque deve ser maior que zero.");
        } else if (valor > saldo) {
            System.out.println("Erro: Saldo insuficiente.");
        } else {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo < 0 && saldo < -500) {
            System.out.println("Erro: o saldo da conta não pode ser negativo.");
        }else{
            this.saldo = saldo;
        }

    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        if(nomeTitular == null || nomeTitular.isEmpty()){
            System.out.println("Erro: preencha o nome do titular.");
        }else{
        this.nomeTitular = nomeTitular;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }


}
