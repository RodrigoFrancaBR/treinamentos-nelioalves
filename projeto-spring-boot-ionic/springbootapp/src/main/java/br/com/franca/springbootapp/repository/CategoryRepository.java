package br.com.franca.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.franca.springbootapp.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
