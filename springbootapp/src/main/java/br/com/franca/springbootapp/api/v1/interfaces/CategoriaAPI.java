package br.com.franca.springbootapp.api.v1.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface CategoriaAPI {

	@RequestMapping(value = "/{id}"
			, method = RequestMethod.GET
			, consumes = { "application/categorias.v1+xml", "application/categorias.v1+json" }
			, produces = { "application/categorias.v1+xml","application/categorias.v1+json" })
	public ResponseEntity<?> findAll(@PathVariable Integer id);

}
