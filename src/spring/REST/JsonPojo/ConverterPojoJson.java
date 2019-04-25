package spring.REST.JsonPojo;

import java.io.File;
import java.io.IOException;

public class ConverterPojoJson {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        //JSON to POJO
        Student student = objectMapper.readValue(new File(Student.class.getResource("sample.json").getPath()), Student.class);

        System.out.println(student.getInfo()); //to check if it had worked


        //POJO to JSON
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //to write output pretty and not compressed

        objectMapper.writeValue(new File(Student.class.getResource("").getPath() + "/newSample.json"), student);
    }
}
