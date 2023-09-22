package web.Service;

import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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


    public User updateUser(User user) {
        userDAO.updateUser(user);
        return user;
    }

    @Override
    public User createUser(User user) {
        userDAO.createUser(user);
        return user;
    }


    @Override
    public User deleteUser(long id) {
        User user = null;
        try {
            user = userDAO.deleteUser(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return user;
    }
}
