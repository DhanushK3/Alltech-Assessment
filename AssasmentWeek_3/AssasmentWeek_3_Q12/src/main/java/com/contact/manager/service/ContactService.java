package com.contact.manager.service;

import com.contact.manager.model.Contact;

public interface ContactService {
    void addContact(Contact contact);

    void removeContact(int contactId);
}
