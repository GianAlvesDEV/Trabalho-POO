package principal;

public class Residencia {
    private int cod_residencia;
    private float area;
    private String endereco;

    public Residencia(int cod_residencia, float area, String endereco) {
        this.cod_residencia = cod_residencia;
        this.area = area;
        this.endereco = endereco;
    }
    
    public Residencia() {
        this.cod_residencia = 0;
        this.area = 0;
        this.endereco = "sem endereco";
    }

    public int getCod_residencia() {
        return cod_residencia;
    }

    public void setCod_residencia(int cod_residencia) {
        this.cod_residencia = cod_residencia;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Residencia{" + "cod_residencia=" + cod_residencia + ", area=" + area + ", endereco=" + endereco + '}';
    }
    
    
}
