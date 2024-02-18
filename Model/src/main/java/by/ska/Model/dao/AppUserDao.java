package by.ska.Model.dao;

import by.ska.Model.model.AppUser;

import java.util.List;

public interface AppUserDao {

    List<AppUser> findByUserName(String username);
}
