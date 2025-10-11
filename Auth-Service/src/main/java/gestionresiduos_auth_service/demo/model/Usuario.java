package gestionresiduos_auth_service.demo.model;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuarios")
@Data @NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(unique=true,nullable=false) private String username;
  @Column(nullable=false) private String passwordHash;
  private String nombre; private String apellido; private String email; private Boolean activo=true;
  @ManyToMany(fetch=FetchType.EAGER)
  @JoinTable(name="usuario_rol", joinColumns=@JoinColumn(name="usuario_id"), inverseJoinColumns=@JoinColumn(name="rol_id"))
  private Set<Role> roles;
}

