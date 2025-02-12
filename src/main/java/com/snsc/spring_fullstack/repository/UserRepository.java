package com.snsc.spring_fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.snsc.spring_fullstack.model.User;
public interface UserRepository extends JpaRepository <User, Long > {

}
