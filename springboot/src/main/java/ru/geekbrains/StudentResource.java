package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public Student findById(@PathVariable("id") long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student with id = " + id + " not exists"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student) {
        if (student.getId() != null) {
            throw new IllegalArgumentException("Can't create student with id not null");
        }
        return studentRepository.save(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        if (student.getId() == null) {
            throw new IllegalArgumentException("Can't update student with id null");
        }
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto notFoundExceptionHandler(NotFoundException ex) {
        return new ErrorDto(ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto notFoundExceptionHandler(IllegalArgumentException ex) {
        return new ErrorDto(ex.getMessage());
    }
}
