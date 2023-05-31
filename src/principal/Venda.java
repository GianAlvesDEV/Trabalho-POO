package principal;

import java.time.LocalDate;

public class Venda {
    private String cod_venda;
    private String fk_cpf;
    private int fk_cod_residencia;
    private LocalDate dataDaVenda;
    private float valor;

    public Venda(String cod_venda, String fk_cpf, int fk_cod_residencia, LocalDate dataDaVenda, float valor) {
        this.cod_venda = cod_venda;
        this.fk_cpf = fk_cpf;
        this.fk_cod_residencia = fk_cod_residencia;
        this.dataDaVenda = dataDaVenda;
        this.valor = valor;
    }
    
    public Venda() {
        this.cod_venda = "sem codigo";
        this.fk_cpf = "sem cpf";
        this.fk_cod_residencia = 0;
        this.dataDaVenda = LocalDate.now();
        this.valor = 0;
    }

    public String getCod_venda() {
        return cod_venda;
    }

    public void setCod_venda(String cod_venda) {
        this.cod_venda = cod_venda;
    }

    public String getFk_cpf() {
        return fk_cpf;
    }

    public void setFk_cpf(String fk_cpf) {
        this.fk_cpf = fk_cpf;
    }

    public int getFk_cod_residencia() {
        return fk_cod_residencia;
    }

    public void setFk_cod_residencia(int fk_cod_residencia) {
        this.fk_cod_residencia = fk_cod_residencia;
    }

    public LocalDate getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(LocalDate dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Venda{" + "cod_venda=" + cod_venda + ", fk_cpf=" + fk_cpf + ", fk_cod_residencia=" + fk_cod_residencia + ", dataDaVenda=" + dataDaVenda + ", valor=" + valor + '}';
    }
     
    
}
