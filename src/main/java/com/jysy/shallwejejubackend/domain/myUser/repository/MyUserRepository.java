package com.jysy.shallwejejubackend.domain.myUser.repository;

import com.jysy.shallwejejubackend.domain.myUser.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUserName(String userName);
}
