package spring.REST;

import java.io.File;
import java.io.IOException;

public class ConverterPojoJson {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Student student = objectMapper.readValue(new File(Student.class.getResource("sample.json").getPath()), Student.class);

        System.out.println(student.getInfo());
    }
}
