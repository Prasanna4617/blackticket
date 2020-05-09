package com.project.fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fullstack.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
