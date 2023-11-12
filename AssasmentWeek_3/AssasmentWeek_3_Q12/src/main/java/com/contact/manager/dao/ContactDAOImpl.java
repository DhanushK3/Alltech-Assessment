package com.contact.manager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.contact.manager.model.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addContact(Contact contact) {
        String sql = "INSERT INTO contacts (phoneNo, fullAddress) VALUES (?, ?)";
        jdbcTemplate.update(sql, contact.getPhoneNo(), contact.getFullAddress());
    }

    @Override
    public void removeContact(int contactId) {
        String sql = "DELETE FROM contacts WHERE contactId = ?";
        jdbcTemplate.update(sql, contactId);
    }
}
