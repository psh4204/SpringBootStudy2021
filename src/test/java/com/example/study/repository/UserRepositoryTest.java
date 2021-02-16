package com.example.study.repository;


// 밑에 자동생성된 아이를 상속받고 시작.

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    // 스프링의 가장큰 장점이자 디자인패턴
    // 의존성 줄?
    // Autowired!!!
    // - 직접 객체들을 우리가 만들어 관리하는게 아니라
    //   스프링 부트에서 자동으로 관리해주는 의존성 주입 기능.
    // --> DI = Dependency Injection

    @Autowired
    private UserRepository userRepository;
    // --> 요놈 싱글톤 디자인패턴인뎅..?

    @Test
    public void create(){

        // String sql = insert into user(%s, %s, %d) value( account, email, asdf)
        // JPA는 이렇게 안함
        // user라는 값들을 데이터베이스에 넣을것임

        User user = new User();
        // 싱글톤 디자인 패턴이란? 하나의 객체만 생성해놓고 그 하나로만 관리하는 것.

        user.setAccount("TestUser03");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser03");

        User newUser = userRepository.save(user);// S를 받고 리턴을 해줌. 반환형은 해당메서드 형으로..!
        System.out.println("newUser : " + newUser);
        //롬복이 User에 @Data를 통해 toString 으로 리턴값을 엄청 깔끔하게 만들어줌.
    }

    @Test
    public void read(){ // 개어렵누.. 옵셔널이 머고 _ 옵셔널 공부 바람(0202)
        Optional<User> user = userRepository.findByAccount("TestUser03");// 타임이 long타입이어서


        user.ifPresent(selectUser->{
            System.out.println("user" + selectUser);
            System.out.println("email" + selectUser.getEmail());

        });
    }

    @Test
    public void update(){

        // select * from
        Optional<User> user = userRepository.findByAccount("TestUser03");// 타임이 long타입이어서

        user.ifPresent(selectUser->{
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

    @Test
    //@Transactional // 기존과 마찬가지로 아래의 메소드는 실행이 되대, 실제로 데이터가 삭제되고 그런건 없게 하는것.롤백해줌.
    public void delete(){
        Optional<User> user = userRepository.findById(11L);

        Assert.assertTrue(user.isPresent());
        // 삭제할려면 ()에 친구가 무조건 True여야한다.(Null값아니죠?= isParesent)

        user.ifPresent(selectUser->{
           userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(11L);

        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : "+ deleteUser.get());
        } else{
            System.out.println("데이터 삭제 데이터 없음");

            Assert.assertFalse(deleteUser.isPresent()); //위에서 삭제를 했으니까 false 여야 함.
        }
    }
}
