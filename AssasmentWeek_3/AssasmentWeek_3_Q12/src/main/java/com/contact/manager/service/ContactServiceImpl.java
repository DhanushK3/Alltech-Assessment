package com.contact.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.manager.dao.ContactDAO;
import com.contact.manager.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Override
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    @Override
    public void removeContact(int contactId) {
        contactDAO.removeContact(contactId);
    }
}
