package com.dimple.dao;

import com.dimple.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("mark.jones@gmail.com");
        user.setFirstName("Mark");
        user.setLastName("Jones");
        user.setPassword("mark.jones2020");

        User savedUser = userRepository.save(user);
        User existUser = testEntityManager.find(User.class, savedUser.getId());
        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email =  "jack.peterson@gmail.com";
        User user = userRepository.findByEmail(email);
        assertThat(user).isNotNull();
    }

}
