package api.schoolAPI.resource;

import api.schoolAPI.model.Student;
import api.schoolAPI.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "hello")
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
    public Optional<Student> getStudent(@PathVariable int id){
        return repository.findById(id);
    }
    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable int id){
        repository.deleteById(id);
        return "Student delete";
    }

}
