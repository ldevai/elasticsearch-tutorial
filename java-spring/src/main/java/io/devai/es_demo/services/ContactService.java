package io.devai.es_demo.services;

import io.devai.es_demo.model.Contact;
import io.devai.es_demo.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ContactService {

    @Autowired
    ContactRepository repository;

    public List<Contact> list() {
        List<Contact> result = StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
        return result;
    }

    public Contact save(Contact contact) {
        Contact result = repository.save(contact);
        return result;
    }

    public void delete(Contact contact) {
        repository.delete(contact);
    }

    public Contact find(String id) {
        Optional<Contact> result = repository.findById(id);
        if (result.isEmpty()) {
            throw new IllegalArgumentException("Unable to find contact with ID " + id);
        }
        return result.get();
    }

    public Contact findByName(String name) {
        Optional<Contact> result = repository.findByName(name);
        if (result.isEmpty()) {
            throw new IllegalArgumentException("Unable to find contact with name " + name);
        }
        return result.get();
    }
}
