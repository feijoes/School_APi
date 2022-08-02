package api.schoolAPI.repository;

import api.schoolAPI.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentsRepository extends MongoRepository<Student,Integer> {
}
