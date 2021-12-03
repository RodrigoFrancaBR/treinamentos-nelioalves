package br.com.franca.hruser.domain.repository;

import br.com.franca.hruser.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
