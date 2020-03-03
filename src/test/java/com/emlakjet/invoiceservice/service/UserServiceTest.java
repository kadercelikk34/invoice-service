package com.emlakjet.invoiceservice.service;

import com.emlakjet.invoiceservice.entity.User;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    UserServiceImpl userService;

    @Test
    public void testCreatedUserInit() {
        User saveUser = new User();
        saveUser.setFirstName("John");
        saveUser.setLastName("Depp");
        saveUser.setUsername("johndepp@gmail.com");
        saveUser.setPassword("john12345");
        userService.save(saveUser);
        User user = userService.findByUsername(saveUser.getUsername());
        MatcherAssert.assertThat(user.getUsername(), Matchers.equalTo(saveUser.getUsername()));
        MatcherAssert.assertThat(user.getFirstName(), Matchers.equalTo(saveUser.getFirstName()));
        MatcherAssert.assertThat(user.getLastName(), Matchers.equalTo(saveUser.getLastName()));

    }
    @Test
    public void testFindByUsername() {
        User user = userService.findByUsername("john@doe.com");
        MatcherAssert.assertThat(user.getFirstName(), Matchers.equalTo("John"));
        MatcherAssert.assertThat(user.getLastName(), Matchers.equalTo("Doe"));
    }
}
