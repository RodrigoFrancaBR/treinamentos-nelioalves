package br.com.franca.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.franca.springbootapp.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
