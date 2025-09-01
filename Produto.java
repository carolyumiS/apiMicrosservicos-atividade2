public class Produto{
    private String nome;
    private Double preco;
    private String categoria;

    public Produto(String nome, double preco, String categoria){
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() { return nome; }
    public double getPreco() {return preco; }
    public String getCategoria(){ return categoria; }
}