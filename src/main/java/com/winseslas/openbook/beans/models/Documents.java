package com.winseslas.openbook.beans.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A document entity representing a book, article, etc.
 * 
 * Contains a unique identifier, a document title, a document type, an author, 
 * a publishing house, a publication date, and a summary.
 * 
 * This version of the model uses LocalDate instead of Date for the publicationDate field.
 * 
 * @author Winseslas
 */
@Entity
@Table(name = "documents")
public class Documents {
    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doc")
    private int id;

    @Column(name = "document_title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_type_doc", foreignKey = @ForeignKey(name = "FK_Documents_DocumentType"))
    private DocumentType type;

    @ManyToOne
    @JoinColumn(name = "id_author", foreignKey = @ForeignKey(name = "FK_Documents_Authors"))
    private Author author;

    @ManyToOne
    @JoinColumn(name = "id_publishing_house", foreignKey = @ForeignKey(name = "FK_Documents_PublishingHouse"))
    private PublishingHouse publishingHouse;

    @Column(name = "date_publication")
    private LocalDate publicationDate;

    @Column(name = "resume")
    private String summary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    public String getImageUrl() {
    	return "https://img.freepik.com/free-photo/portrait-rich-woman-indoors-with-book_23-2149548501.jpg";
    }
}
