package arquitetura.quarkus.adapters.inbound;

import arquitetura.quarkus.adapters.inbound.mapper.UsuarioRequestToUsuarioMapper;
import arquitetura.quarkus.adapters.inbound.request.UsuarioRequest;
import arquitetura.quarkus.application.core.domain.Usuario;
import arquitetura.quarkus.application.ports.in.SalvarUsuarioServicePort;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController {

    private final SalvarUsuarioServicePort salvarUsuarioServicePort;

    private final UsuarioRequestToUsuarioMapper usuarioRequestToUsuarioMapper;

    public UsuarioController(SalvarUsuarioServicePort salvarUsuarioServicePort, UsuarioRequestToUsuarioMapper usuarioRequestToUsuarioMapper) {
        this.salvarUsuarioServicePort = salvarUsuarioServicePort;
        this.usuarioRequestToUsuarioMapper = usuarioRequestToUsuarioMapper;
    }

    @POST
    public Usuario salvarUsuario(UsuarioRequest usuarioRequest){
        var usuario = usuarioRequestToUsuarioMapper.mapper(usuarioRequest);
        return salvarUsuarioServicePort.salvarUsuario(usuario, usuarioRequest.getCep());
    }

}
