package api.schoolAPI.resource;

import api.schoolAPI.model.Courses;
import api.schoolAPI.model.Student;
import api.schoolAPI.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/students")
public class StudentsController {
    @Autowired
    private StudentsRepository repository;
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        repository.save(student);
        return student;
    }

    @GetMapping
    public List<Student> getAllStudents(){
            return repository.findAll();
    }
    @GetMapping("{id}")
    public Object getStudent(@PathVariable String id){

        Optional<Student> student;
        student = repository.findById(id);
        if(!student.isPresent()){
            return "No such user with id "+id;
        }
        return student;
    }
    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable String id){
        repository.deleteById(id);
        return "Student delete";
    }
    @PatchMapping("{id}")
    public String updateStudent(@PathVariable String id, @RequestBody Student newupdateStudent){
        newupdateStudent.setId(id);
        Optional<Student> student = repository.findById(id);
        if (newupdateStudent.getAge() == 0) newupdateStudent.setAge(student.get().getAge());
        if (newupdateStudent.getEmail() == null) newupdateStudent.setEmail(student.get().getEmail());
        if (newupdateStudent.getUsername() == null)  newupdateStudent.setUsername(student.get().getUsername());
        if (newupdateStudent.getCourses() == null) newupdateStudent.setCourses(student.get().getCourses());
        repository.save(newupdateStudent);
        return "User update";
    }

}
