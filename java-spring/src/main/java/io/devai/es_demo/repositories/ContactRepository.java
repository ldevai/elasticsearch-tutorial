package io.devai.es_demo.repositories;

import io.devai.es_demo.model.Contact;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface ContactRepository extends ElasticsearchRepository<Contact, String> {
    Optional<Contact> findByName(String name);
}
