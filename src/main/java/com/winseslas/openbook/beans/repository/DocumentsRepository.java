package com.winseslas.openbook.beans.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.winseslas.openbook.beans.interfaces.DocumentsInterface;
import com.winseslas.openbook.beans.models.Author;
import com.winseslas.openbook.beans.models.DocumentType;
import com.winseslas.openbook.beans.models.Documents;
import com.winseslas.openbook.beans.models.PublishingHouse;
import com.winseslas.openbook.database.Database;


/**
 *
 * The repository for document data
 *
 * This class is thread-safe.
 * @author Winseslas
 */
public class DocumentsRepository implements DocumentsInterface {

    private Connection connect;

    public DocumentsRepository() throws SQLException {
        Database db = new Database();
        connect = db.getConnection();
    }

    @Override
    public synchronized List<Documents> findAll() {
        List<Documents> documents = new ArrayList<>();
        String sql = "SELECT d.*, t.*, a.*, p.* "
        		+ "	FROM Documents d"
        		+ "	INNER JOIN document_type t ON d.id_type_doc = t.id_type_doc"
        		+ "	INNER JOIN authors a ON d.id_author = a.id_author"
        		+ "	INNER JOIN publishing_house p ON d.id_publishing_house = p.id_publishing_house;";
        try {
        	Statement statement = connect.createStatement();
        	ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                Documents document = new Documents();
                
                document.setId(result.getInt("id_doc"));
                document.setTitle(result.getString("document_title"));
                
                DocumentType documentType = new DocumentType();
                documentType.setId(result.getInt("id_type_doc"));
                documentType.setLibelle(result.getString("libelle_type_doc"));
                
                document.setType(documentType);
                
                Author author = new Author();
                author.setId(result.getInt("id_author"));
                author.setName(result.getString("name"));
                author.setNationality(result.getString("nationality"));
                document.setAuthor(author);
                
                PublishingHouse publishingHouse = new PublishingHouse();
                publishingHouse.setId(result.getInt("id_publishing_house"));
                publishingHouse.setName(result.getString("name_publishing_house"));
                publishingHouse.setAddress(result.getString("address"));
                publishingHouse.setCity(result.getString("city"));
                publishingHouse.setCountry(result.getString("country"));
                
                document.setPublishingHouse(publishingHouse);                
                document.setPublicationDate(result.getTimestamp("date_publication").toLocalDateTime().toLocalDate());
                document.setSummary(result.getString("resume"));               
                documents.add(document);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return documents;
    }

	@Override
	public List<Documents> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Documents> findByAuthor(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Documents> findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Documents findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Documents document) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Documents document) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}
