package com.tenoke.cloud.core.repository;

import com.tenoke.cloud.core.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jerrylau
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
