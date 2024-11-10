public class Postagem {
    public enum Tipo {
        TEXTO, IMAGEM, VIDEO
    }

    private String titulo;
    private String descricao;
    private Tipo tipo;

    public Postagem(String titulo, String descricao, Tipo tipo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
