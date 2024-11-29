package org.dilan.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.dilan.dto.request.LoginRequestDto;
import org.dilan.dto.request.RegisterRequestDto;
import org.dilan.entity.Auth;
import org.dilan.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  static org.dilan.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto dto){
      if(!dto.getRepassword().equals(dto.getRepassword()))
        throw new RuntimeException("Şifreler uyuşmuyor.");
      return ResponseEntity.ok(authService.register(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto dto){
      return ResponseEntity.ok(authService.login(dto));
    }
}
