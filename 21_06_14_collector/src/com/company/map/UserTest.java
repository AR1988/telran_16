package com.company.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserTest {

    List<User> users = Arrays.asList(
            new User("eamil1@email.com"),
            new User("eamil2@email.com"),
            new User("eamil3@email.com"),
            new User("eamil4@email.com")
    );

    @Test
    public void test_convertUserToAuthUser() {
        List<AuthUser> authUsers = users.stream()
                .map(user -> new AuthUser(user.getEmail(), "admin"))
                .collect(Collectors.toList());

        Assert.assertEquals("eamil1@email.com", authUsers.get(0).getEmail());
        Assert.assertEquals("admin", authUsers.get(0).getRole());

        Assert.assertEquals("eamil2@email.com", authUsers.get(1).getEmail());
        Assert.assertEquals("admin", authUsers.get(1).getRole());

        Assert.assertEquals("eamil3@email.com", authUsers.get(2).getEmail());
        Assert.assertEquals("admin", authUsers.get(2).getRole());
    }
}
