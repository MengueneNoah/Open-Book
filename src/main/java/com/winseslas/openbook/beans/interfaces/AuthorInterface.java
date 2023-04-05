/**
 * 
 */
package com.winseslas.openbook.beans.interfaces;


import java.util.List;

import com.winseslas.openbook.beans.models.Author;

/**
 * @author Fortune
 *
 */
public interface AuthorInterface {
    Author findById(int id);
    List<Author> findAll();
    void create(Author author);
    void update(Author author);
    void delete(int id);
}
