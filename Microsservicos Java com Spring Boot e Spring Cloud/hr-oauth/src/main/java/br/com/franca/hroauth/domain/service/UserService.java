package br.com.franca.hroauth.domain.service;

import br.com.franca.hroauth.client.hruser.IHrUserClient;
import br.com.franca.hroauth.domain.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final IHrUserClient hrUserClient;

    public UserDTO findByEmail(String email) {
        UserDTO user = hrUserClient.findByEmail(email);

        if (user == null) {
            log.error("Email not found: {} ", email);
            throw new IllegalArgumentException("Email not found");
        }

        log.info("Email found: {} ", email);
        return user;
    }
}
