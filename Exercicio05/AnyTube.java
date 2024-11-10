public class AnyTube implements PlataformaSocial {
    @Override
    public void compartilharPostagem(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no AnyTube.");
    }

    @Override
    public void compartilharImagem(Postagem postagem) throws Exception {
        if (postagem.getTipo() == Postagem.Tipo.IMAGEM) {
            throw new Exception("Erro: AnyTube não suporta compartilhamento de imagens.");
        }
        System.out.println("Você compartilhou essa imagem no AnyTube.");
    }

    @Override
    public void compartilharVideo(Postagem postagem) {
        System.out.println("Você compartilhou esse vídeo no AnyTube.");
    }
}
