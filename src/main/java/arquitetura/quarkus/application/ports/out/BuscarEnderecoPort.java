package arquitetura.quarkus.application.ports.out;

import arquitetura.quarkus.application.core.domain.Endereco;

public interface BuscarEnderecoPort {
    Endereco buscar(String cep);
}
