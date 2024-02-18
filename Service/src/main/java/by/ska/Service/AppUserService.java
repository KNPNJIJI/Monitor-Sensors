package by.ska.Service;

import by.ska.Model.dao.AppUserDao;
import by.ska.Model.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"by.itacademy.dao"})
public class AppUserService {

    @Autowired
    AppUserDao appUserDao;

    public List<AppUser> findUserByUsername(String username) {
        return appUserDao.findByUserName(username);
    }
}
