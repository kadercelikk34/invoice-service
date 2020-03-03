package com.emlakjet.invoiceservice.repository;

import com.emlakjet.invoiceservice.entity.User;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        User user = userRepository.findByUsername("john@doe.com");
        MatcherAssert.assertThat(user.getFirstName(), Matchers.equalTo("John"));
        MatcherAssert.assertThat(user.getLastName(), Matchers.equalTo("Doe"));

    }
}
