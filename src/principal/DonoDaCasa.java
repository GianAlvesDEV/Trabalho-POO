package principal;

public class DonoDaCasa {
    private String cpf;
    private String nome;
    private String telefone;
    private float renda_mensal;

    public DonoDaCasa(String cpf, String nome, String telefone, float renda_mensal) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.renda_mensal = renda_mensal;
    }
    
    public DonoDaCasa() {
        this.cpf = "sem cpf";
        this.nome = "sem nome";
        this.telefone = "sem telefone";
        this.renda_mensal = 0;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public float getRenda_mensal() {
        return renda_mensal;
    }

    public void setRenda_mensal(float renda_mensal) {
        this.renda_mensal = renda_mensal;
    }

    @Override
    public String toString() {
        return "DonoDaCasa{" + "cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", renda_mensal=" + renda_mensal + '}';
    }
    
    
    
    
    
}
