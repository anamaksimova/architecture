package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/student")
@RestController
public class StudentResource {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentResource(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}/id")
    public Optional<Student> findById(@PathVariable("id") long id) {
        return studentRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student) {
        if (student.getId() != null) {
            throw new IllegalArgumentException("Can't create user with id not null");
        }
        return studentRepository.save(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        if (student.getId() == null) {
            throw new IllegalArgumentException("Can't update user with id null");
        }
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
    }
}
