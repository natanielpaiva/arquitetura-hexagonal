package arquitetura.quarkus.adapters.inbound.entity;

import arquitetura.quarkus.application.core.domain.Usuario;

import javax.persistence.*;

@Entity
public class UsuarioEntity extends Usuario {
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
