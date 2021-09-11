package br.com.franca.springbootapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.franca.springbootapp.domain.Category;
import br.com.franca.springbootapp.domain.Product;
import br.com.franca.springbootapp.repository.CategoryRepository;
import br.com.franca.springbootapp.repository.ProductRepository;

@SpringBootApplication
public class SpringbootappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootappApplication.class, args);
	}

	private CategoryRepository categoriyRepository;
	private ProductRepository productRepository;

	public SpringbootappApplication(CategoryRepository categoriyRepository, ProductRepository productRepository) {
		this.categoriyRepository = categoriyRepository;
		this.productRepository = productRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Category category1 = new Category(null, "Informática");

		Product product1 = new Product(null, "Computador", 2000.00);
		Product product2 = new Product(null, "Impressora", 800.00);
		Product product3 = new Product(null, "Mouse", 80.00);

		List<Product> productList = Arrays.asList(product1, product2, product3);

		category1.getProducts().addAll(productList);

		Category category2 = new Category(null, "Escritório");

		category2.getProducts().addAll(Arrays.asList(product2));

		product1.getCategories().addAll(Arrays.asList(category1));
		product2.getCategories().addAll(Arrays.asList(category1, category2));
		product3.getCategories().addAll(Arrays.asList(category1));

		categoriyRepository.saveAll(Arrays.asList(category1, category2));

		productRepository.saveAll(Arrays.asList(product1, product2, product3));

	}

}
