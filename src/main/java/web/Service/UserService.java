package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User readUser(long id);

    User deleteUser(long id);

    User updateUser (User user);

    User createUser(User user);
}
