public class PortoPequeno extends BasePorto {
    public PortoPequeno(String nome) {
        super(nome);
    }

    @Override
    public boolean atracarBarco(Barco barco) {
        if (barco.getTamanho() <= 10) {
            super.atracarBarco(barco);
            System.out.println(barco.getNome() + " atracado no " + nome);
            return true;
        } else {
            return false;
        }
    }
}
