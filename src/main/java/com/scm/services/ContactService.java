package com.scm.services;

import java.util.List;

import com.scm.entities.Contact;
import com.scm.entities.User;

public interface ContactService {
    // Save Contacts
    void save(Contact contact);

    // Update Contact
    Contact update(Contact contact);

    // Get Contacts
    List<Contact> getAll();

    // Get Contact by Id
    Contact getById(String id);

    // Delete Contact
    void delete(String id);

    // Get Contacts by UserId
    List<Contact> getByUserId(String userId);

    List<Contact> getByUser(User user);

}