package br.com.franca.springbootapp.api.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.springbootapp.api.v1.interfaces.CategoriaAPI;
import br.com.franca.springbootapp.domain.Category;
import br.com.franca.springbootapp.services.CategoryService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController implements CategoriaAPI {

	private CategoryService categoryService;

	public CategoriaController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public ResponseEntity<?> findAll(Integer id) {
		Category category = categoryService.find(id);
		return ResponseEntity.ok().body(category);
	}

}
