package com.winseslas.openbook.beans.interfaces;

import java.util.List;
import java.util.Optional;

import com.winseslas.openbook.beans.models.PublishingHouse;

public interface PublishingHouseInterface {
    
    public void create(PublishingHouse publishingHouse);

    public void update(PublishingHouse publishingHouse);

    public void delete(PublishingHouse publishingHouse);

    public List<PublishingHouse> findAll();

    public Optional<PublishingHouse> findById(int id);
    
    public Optional<PublishingHouse> findByName(String name);
    
}
