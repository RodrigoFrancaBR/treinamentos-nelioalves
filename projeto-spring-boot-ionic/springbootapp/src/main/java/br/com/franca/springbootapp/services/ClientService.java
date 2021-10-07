package br.com.franca.springbootapp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.franca.springbootapp.domain.Client;
import br.com.franca.springbootapp.repository.ClientRepository;
import br.com.franca.springbootapp.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	private ClientRepository ClientRepository;

	public ClientService(ClientRepository ClientRepository) {
		this.ClientRepository = ClientRepository;
	}

	public Client find(Integer id) {
		Optional<Client> Client = ClientRepository.findById(id);
		return Client.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));		
	}

}
