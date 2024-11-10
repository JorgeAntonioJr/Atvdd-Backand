public class Fotogram implements PlataformaSocial {
    @Override
    public void compartilharPostagem(Postagem postagem) throws Exception {
        if (postagem.getTipo() == Postagem.Tipo.TEXTO) {
            throw new Exception("Erro: Fotogram não suporta compartilhamento de postagens de texto.");
        }
        System.out.println("Você compartilhou essa postagem no Fotogram.");
    }

    @Override
    public void compartilharImagem(Postagem postagem) {
        System.out.println("Você compartilhou essa imagem no Fotogram.");
    }

    @Override
    public void compartilharVideo(Postagem postagem) {
        System.out.println("Você compartilhou esse vídeo no Fotogram.");
    }
}
