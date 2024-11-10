import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coletar dados da postagem
        System.out.print("Digite o título da postagem: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição da postagem: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o tipo da postagem (texto, imagem, video): ");
        String tipoInput = scanner.nextLine().toUpperCase();

        Postagem.Tipo tipo;
        try {
            tipo = Postagem.Tipo.valueOf(tipoInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de postagem inválido!");
            scanner.close();
            return;
        }

        // Criar a postagem
        Postagem postagem = new Postagem(titulo, descricao, tipo);

        // Compartilhar nas plataformas
        MyBook myBook = new MyBook();
        Fotogram fotogram = new Fotogram();
        AnyTube anyTube = new AnyTube();

        // MyBook: Suporta tudo
        try {
            if (tipo == Postagem.Tipo.TEXTO) myBook.compartilharPostagem(postagem);
            if (tipo == Postagem.Tipo.IMAGEM) myBook.compartilharImagem(postagem);
            if (tipo == Postagem.Tipo.VIDEO) myBook.compartilharVideo(postagem);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Fotogram: Não suporta TEXTO
        try {
            if (tipo == Postagem.Tipo.TEXTO) fotogram.compartilharPostagem(postagem);
            else if (tipo == Postagem.Tipo.IMAGEM) fotogram.compartilharImagem(postagem);
            else fotogram.compartilharVideo(postagem);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // AnyTube: Não suporta IMAGEM
        try {
            if (tipo == Postagem.Tipo.TEXTO) anyTube.compartilharPostagem(postagem);
            else if (tipo == Postagem.Tipo.IMAGEM) anyTube.compartilharImagem(postagem);
            else anyTube.compartilharVideo(postagem);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
