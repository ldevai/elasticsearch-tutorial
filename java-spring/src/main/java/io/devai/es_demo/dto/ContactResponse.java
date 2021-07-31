package io.devai.es_demo.dto;

import io.devai.es_demo.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {
    List<Contact> list;
    Contact row;
    String error;
}
