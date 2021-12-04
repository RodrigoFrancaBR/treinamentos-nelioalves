package br.com.franca.hroauth.client.hruser;

import br.com.franca.hroauth.domain.dtos.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hr-user", path = "${hr-user.path}")
public interface IHrUserClient {

    @GetMapping(path = "/emails")
    UserDTO findByEmail(@RequestParam String email);
}
