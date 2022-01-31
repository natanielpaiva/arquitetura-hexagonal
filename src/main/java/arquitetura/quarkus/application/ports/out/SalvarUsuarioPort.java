package arquitetura.quarkus.application.ports.out;

import arquitetura.quarkus.application.core.domain.Usuario;

public interface SalvarUsuarioPort {
    Usuario salvar(Usuario usuario);
}
