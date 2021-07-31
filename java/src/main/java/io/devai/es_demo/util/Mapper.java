package io.devai.es_demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.devai.es_demo.model.Contact;

public class Mapper {
    public static ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    public static String toJson(Object input) throws JsonProcessingException {
        return mapper().writeValueAsString(input);
    }

    public static Contact fromString(String input) throws JsonProcessingException {
        return mapper().readValue(input, Contact.class);
    }
}
