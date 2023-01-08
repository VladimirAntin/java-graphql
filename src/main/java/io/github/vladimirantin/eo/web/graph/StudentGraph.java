package io.github.vladimirantin.eo.web.graph;

import io.github.vladimirantin.eo.coreImpl.student.StudentService;
import io.github.vladimirantin.eo.model.lecture.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Controller
public class StudentGraph {

    @Autowired
    StudentService studentService;

    @QueryMapping
    public Page<Student> students(@Argument int page, @Argument int size) {
        return studentService.findAll(PageRequest.of(page, size));
    }

    @QueryMapping
    public Student student(@Argument Long id) {
        return studentService.findOne(id);
    }

    @MutationMapping
    public Student createStudent(@Argument Student student) {
        if (student.getId() != 0) {
            throw new EntityExistsException();
        }
        return studentService.save(student);
    }

    @MutationMapping
    public Student updateStudent(@Argument Student student) {
        if (student.getId() == 0 || studentService.findOne(student.getId()) == null) {
            throw new EntityNotFoundException();
        }
        return studentService.save(student);
    }

    @MutationMapping
    public String deleteStudent(@Argument Long id) {
        Student student = studentService.findOne(id);
        studentService.delete(student);
        return "";
    }

}
