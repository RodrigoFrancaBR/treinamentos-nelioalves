package br.com.franca.hruser.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_USER")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    // Por default quando buscamos um user, não vem os seus perfis (LAZY)
    // Quando fizermos uma busca de um usuário no banco, a consulta vai trazer todos os seus perfis. EAGER
    @JoinTable(
            name = "TB_USER_ROLE", // nome da terceira tabela
            // nome da chave primaria em TB_USER que vai para TB_USER_ROLE como Chave Estrangeira
            joinColumns = @JoinColumn(name = "user_id"),
            // nome da chave primaria da outra tabela do inverso em TB_ROLE que vai para TB_USER_ROLE como Chave Estrangeira
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

}
