package com.winseslas.openbook.beans.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winseslas.openbook.beans.interfaces.UserInterface;
import com.winseslas.openbook.beans.models.Author;
import com.winseslas.openbook.beans.models.User;
import com.winseslas.openbook.database.Database;



public class UserRepository implements UserInterface {
	private Connection connect;

    public UserRepository() throws SQLException {
        Database db = new Database();
        connect = db.getConnection();
    }

	@Override
	public User findById(int id) {
		
		User user = null;
        String sql = "SELECT * FROM users WHERE id_author=?";
       
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                   user = new User();
                    user.setId(rs.getInt("id_user"));
                    user.setName(rs.getString("fullname"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return user;
	}

	@Override
	public List<User> findAll() {
		 List<User> users = new ArrayList<>();
	        String sql = "SELECT * FROM users";
	        Statement statement = null;
	        ResultSet result = null;
	        
	        try {
				statement = connect.createStatement();
				result = statement.executeQuery(sql);
				
				while (result.next()) {
	                User user = new User();
	                user.setId(result.getInt("id_user"));
	                user.setName(result.getString("fullname"));
	                user.setEmail(result.getString("email"));
	                user.setPassword(result.getString("password"));
	                users.add(user);
				}
	                
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
	        return users;
	}

	@Override
	public void create(User user) {
		String sql = "INSERT INTO users (fullname,email,password ) VALUES (?, ?, ?)";
	       
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();
        }
    catch (SQLException se) {
            se.printStackTrace();
        }
		
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE users SET fullname=?, email=?, password=? WHERE id_user=?";
        
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4, user.getId());
            pstmt.executeUpdate();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }


	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM WHERE id_user=?";
	       
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
       } catch (SQLException se) {
           se.printStackTrace();
       }
   }
	
	
	

}
