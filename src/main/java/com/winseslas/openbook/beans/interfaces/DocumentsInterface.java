package com.winseslas.openbook.beans.interfaces;

import java.util.List;

import com.winseslas.openbook.beans.models.Documents;

public interface DocumentsInterface {
    List<Documents> findAll();
    
    List<Documents> findByTitle(String title);
    
    List<Documents> findByAuthor(String authorName);
    
    List<Documents> findByType(String type);
    
    Documents findById(int id);
    
    boolean create(Documents document);
    
    boolean update(Documents document);
    
    boolean delete(int id);
}
