package com.codesquad.signup4.domain;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
  @Query("SELECT * FROM USER u where u.user_iD = :userID")
  User findByUserID(@Param("userID") String userID);
}
