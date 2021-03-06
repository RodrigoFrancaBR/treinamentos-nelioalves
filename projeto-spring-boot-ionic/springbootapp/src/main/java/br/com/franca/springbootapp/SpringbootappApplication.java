package br.com.franca.springbootapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.franca.springbootapp.domain.Address;
import br.com.franca.springbootapp.domain.Category;
import br.com.franca.springbootapp.domain.City;
import br.com.franca.springbootapp.domain.Client;
import br.com.franca.springbootapp.domain.ClientType;
import br.com.franca.springbootapp.domain.Estate;
import br.com.franca.springbootapp.domain.Product;
import br.com.franca.springbootapp.repository.AddressRepository;
import br.com.franca.springbootapp.repository.CategoryRepository;
import br.com.franca.springbootapp.repository.CityRepository;
import br.com.franca.springbootapp.repository.ClientRepository;
import br.com.franca.springbootapp.repository.EstateRepository;
import br.com.franca.springbootapp.repository.ProductRepository;

@SpringBootApplication
public class SpringbootappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootappApplication.class, args);
	}

	private CategoryRepository categoriyRepository;
	private ProductRepository productRepository;
	private CityRepository cityRepository;
	private EstateRepository estateRepository;
	private ClientRepository clientRepository;
	private AddressRepository addressRepository;

	public SpringbootappApplication(CategoryRepository categoriyRepository,
			ProductRepository productRepository
			, EstateRepository estateRepository
			, CityRepository cityRepository
			,ClientRepository clientRepository
			,AddressRepository addressRepository) {
		
		this.categoriyRepository = categoriyRepository;
		this.productRepository = productRepository;
		 this.cityRepository = cityRepository;
		this.estateRepository = estateRepository;
		 this.clientRepository = clientRepository;
			this.estateRepository = estateRepository;
			this.addressRepository = addressRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Category category1 = new Category(null, "Inform??tica");

		Product product1 = new Product(null, "Computador", 2000.00);
		Product product2 = new Product(null, "Impressora", 800.00);
		Product product3 = new Product(null, "Mouse", 80.00);

		List<Product> productList = Arrays.asList(product1, product2, product3);

		category1.getProducts().addAll(productList);

		Category category2 = new Category(null, "Escrit??rio");

		category2.getProducts().addAll(Arrays.asList(product2));

		product1.getCategories().addAll(Arrays.asList(category1));
		product2.getCategories().addAll(Arrays.asList(category1, category2));
		product3.getCategories().addAll(Arrays.asList(category1));

		categoriyRepository.saveAll(Arrays.asList(category1, category2));

		productRepository.saveAll(Arrays.asList(product1, product2, product3));
		
		Estate estate1 = new Estate(null, "Minas Gerais");
		Estate estate2 = new Estate(null, "S??o Paulo");

		City city1 = new City(null, "Uberl??ndia", estate1);
		City city2 = new City(null, "S??o Paulo",estate2);
		City city3 = new City(null, "Campinas", estate2);

		estate1.getCitys().addAll(Arrays.asList(city1));
		estate2.getCitys().addAll(Arrays.asList(city2, city3));

		estateRepository.saveAll(Arrays.asList(estate1, estate2));
		cityRepository.saveAll(Arrays.asList(city1, city2, city3));
		
		Client client1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PHYSICAL_PERSON);

		client1.getTelephones().addAll(Arrays.asList("27363323", "93838393"));

		Address address1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", client1, city1);
		Address address2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", client1, city2);

		client1.getAdress().addAll(Arrays.asList(address1,address2));

		clientRepository.saveAll(Arrays.asList(client1));
		addressRepository.saveAll(Arrays.asList(address1, address2));

	}

}
