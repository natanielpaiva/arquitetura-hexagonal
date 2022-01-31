package arquitetura.quarkus.adapters.inbound.mapper;

import arquitetura.quarkus.adapters.inbound.request.UsuarioRequest;
import arquitetura.quarkus.application.core.domain.Usuario;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRequestToUsuarioMapper {

    public Usuario mapper(UsuarioRequest usuarioRequest){
        var usuario = new Usuario();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setInstagram(usuarioRequest.getInstagram());
        usuario.setGithub(usuarioRequest.getGithub());
        usuario.setLinkedin(usuarioRequest.getLinkedin());
        usuario.setDataNascimento(usuarioRequest.getDataNascimento());
        return usuario;
    }

}
