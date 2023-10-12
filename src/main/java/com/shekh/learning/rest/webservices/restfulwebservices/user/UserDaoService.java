package com.shekh.learning.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    //JPA/Hibernate > Database
    //UserDaoService > Static List

    private static List<User> users = new ArrayList<>();
    private static int counter = 0;

    static {
        users.add(new User(++counter, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++counter, "Shekh", LocalDate.now().minusYears(34)));
        users.add(new User(++counter, "John", LocalDate.now().minusYears(32)));
        users.add(new User(++counter, "Sam", LocalDate.now().minusYears(22)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++counter);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
