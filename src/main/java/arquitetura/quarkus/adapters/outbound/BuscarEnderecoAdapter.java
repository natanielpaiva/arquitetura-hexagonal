package arquitetura.quarkus.adapters.outbound;

import arquitetura.quarkus.adapters.outbound.rest.BuscarEnderecoRest;
import arquitetura.quarkus.application.core.domain.Endereco;
import arquitetura.quarkus.application.ports.out.BuscarEnderecoPort;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BuscarEnderecoAdapter implements BuscarEnderecoPort {

    @Inject
    @RestClient
    BuscarEnderecoRest buscarEnderecoRest;

    @Override
    public Endereco buscar(String cep) {
        return buscarEnderecoRest.buscar(cep);
    }
}
