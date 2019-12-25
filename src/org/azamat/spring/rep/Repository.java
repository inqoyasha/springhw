package org.azamat.spring.rep;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.azamat.spring.model.EnterForm;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {
    EnterForm enterForm;

    public Repository(EnterForm enterForm) {
        this.enterForm = enterForm;
    }

    public static void toJSON(EnterForm enterForm) {
        ObjectMapper mapper = new ObjectMapper();
        List<EnterForm> list = new ArrayList<>();
        File file = new File("D:\\IdeaProjects\\springhw\\enterForm.json");
        if (file.length() != 0) {
            list.addAll(check());
            clean("D:\\IdeaProjects\\springhw\\enterForm.json");
        }
        list.add(enterForm);
        try {
            FileOutputStream outputStream = new FileOutputStream("D:\\IdeaProjects\\springhw\\enterForm.json", true);
            mapper.writeValue(outputStream, list);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EnterForm toJavaObject(String path) {
        File file = new File(path);
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

    public static List<EnterForm> check() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("D:\\IdeaProjects\\springhw\\enterForm.json");
        try {
            List<EnterForm> myObjects = Arrays.asList(mapper.readValue(file, EnterForm[].class));
            return myObjects;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void clean(String s) {
        try {
            new FileOutputStream(s).close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EnterForm find(EnterForm enterForm) {
        List <EnterForm> newList = new ArrayList<>();
        newList.addAll(check());
        for (EnterForm t: newList) {
            if (enterForm.equals(t)) {
                System.out.println("sovpal");
                return t;
            }
        }
        return null;
    }

}
