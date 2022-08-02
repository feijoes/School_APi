package api.schoolAPI.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Getter
@Setter
@ToString
@Document(collection = "Students")
public class Student {
    @Id
    private int id;
    private String username;
    private String email;
    private int age;
    private List<Courses> courses;

}
