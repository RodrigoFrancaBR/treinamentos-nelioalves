package br.com.franca.springbootapp.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.springbootapp.domain.Category;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> findAll() {

		List<Category> categoryList = buildCategory();

		return categoryList;

	}

	private List<Category> buildCategory() {
		Category category1 = new Category(1, "Informática");
		Category category2 = new Category(2, "Escritório");

		List<Category> categoryList = new ArrayList<>();
		categoryList.add(category1);
		categoryList.add(category2);
		return categoryList;

	}

}
