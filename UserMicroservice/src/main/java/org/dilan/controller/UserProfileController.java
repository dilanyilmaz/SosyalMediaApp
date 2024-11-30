package org.dilan.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.dilan.document.UserProfile;
import org.dilan.dto.request.CreateUserRequestDto;
import org.dilan.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.dilan.config.RestApi.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(USER_PROFILE)
public class UserProfileController {
  private final UserProfileService userProfileService;

  @PostMapping(CREATE_USER)
  public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto){
    userProfileService.createUser(dto);
    return ResponseEntity.ok(true);
  }
  @GetMapping(GET_ALL)
  public ResponseEntity<List<UserProfile>> getAll(){
    return ResponseEntity.ok(userProfileService.getAll());
  }
  @GetMapping("/upper-name")
  public ResponseEntity<String> upperName(String name){
    return ResponseEntity.ok(userProfileService.upperName(name));
  }
}
