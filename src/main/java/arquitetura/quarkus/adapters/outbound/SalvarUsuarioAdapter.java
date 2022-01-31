package arquitetura.quarkus.adapters.outbound;

import arquitetura.quarkus.adapters.inbound.mapper.EnderecoToEnderecoEntityMapper;
import arquitetura.quarkus.adapters.inbound.mapper.UsuarioEntityToUsuarioMapper;
import arquitetura.quarkus.adapters.inbound.mapper.UsuarioToUsuarioEntityMapper;
import arquitetura.quarkus.adapters.outbound.repository.UsuarioRepository;
import arquitetura.quarkus.application.core.domain.Usuario;
import arquitetura.quarkus.application.ports.out.SalvarUsuarioPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class SalvarUsuarioAdapter implements SalvarUsuarioPort {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    UsuarioToUsuarioEntityMapper usuarioToUsuarioEntityMapper;

    @Inject
    UsuarioEntityToUsuarioMapper usuarioToUsuarioEntitymMapper;

    @Inject
    EnderecoToEnderecoEntityMapper enderecoToEnderecoEntityMapper;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        var usuarioEntity = usuarioToUsuarioEntityMapper.mapper(usuario);
        var enderecoEntity = enderecoToEnderecoEntityMapper.mapper(usuario.getEndereco());
        usuarioEntity.setEndereco(enderecoEntity);
        usuarioRepository.persist(usuarioEntity);
        return usuarioToUsuarioEntitymMapper.mapper(usuarioEntity);
    }
}
