package br.com.franca.springbootapp.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.springbootapp.domain.Client;
import br.com.franca.springbootapp.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	private ClientService ClientService;

	public ClientResource(ClientService ClientService) {
		this.ClientService = ClientService;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findAll(@PathVariable Integer id) {

		Client Client = ClientService.find(id);

		return ResponseEntity.ok().body(Client);

	}

}
