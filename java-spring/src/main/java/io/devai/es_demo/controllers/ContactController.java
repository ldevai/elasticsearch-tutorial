package io.devai.es_demo.controllers;

import io.devai.es_demo.dto.ContactResponse;
import io.devai.es_demo.model.Contact;
import io.devai.es_demo.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactService service;

    @GetMapping("/contacts/list")
    public ResponseEntity<ContactResponse> list() {
        ContactResponse response = new ContactResponse();
        try {
            List<Contact> result = service.list();
            response.setList(result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setError(e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/contacts/findById/{id}")
    public ResponseEntity<ContactResponse> findById(@PathVariable("id") String id) {
        ContactResponse response = new ContactResponse();
        try {
            Contact result = service.find(id);
            response.setRow(result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setError(e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/contacts/{name}")
    public ResponseEntity<ContactResponse> findByName(@PathVariable("name") String name) {
        ContactResponse response = new ContactResponse();
        try {
            Contact result = service.findByName(name);
            response.setRow(result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setError(e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PostMapping("/contacts")
    public ResponseEntity<ContactResponse> save(Contact contact) {
        ContactResponse response = new ContactResponse();
        try {
            Contact result = service.save(contact);
            response.setRow(result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setError(e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
