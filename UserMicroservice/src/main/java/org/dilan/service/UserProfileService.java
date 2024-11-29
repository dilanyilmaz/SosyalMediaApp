package org.dilan.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileRepository {
  private final UserProfileRepository repository;
}
