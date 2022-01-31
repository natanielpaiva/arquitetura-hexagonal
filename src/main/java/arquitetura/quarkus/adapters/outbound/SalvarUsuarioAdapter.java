package arquitetura.quarkus.adapters.outbound;

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

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        var usuarioEntity = usuarioToUsuarioEntityMapper.mapper(usuario);
        usuarioRepository.persist(usuarioEntity);
        return usuarioEntity;
    }
}
