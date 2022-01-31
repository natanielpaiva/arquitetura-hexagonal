package arquitetura.quarkus.adapters.inbound.mapper;

import arquitetura.quarkus.adapters.inbound.entity.EnderecoEntity;
import arquitetura.quarkus.application.core.domain.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface EnderecoToEnderecoEntityMapper {

    EnderecoEntity mapper(Endereco endereco);

}
