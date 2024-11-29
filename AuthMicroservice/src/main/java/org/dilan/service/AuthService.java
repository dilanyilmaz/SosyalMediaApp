package org.dilan.service;

import lombok.RequiredArgsConstructor;
import org.dilan.AuthApplication;
import org.dilan.dto.request.CreateUserRequestDto;
import org.dilan.dto.request.LoginRequestDto;
import org.dilan.dto.request.RegisterRequestDto;
import org.dilan.entity.Auth;
import org.dilan.manager.UserProfileManager;
import org.dilan.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final AuthRepository repository;
  private final UserProfileManager userProfileManager;

  public Auth register(RegisterRequestDto dto) {
    Auth auth = repository.save(Auth.builder()
          .userName(dto.getUserName())
          .email(dto.getEmail())
          .password(dto.getPassword())
        .build());
    userProfileManager.createUser(CreateUserRequestDto.builder()
          .authId(auth.getId())
          .email(auth.getEmail())
          .username(auth.getUserName())
        .build());
    return auth;

  }

  public Boolean login(LoginRequestDto dto) {
    return repository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());

  }
}
