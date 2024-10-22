package com.scm.services;

import java.util.List;

import com.scm.entities.Contact;
import com.scm.entities.User;
import org.springframework.data.domain.Page;

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

    Page<Contact> getByUser(User user, int page, int size, String sortBy, String direction);

    // Search Contact
    Page<Contact> searchByName(String nameKeyword, int size, int page, String sortBy, String direction, User user);

    Page<Contact> searchByEmail(String emailKeyword, int size, int page, String sortBy, String direction, User user);

    Page<Contact> searchByPhoneNumber(String phoneNumberKeyword, int size, int page, String sortBy, String direction, User user);

}