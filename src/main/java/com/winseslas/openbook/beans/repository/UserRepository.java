package com.winseslas.openbook.beans.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;

import com.winseslas.openbook.beans.enums.Role;
import com.winseslas.openbook.beans.interfaces.UserInterface;
import com.winseslas.openbook.beans.models.User;
import com.winseslas.openbook.database.Database;

/**
 * The repository for user data
 * 
 * This class is thread-safe.
 * 
 * @author Winseslas
 */
public class UserRepository implements UserInterface {

    private Connection connect;
    private Statement statement;
    private ResultSet result;
    private PreparedStatement pstmt;

    public UserRepository() throws SQLException {
        Database db = new Database();
        connect = db.getConnection();
    }

	@Override
	public synchronized User findById(int id) {
		User user = null;
		String sql = "SELECT * FROM users WHERE id_user=?";
	    
		try {
			pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeQuery();
			         
			if (result.next()) {
			    user = new User();
			    user.setId(result.getInt("id_user"));
			    user.setEmail(result.getString("email"));
			    user.setPassword(result.getString("password"));
			    user.setFullName(result.getString("fullname"));
			    user.setRole(Role.valueOf(result.getString("role")));
		    }
		    
		} catch (SQLException se) {
		    se.printStackTrace();
		}
			
		return user;
	}

	@Override
	public synchronized Optional<User> findByEmail(String email) {
		 User user = null;
		 String sql = "SELECT * FROM users WHERE email=?";       

		 try {
			 pstmt = connect.prepareStatement(sql);
			 pstmt.setString(1, email);
			 result = pstmt.executeQuery();
			 
			 if (result.next()) {
		         user = new User();
		         user.setId(result.getInt("id_user"));
			     user.setEmail(result.getString("email"));
			     user.setPassword(result.getString("password"));
			     user.setFullName(result.getString("fullname"));
			     user.setRole(Role.valueOf(result.getString("role")));
			 }
		} catch (SQLException se) {
		    se.printStackTrace();
		}
		return Optional.ofNullable(user);
	}

