package arquitetura.quarkus.application.ports.in;

import arquitetura.quarkus.application.core.domain.Usuario;

public interface SalvarUsuarioServicePort {
    Usuario salvarUsuario(Usuario usuario, String cep);
}
