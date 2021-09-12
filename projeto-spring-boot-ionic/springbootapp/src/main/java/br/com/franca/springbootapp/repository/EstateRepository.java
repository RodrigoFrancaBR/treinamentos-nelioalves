package br.com.franca.springbootapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.franca.springbootapp.domain.Estate;

@Repository
public interface EstateRepository extends JpaRepository<Estate, Integer> {

}
