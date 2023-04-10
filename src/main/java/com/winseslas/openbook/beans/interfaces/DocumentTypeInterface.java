package com.winseslas.openbook.beans.interfaces;

import com.winseslas.openbook.beans.models.DocumentType;

import java.util.List;

public interface DocumentTypeInterface {
    public void create(DocumentType documentType);
    public void update(DocumentType documentType);
    public DocumentType findById(int id);
    public List<DocumentType> findAll();
    public void delete(int id);
}
