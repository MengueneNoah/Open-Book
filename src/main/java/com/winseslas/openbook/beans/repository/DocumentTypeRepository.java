package com.winseslas.openbook.beans.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winseslas.openbook.beans.interfaces.DocumentTypeInterface;
import com.winseslas.openbook.beans.models.DocumentType;
import com.winseslas.openbook.database.Database;

public class DocumentTypeRepository implements DocumentTypeInterface {
	
	private Connection connect;

    public DocumentTypeRepository() throws SQLException {
        Database db = new Database();
        connect = db.getConnection();
    }


	@Override
	public void create(DocumentType documentType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DocumentType documentType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DocumentType findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<DocumentType> findAll() {
	    List<DocumentType> documentTypes = new ArrayList<>();
	    String query = "SELECT DISTINCT * FROM document_type";

	    try {
	    	Statement statement = connect.createStatement();
	        ResultSet rs = statement.executeQuery(query);
	        
	        while (rs.next()) {
	            DocumentType documentType = new DocumentType();
	            documentType.setId(rs.getInt("id_type_doc"));
	            documentType.setLibelle(rs.getString("libelle_type_doc"));
	            documentTypes.add(documentType);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return documentTypes;
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
