package org.azamat.spring.rep;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.azamat.spring.model.EnterForm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Repository {
    EnterForm enterForm;
    List<EnterForm> listForm;
    //private final static String baseFile = "enterForm.json";

    public Repository(EnterForm enterForm) {
        this.enterForm = enterForm;
    }

    public void add(EnterForm enterForm) {
        listForm.add(enterForm);
    }

    public static void toJSON(EnterForm enterForm) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            FileOutputStream outputStream = new FileOutputStream("D:\\IdeaProjects\\springhw\\enterForm.json", true);
            mapper.writeValue(outputStream, enterForm);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EnterForm toJavaObject() {
        File file = new File("D:\\IdeaProjects\\springhw\\enterForm.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, EnterForm.class);
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