	@Override
	public synchronized List<User> findAll() {
		List<User> users = new ArrayList<>(); 
        String sql = "SELECT * FROM users";
        
	        try {
	        	statement = connect.createStatement();
	            result = statement.executeQuery(sql);

	            while (result.next()) {
	                User user = new User();
	                user.setId(result.getInt("id_user"));
	                user.setEmail(result.getString("email"));
	                user.setPassword(result.getString("password"));
	                user.setFullName(result.getString("fullname"));
	                user.setRole(Role.valueOf(result.getString("role")));
	                users.add(user);
	            }
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
	        return users;
	}

	@Override
	public synchronized List<User> findByRole(Role role) {
	    List<User> users = new ArrayList<>();
	    String sql = "SELECT * FROM users WHERE role=?";

	    try {
	        pstmt = connect.prepareStatement(sql);
	        pstmt.setString(1, role.toString());
	        result = pstmt.executeQuery();

	        while (result.next()) {
	            User user = new User();
	            user.setId(result.getInt("id_user"));
	            user.setEmail(result.getString("email"));
	            user.setPassword(result.getString("password"));
	            user.setFullName(result.getString("fullname"));
	            user.setRole(Role.valueOf(result.getString("role")));
	            users.add(user);
	        }
	    } catch (SQLException se) {
	        se.printStackTrace();
	    }
	    return users;
	}


	@Override
	public synchronized List<User> findByFullnameContainingIgnoreCase(String name) {
	    List<User> users = new ArrayList<>();
	    String sql = "SELECT * FROM users WHERE LOWER(fullname) LIKE ?";
	    
	    try {
	        pstmt = connect.prepareStatement(sql);
	        pstmt.setString(1, "%" + name.toLowerCase() + "%");
	        result = pstmt.executeQuery();

	        while (result.next()) {
	            User user = new User();
	            user.setId(result.getInt("id_user"));
	            user.setEmail(result.getString("email"));
	            user.setPassword(result.getString("password"));
	            user.setFullName(result.getString("fullname"));
	            user.setRole(Role.valueOf(result.getString("role")));
	            users.add(user);
	        }
	    } catch (SQLException se) {
	        se.printStackTrace();
	    }
	    return users;
	}


	@Override
	public synchronized List<User> findByFullnameContainingIgnoreCaseAndRole(String name, Role role) {
	    List<User> users = new ArrayList<>();
	    String sql = "SELECT * FROM users WHERE LOWER(fullname) LIKE ? AND role = ?";

	    try {
	        pstmt = connect.prepareStatement(sql);
	        pstmt.setString(1, "%" + name.toLowerCase() + "%");
	        pstmt.setString(2, role.toString());
	        result = pstmt.executeQuery();

	        while (result.next()) {
	            User user = new User();
	            user.setId(result.getInt("id_user"));
	            user.setEmail(result.getString("email"));
	            user.setPassword(result.getString("password"));
	            user.setFullName(result.getString("fullname"));
	            user.setRole(Role.valueOf(result.getString("role")));
	            users.add(user);
	        }
	    } catch (SQLException se) {
	        se.printStackTrace();
	    }

	    return users;
	}


	@Override
	public synchronized void create(User user) {
	    String sql = "INSERT INTO users (email, password, fullname, role) VALUES (?, ?, ?, ?)";

	    try {
	        // Check if email already exists
	        String selectSql = "SELECT * FROM users WHERE email = ?";
	        PreparedStatement selectStmt = connect.prepareStatement(selectSql);
	        selectStmt.setString(1, user.getEmail());
	        ResultSet rs = selectStmt.executeQuery();
	        if (rs.next()) {
	            // Email already exists, throw exception or handle error
	            throw new SQLException("Email already exists");
	        }

	        // Insert new user
	        pstmt = connect.prepareStatement(sql);
	        pstmt.setString(1, user.getEmail());
	        pstmt.setString(2, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
	        pstmt.setString(3, user.getFullName());
	        pstmt.setString(4, user.getRole().toString());
	        pstmt.executeUpdate();
	    } catch (SQLException se) {
	        se.printStackTrace();
	    }
	}


	@Override
	public synchronized void update(User user) {
	    String sql = "UPDATE users SET email=?, fullname=?, role=? WHERE id_user=?";
	    
	    try {
	        // Check if the new email is already in use by another user
	        Optional<User> existingUser = findByEmail(user.getEmail());
	        if (existingUser.isPresent() && existingUser.get().getId() != user.getId()) {
	            throw new SQLException("E-mail already in use");
	        }
	        
	        pstmt = connect.prepareStatement(sql);
	        pstmt.setString(1, user.getEmail());
	        pstmt.setString(2, user.getFullName());
	        pstmt.setString(3, user.getRole().name());
	        pstmt.setInt(4, user.getId());
	        pstmt.executeUpdate();
	        
	    } catch (SQLException se) {
	        se.printStackTrace();
	    }
	}


	@Override
	public synchronized void delete(int id) {
	    // On définit la requête SQL de suppression d'un utilisateur en utilisant son id
	    String sql = "DELETE FROM users WHERE id_user=?";
	    
	    try {
	        // On prépare la requête SQL
	        pstmt = connect.prepareStatement(sql);
	        // On remplit les paramètres de la requête SQL avec l'identifiant de l'utilisateur à supprimer
	        pstmt.setInt(1, id);
	        // On exécute la requête SQL
	        pstmt.executeUpdate();
	        
	    } catch (SQLException se) {
	        se.printStackTrace();
	    }
	}


	@Override
	public synchronized void deleteByRole(Role role) {
	    // On récupère tous les utilisateurs ayant le rôle spécifié
	    List<User> usersToDelete = this.findByRole(role);

	    // On parcourt la liste des utilisateurs à supprimer
	    for (User user : usersToDelete) {
	        // On supprime chaque utilisateur de la base de données
	        this.delete(user.getId());
	    }
	}


	@Override
	public synchronized Optional<User> findByEmailAndPassword(String email, String password) {
	    Optional<User> user = this.findByEmail(email);
	    if (user.isPresent() && BCrypt.checkpw(password, user.get().getPassword())) {
	        return user;
	    }
	    return Optional.empty();
	}


	@Override
	public synchronized void updatePassword(int id, String newPassword) {
	    Optional<User> userOptional = Optional.ofNullable(this.findById(id));
	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	        user.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
	        this.update(user);
	    }
	}


	@Override
	public synchronized void deleteAllByRole(Role role) {
	    String sql = "DELETE FROM users WHERE role = ?";

	    try {
	        pstmt = connect.prepareStatement(sql);
	        pstmt.setString(1, role.toString());
	        pstmt.executeUpdate();
	    } catch (SQLException se) {
	        se.printStackTrace();
	    }
	}


}