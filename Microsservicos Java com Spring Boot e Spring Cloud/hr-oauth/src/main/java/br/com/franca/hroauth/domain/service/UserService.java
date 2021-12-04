package br.com.franca.hroauth.domain.service;

import br.com.franca.hroauth.client.hruser.IHrUserClient;
import br.com.franca.hroauth.domain.dtos.UserDTO;
import br.com.franca.hroauth.domain.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final IHrUserClient hrUserClient;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDTO dto = hrUserClient.findByEmail(userName);

        if (dto == null) {
            log.error("UserName not found: {} ", userName);
            throw new UsernameNotFoundException("UserName not found");
        }

        log.info("UserName found: {} ", userName);
        return new User(dto);
    }
}
