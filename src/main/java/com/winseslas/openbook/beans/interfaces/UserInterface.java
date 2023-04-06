package com.winseslas.openbook.beans.interfaces;

import java.util.List;
import java.util.Optional;

import com.winseslas.openbook.beans.enums.Role;
import com.winseslas.openbook.beans.models.User;

public interface UserInterface {
    
    User findById(int id);
    Optional<User> findByEmail(String email);
    
    List<User> findAll();    
    List<User> findByRole(Role role);
    List<User> findByFullnameContainingIgnoreCase(String name);
    List<User> findByFullnameContainingIgnoreCaseAndRole(String name, Role role);
    
    void create(User user);
    void update(User user);
    void delete(int id);
    void deleteByRole(Role role);
    
    /**
     * Finds a user with the given email and password.
     * 
     * @param email the email of the user
     * @param password the password of the user
     * @return an optional containing the user if found, empty otherwise
     */
    Optional<User> findByEmailAndPassword(String email, String password);
    
    /**
     * Updates the password of the user with the given ID.
     * 
     * @param id the ID of the user
     * @param newPassword the new password
     */
    void updatePassword(int id, String newPassword);
    
    /**
     * Deletes all users with the given role.
     * 
     * @param role the role of the users to delete
     */
    void deleteAllByRole(Role role);
    
}
