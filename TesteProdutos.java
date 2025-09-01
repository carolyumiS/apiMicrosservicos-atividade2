import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class TesteProdutos {

    //Metodo de busca por nome do exercicio d
    public static Optional<Produto> buscarProdutoPorNome(List<Produto> produtos, String nome){
        return produtos.stream().filter(p-> p.getNome().equals(nome)).findFirst();
    }

    public static void main(String[] args){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Smartphone", 1200.0, "Eletronicos"));
        produtos.add(new Produto("Notebook", 3500.0, "Eletronicos"));
        produtos.add(new Produto("Dom Casmurro", 45.0, "Livros"));
        produtos.add(new Produto("Java para Leigos", 11000.0, "Livros"));
        produtos.add(new Produto("Kitkat", 4.0, "Alimentos"));
        produtos.add(new Produto("Caixa Bombom", 12.0, "Alimentos"));
        produtos.add(new Produto("Teclado Mecanico", 250.0, "Eletronicos"));
        produtos.add(new Produto("Caderno", 10.0, "Papelaria"));
        produtos.add(new Produto("Caneta 4 cores", 6.0, "Papelaria"));
        produtos.add(new Produto("Harry Potter", 55.0, "Livros"));

        //a. Imprimir produtos da categoria Eletronicos
        System.out.println("===== Eletronicos (forEach) ======");
        produtos.forEach(p->{
            if("Eletronicos".equals(p.getCategoria())){
                System.out.println(p.getNome());
            }
        });

        System.out.println("\n===== Eletronicos (Stream api) ======");
        produtos.stream().filter(p-> "Eletronicos".equals(p.getCategoria())).forEach(p-> System.out.println(p.getNome()));

        //b. Lista com precos maiores que 500
        List<Double> precosMaiores = produtos.stream().filter(p-> p.getPreco() > 500.0).map(p-> p.getPreco()).collect(Collectors.toList());
        
        System.out.println("\nPrecos acima de 500: " + precosMaiores);

        //c. Valor total livros
        double totalLivros = produtos.stream().filter(p-> "Livros".equals(p.getCategoria())).mapToDouble(Produto::getPreco).sum();
        
        System.out.println("\nValor total dos Livros: R$ " + totalLivros);

        //e. Metodo busca por nome
        Optional<Produto> nomeBuscado = buscarProdutoPorNome(produtos, "Notebook");
        nomeBuscado.ifPresent(p-> System.out.println("\nProduto encontrado: " + p.getNome() + " - R$" + p.getPreco()));

        try{
            buscarProdutoPorNome(produtos, "ipad").orElseThrow(() -> new RuntimeException("Produto nao encontrado!"));
        } catch (RuntimeException e){
            System.out.println("\nErro: " + e.getMessage());
        }

        //f. Lista de nomes dos produtos
        List<String> nomesLambda = produtos.stream().map(p-> p.getNome()).collect(Collectors.toList());
        System.out.println("\nNomes (lambda): " + nomesLambda);

        List<String> nomesMetodoRef = produtos.stream().map(Produto::getNome).collect(Collectors.toList());
        System.out.println("Nomes (referencia de metodo): " + nomesMetodoRef);
    }
}
