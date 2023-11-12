package com.contact.manager.dao;

import com.contact.manager.model.Contact;

public interface ContactDAO {
    void addContact(Contact contact);

    void removeContact(int contactId);
}
