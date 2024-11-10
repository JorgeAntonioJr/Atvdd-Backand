import org.springframework.stereotype.Component;

@Component
public class ContaMapper {

    public ContaDTO toContaDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }
}
