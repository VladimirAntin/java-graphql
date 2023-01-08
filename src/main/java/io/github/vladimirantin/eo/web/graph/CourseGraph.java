package io.github.vladimirantin.eo.web.graph;

import io.github.vladimirantin.eo.coreImpl.course.CourseService;
import io.github.vladimirantin.eo.model.lecture.Course;
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
public class CourseGraph {

    @Autowired
    CourseService courseService;

    @QueryMapping
    public Page<Course> courses(@Argument int page, @Argument int size) {
        return courseService.findAll(PageRequest.of(page, size));
    }

    @QueryMapping
    public Course course(@Argument Long id) {
        return courseService.findOne(id);
    }

    @MutationMapping
    public Course createCourse(@Argument Course course) {
        if (course.getId() != 0) {
            throw new EntityExistsException();
        }
        return courseService.save(course);
    }

    @MutationMapping
    public Course updateCourse(@Argument Course course) {
        if (course.getId() == 0 || courseService.findOne(course.getId()) == null) {
            throw new EntityNotFoundException();
        }
        return courseService.save(course);
    }

    @MutationMapping
    public String deleteCourse(@Argument Long id) {
        Course course = courseService.findOne(id);
        courseService.delete(course);
        return "";
    }

}
