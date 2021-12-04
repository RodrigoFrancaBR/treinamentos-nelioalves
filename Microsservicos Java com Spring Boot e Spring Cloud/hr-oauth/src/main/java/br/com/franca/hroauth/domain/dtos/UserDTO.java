package br.com.franca.hroauth.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<RoleDTO> roles = new HashSet<>();

}
