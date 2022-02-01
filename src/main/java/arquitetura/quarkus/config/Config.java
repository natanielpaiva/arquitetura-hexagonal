package arquitetura.quarkus.config;

import arquitetura.quarkus.adapters.outbound.BuscarEnderecoAdapter;
import arquitetura.quarkus.adapters.outbound.SalvarUsuarioAdapter;
import arquitetura.quarkus.application.core.service.SalvarUsuarioService;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

@Dependent
public class Config {

    @Default
    public SalvarUsuarioService salvarUsuarioService(SalvarUsuarioAdapter salvarUsuarioAdapter, BuscarEnderecoAdapter buscarEnderecoAdapter){
        return new SalvarUsuarioService(salvarUsuarioAdapter, buscarEnderecoAdapter);
    }



}
