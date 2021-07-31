package io.devai.es_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "contacts")
public class Contact {

    @Id
    String id;
    String name;
    String email;
    Integer age;

}
