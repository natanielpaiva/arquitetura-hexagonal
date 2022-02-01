package arquitetura.quarkus.application.core.service;

import arquitetura.quarkus.application.core.domain.Usuario;
import arquitetura.quarkus.application.ports.in.SalvarUsuarioServicePort;
import arquitetura.quarkus.application.ports.out.BuscarEnderecoPort;
import arquitetura.quarkus.application.ports.out.SalvarUsuarioPort;

public class SalvarUsuarioService implements SalvarUsuarioServicePort {

    private final SalvarUsuarioPort salvarUsuarioPort;

    private final BuscarEnderecoPort buscarEnderecoPort;


    public SalvarUsuarioService(SalvarUsuarioPort salvarUsuarioPort, BuscarEnderecoPort buscarEnderecoPort) {
        this.salvarUsuarioPort = salvarUsuarioPort;
        this.buscarEnderecoPort = buscarEnderecoPort;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario, String cep) {

        var endereco = buscarEnderecoPort.buscar(cep);
        usuario.setEndereco(endereco);

        return salvarUsuarioPort.salvar(usuario);
    }
}
