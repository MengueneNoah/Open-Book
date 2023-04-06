package com.winseslas.openbook.beans.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.winseslas.openbook.beans.interfaces.PublishingHouseInterface;
import com.winseslas.openbook.beans.models.PublishingHouse;
import com.winseslas.openbook.database.Database;

/**
*
* The repository for Publishing house data
*
* This class is thread-safe.
* @author Winseslas
*/
public class PublishingHouseRepository implements PublishingHouseInterface {

	private Connection connect;
	private PreparedStatement pstmt;
	private ResultSet result;
	
	public PublishingHouseRepository() throws SQLException {
		Database db = new Database();
        connect = db.getConnection();
	}

	@Override
	public synchronized void create(PublishingHouse publishingHouse) {
	    String name = publishingHouse.getName();
	    
	    Optional<PublishingHouse> existingPublishingHouse = this.findByName(name);
	    
	    if (existingPublishingHouse.isPresent()) {
	        throw new IllegalArgumentException("A publishing house with this name already exists.");
	    }

	    String query = "INSERT INTO publishing_house (name, country) VALUES (?, ?)";
	    try {
	        pstmt = connect.prepareStatement(query);
	        pstmt.setString(1, name);
	        pstmt.setString(2, publishingHouse.getCountry());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public synchronized void update(PublishingHouse publishingHouse) {
	    // Check if publishing house with the same name exists
	    Optional<PublishingHouse> existingPublishingHouse = findByName(publishingHouse.getName());
	    if (existingPublishingHouse.isPresent() && existingPublishingHouse.get().getId() != publishingHouse.getId()) {
	    	throw new IllegalArgumentException("A publishing house with this name already exists.");
	    }

	    // Update table structure if necessary
	    try {
	        DatabaseMetaData meta = (DatabaseMetaData) connect.getMetaData();
	         result = meta.getColumns(null, null, "publishing_house", "address");
	        if (!result.next()) {
	            String query = "ALTER TABLE publishing_house ADD COLUMN address VARCHAR(100) NULL AFTER name_publishing_house";
	            pstmt = connect.prepareStatement(query);
	            pstmt.executeUpdate();
	        }
	        result.close();

	        result = meta.getColumns(null, null, "publishing_house", "city");
	        if (!result.next()) {
	            String query = "ALTER TABLE publishing_house ADD COLUMN city VARCHAR(50) NULL AFTER address";
	            pstmt = connect.prepareStatement(query);
	            pstmt.executeUpdate();
	        }
	        result.close();

	        result = meta.getColumns(null, null, "publishing_house", "country");
	        if (!result.next()) {
	            String query = "ALTER TABLE publishing_house ADD COLUMN country VARCHAR(50) NULL AFTER city";
	            pstmt = connect.prepareStatement(query);
	            pstmt.executeUpdate();
	        }
	        result.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Update publishing house
	    String query = "UPDATE publishing_house SET name_publishing_house = ?, address = ?, city = ?, country = ? WHERE id_publishing_house = ?";
	    try {
	        pstmt = connect.prepareStatement(query);
	        pstmt.setString(1, publishingHouse.getName());
	        pstmt.setString(2, publishingHouse.getAddress());
	        pstmt.setString(3, publishingHouse.getCity());
	        pstmt.setString(4, publishingHouse.getCountry());
	        pstmt.setInt(5, publishingHouse.getId());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	
	@Override
	public synchronized void delete(PublishingHouse publishingHouse) {
	    String query = "DELETE FROM publishing_house WHERE id_publishing_house = ?";
	    try {
	        pstmt = connect.prepareStatement(query);
	        pstmt.setInt(1, publishingHouse.getId());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public List<PublishingHouse> findAll() {
	    List<PublishingHouse> publishingHouses = new ArrayList<>();
	    String query = "SELECT * FROM publishing_house";
	    try {
	        pstmt = connect.prepareStatement(query);
	        result = pstmt.executeQuery();
	        while (result.next()) {
	            PublishingHouse publishingHouse = new PublishingHouse();
	            publishingHouse.setId(result.getInt("id_publishing_house"));
	            publishingHouse.setName(result.getString("name_publishing_house"));
	            publishingHouse.setAddress(result.getString("address"));
	            publishingHouse.setCity(result.getString("city"));
	            publishingHouse.setCountry(result.getString("country"));
	            publishingHouses.add(publishingHouse);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return publishingHouses;
	}

	@Override
	public  Optional<PublishingHouse> findById(int id) {
	    PublishingHouse publishingHouse = null;
	    String sql = "SELECT * FROM publishing_house WHERE id_publishing_house=?";
	    try {
	        pstmt = connect.prepareStatement(sql);
	        pstmt.setInt(1, id);
	        result = pstmt.executeQuery();
	        if (result.next()) {
	            publishingHouse = new PublishingHouse();
	            publishingHouse.setId(result.getInt("id_publishing_house"));
	            publishingHouse.setName(result.getString("name_publishing_house"));
	            publishingHouse.setAddress(result.getString("address"));
	            publishingHouse.setCity(result.getString("city"));
	            publishingHouse.setCountry(result.getString("country"));
	        }
	    } catch (SQLException se) {
	        se.printStackTrace();
	    }
	    return Optional.ofNullable(publishingHouse);
	}

	
	
	@Override
	public synchronized Optional<PublishingHouse> findByName(String name) {
	    PublishingHouse publishingHouse = null;
	    String sql = "SELECT * FROM publishing_house WHERE name=?";
	        
	    try {
	        pstmt = connect.prepareStatement(sql);
	        pstmt.setString(1, name);
	        result = pstmt.executeQuery();
	             
	        if (result.next()) {
	            publishingHouse = new PublishingHouse();
	            publishingHouse.setId(result.getInt("id_publishing_house"));
	            publishingHouse.setName(result.getString("name"));
	            publishingHouse.setAddress(result.getString("address"));
	            publishingHouse.setCity(result.getString("city"));
	            publishingHouse.setCountry(result.getString("country"));
	        }
	            
	    } catch (SQLException se) {
	        se.printStackTrace();
	    }
	        
	    return Optional.ofNullable(publishingHouse);
	}

	
}