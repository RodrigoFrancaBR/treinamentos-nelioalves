package br.com.franca.springbootapp.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.springbootapp.domain.Category;
import br.com.franca.springbootapp.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

	private CategoryService categoryService;

	public CategoryResource(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findAll(@PathVariable Integer id) {

		Category category = categoryService.find(id);

		return ResponseEntity.ok().body(category);

	}

}
