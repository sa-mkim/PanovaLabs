package com.PanovaLabs.shop_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PanovaLabs.shop_platform.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
