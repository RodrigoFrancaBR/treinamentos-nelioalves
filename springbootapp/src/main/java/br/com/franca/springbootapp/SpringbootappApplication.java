package br.com.franca.springbootapp;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.franca.springbootapp.domain.Category;
import br.com.franca.springbootapp.repository.CategoryRepository;

@SpringBootApplication
public class SpringbootappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootappApplication.class, args);
	}

	private CategoryRepository categoriyRepository;

	public SpringbootappApplication(CategoryRepository categoriyRepository) {
		this.categoriyRepository = categoriyRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category(null, "Informática");
		Category category2 = new Category(null, "Escritório");

		categoriyRepository.saveAll(Arrays.asList(category1, category2));

	}

}
