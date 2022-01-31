package arquitetura.quarkus.application.core.service;

import arquitetura.quarkus.application.core.domain.Endereco;
import arquitetura.quarkus.application.core.domain.Usuario;
import arquitetura.quarkus.application.ports.in.SalvarUsuarioServicePort;
import arquitetura.quarkus.application.ports.out.SalvarUsuarioPort;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SalvarUsuarioService implements SalvarUsuarioServicePort {

    private final SalvarUsuarioPort salvarUsuarioPort;


    public SalvarUsuarioService(SalvarUsuarioPort salvarUsuarioPort) {
        this.salvarUsuarioPort = salvarUsuarioPort;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario, String cep) {

//        var endereco = buscarEnderecoPort.buscar(cep);
//        usuario.setEndereco(endereco);
        var endereco = new Endereco();
        endereco.setCep(cep);
        usuario.setEndereco(endereco);

        return salvarUsuarioPort.salvar(usuario);
    }
}
