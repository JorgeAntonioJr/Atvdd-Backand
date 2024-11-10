public class PortoGrande extends BasePorto {
    public PortoGrande(String nome) {
        super(nome);
    }

    @Override
    public boolean atracarBarco(Barco barco) {
        if (barco.getTamanho() >= 10) {
            super.atracarBarco(barco);
            System.out.println(barco.getNome() + " atracado no " + nome);
            return true;
        } else {
            return false;
        }
    }
}
