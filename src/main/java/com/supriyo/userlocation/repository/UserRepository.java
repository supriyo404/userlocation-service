package com.supriyo.userlocation.repository;

import com.supriyo.userlocation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
