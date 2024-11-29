package org.dilan.repository;

import org.dilan.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends MyGenericRepository<Auth,Long> {

  Boolean existsByUserNameAndPassword(String userName, String password);
}
