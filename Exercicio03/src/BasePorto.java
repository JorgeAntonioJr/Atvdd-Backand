import java.util.ArrayList;
import java.util.List;

public class BasePorto {
    protected String nome;
    protected List<Barco> barcosAtracados;

    public BasePorto(String nome) {
        this.nome = nome;
        this.barcosAtracados = new ArrayList<>();
    }

    public boolean atracarBarco(Barco barco) {
        barcosAtracados.add(barco);
        return true;
    }

    public void desatracarBarco(Barco barco) {
        barcosAtracados.remove(barco);
    }

    public void listarBarcosAtracados() {
        System.out.println("Barcos atracados no " + nome + ": " + barcosAtracados);
    }
}
