package org.dilan.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.dilan.document.UserProfile;
import org.dilan.dto.request.CreateUserRequestDto;
import org.dilan.repository.UserProfileRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {
  private final UserProfileRepository repository;

  public void createUser(CreateUserRequestDto dto) {
    repository.save(UserProfile.builder()
            .authId(dto.getAuthId())
            .userName(dto.getUsername())
            .email(dto.getEmail())
        .build());
  }

  public List<UserProfile> getAll() {
    return repository.findAll();
  }

  @Cacheable("upper-case")
  public String upperName(String name){
    String result = name.toUpperCase();
    try{
      Thread.sleep(3000L);
    }catch (Exception exception){}
    return result;
  }
}
