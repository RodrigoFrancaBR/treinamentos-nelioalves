package br.com.franca.hroauth.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    private Long id;
    private String roleName;
}
