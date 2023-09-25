package web.Service;

import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    @Override
    public User readUser(long id) {
        return userDAO.readUser(id);
    }

    @Transactional
    public User updateUser(User user) {
        userDAO.updateUser(user);
        return user;
    }
    @Transactional
    @Override
    public User createUser(User user) {
        userDAO.createUser(user);
        return user;
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }
}
