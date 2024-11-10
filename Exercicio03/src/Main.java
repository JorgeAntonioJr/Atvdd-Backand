import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criar barcos
        List<Barco> barcos = new ArrayList<>();
        barcos.add(new Barco("Barco 1", 2));
        barcos.add(new Barco("Barco 2", 5));
        barcos.add(new Barco("Barco 3", 7));
        barcos.add(new Barco("Barco 4", 12));
        barcos.add(new Barco("Barco 5", 20));

        // Criar portos
        PortoPequeno portoPequeno = new PortoPequeno("Porto Pequeno");
        PortoGrande portoGrande = new PortoGrande("Porto Grande");

        // Tentar atracar barcos nos portos
        for (Barco barco : barcos) {
            // Tenta atracar no porto pequeno, se falhar, tenta no porto grande
            if (!portoPequeno.atracarBarco(barco)) {
                portoGrande.atracarBarco(barco);
            }
        }

        // Listar barcos atracados em cada porto
        System.out.println("\nResumo dos Portos:");
        portoPequeno.listarBarcosAtracados();
        portoGrande.listarBarcosAtracados();
    }
}
