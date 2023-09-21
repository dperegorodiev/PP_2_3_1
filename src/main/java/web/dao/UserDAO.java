package web.dao;

import org.hibernate.mapping.List;
import web.model.User;

public interface UserDAO {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User readUser(long id);

    User deleteUser(long id);
}
