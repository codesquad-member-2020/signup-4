package com.codesquad.signup4.domain;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
  @Query("SELECT * FROM USER u where u.user_id = :userID")
  User findByUserID(@Param("userID") String userID);

  @Query("SELECT * FROM USER u where u.mobile = :mobile")
  User findByMobile(@Param("mobile") String mobile);

  @Query("SELECT * FROM USER u where u.email = :email")
  User findByEmail(@Param("email") String email);
}
