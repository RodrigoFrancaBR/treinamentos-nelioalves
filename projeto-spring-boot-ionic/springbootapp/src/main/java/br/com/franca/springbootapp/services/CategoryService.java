package br.com.franca.springbootapp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.franca.springbootapp.domain.Category;
import br.com.franca.springbootapp.repository.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category find(Integer id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.orElse(null);
	}

}
