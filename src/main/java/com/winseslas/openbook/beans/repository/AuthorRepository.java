package com.winseslas.openbook.beans.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.winseslas.openbook.beans.interfaces.AuthorInterface;
import com.winseslas.openbook.beans.models.Author;
import com.winseslas.openbook.database.Database;


/**
 *
 * The repository for author data
 *
 * This class is thread-safe.
 * @author Winseslas
 */
public class AuthorRepository implements AuthorInterface {

    private Connection connect;

    public AuthorRepository() throws SQLException {
        Database db = new Database();
        connect = db.getConnection();
    }

    @Override
    public synchronized List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT * FROM authors";
        Statement statement = null;
        ResultSet result = null;
        
        try {
			statement = connect.createStatement();
			result = statement.executeQuery(sql);
			
			while (result.next()) {
                Author author = new Author();
                author.setId(result.getInt("id_author"));
                author.setName(result.getString("name"));
                author.setNationality(result.getString("nationality"));
                authors.add(author);
			}
                
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return authors;
    }

    @Override
    public synchronized Author findById(int id) {
        Author author = null;
        String sql = "SELECT * FROM authors WHERE id_author=?";
       
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    author = new Author();
                    author.setId(rs.getInt("id_author"));
                    author.setName(rs.getString("name"));
                    author.setNationality(rs.getString("nationality"));
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return author;
    }

    @Override
    public synchronized void create(Author author) {
        String sql = "INSERT INTO authors (name, nationality) VALUES (?, ?)";
       
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, author.getName());
            pstmt.setString(2, author.getNationality());
            pstmt.executeUpdate();
        }
    catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public synchronized void update(Author author) {
        String sql = "UPDATE authors SET name=?, nationality=? WHERE id_author=?";
        
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, author.getName());
            pstmt.setString(2, author.getNationality());
            pstmt.setInt(3, author.getId());
            pstmt.executeUpdate();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }

    }

    @Override
    public synchronized void delete(int id) {
         String sql = "DELETE FROM authors WHERE id_author=?";
       
         try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
             pstmt.setInt(1, id);
             pstmt.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
