package com.example.study.repository;


import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> //유저 엔티티에 id가 long 으로 만들어서!//
{
    // select * from user wher accouunt = ? << test03, test04
    Optional<User> findByAccount(String account);

    Optional<User> findByEmail(String email);
    
    Optional<User> findByAccountAndEmail(String account, String email);// 쿼리문을 메소드처럼 사용한다하여 쿼리메소드.커멜케이스로 작성해야함

}
