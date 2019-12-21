package org.azamat.spring.rep;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.azamat.spring.model.EnterForm;

import java.io.File;
import java.io.IOException;

public class Repository {
    EnterForm enterForm;
    private final static String baseFile = "enterForm.json";

    public Repository(EnterForm enterForm) {
        this.enterForm = enterForm;
    }

    public static void toJSON(EnterForm enterForm) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(baseFile), enterForm);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EnterForm toJavaObject() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(baseFile), EnterForm.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
