package com.winseslas.openbook.beans.interfaces;

import java.util.List;

import com.winseslas.openbook.beans.models.User;

public interface UserInterface {
	
	User findById(int id);
    List<User> findAll();
    void create(User user);
    void update(User user);
    void delete(int id);

}
