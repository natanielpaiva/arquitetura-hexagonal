package arquitetura.quarkus.adapters.inbound.entity;

import arquitetura.quarkus.application.core.domain.Endereco;

import javax.persistence.*;

@Entity
public class EnderecoEntity extends Endereco {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
