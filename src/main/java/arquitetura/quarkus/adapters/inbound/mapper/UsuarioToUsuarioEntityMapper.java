package arquitetura.quarkus.adapters.inbound.mapper;

import arquitetura.quarkus.adapters.inbound.entity.UsuarioEntity;
import arquitetura.quarkus.application.core.domain.Usuario;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioToUsuarioEntityMapper {

    public UsuarioEntity mapper(Usuario usuario){
        var usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setInstagram(usuario.getInstagram());
        usuarioEntity.setDataNascimento(usuario.getDataNascimento());
        usuarioEntity.setLinkedin(usuario.getLinkedin());
        usuarioEntity.setGithub(usuario.getGithub());
        return usuarioEntity;
    }

}
