package io.github.vladimirantin.eo.model.lecture;

import com.github.vladimirantin.core.GlobalVariables;
import com.github.vladimirantin.core.model.CoreModel;
import com.github.vladimirantin.core.reflection.CoreImpl;
import io.github.vladimirantin.eo.model.lecture.many.Attendant;
import io.github.vladimirantin.eo.model.lecture.many.Lecturer;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA
 * User: vladimir_antin
 * Date: 09.06.2019
 * Time: 17:27
 */
@Entity
@Where(clause = GlobalVariables.WHERE_CLAUSE)
@CoreImpl(type =  {CoreImpl.ImplType.REPO, CoreImpl.ImplType.SERVICE})
public class Course extends CoreModel {

    @NotNull private String name;
    private String description;
    @NotNull private Integer nmbOfLecture;
    @NotNull private Integer nmbOfExercise;

    @OneToMany(mappedBy = "course")
    private Set<Lecturer> lecturers = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private Set<Attendant> attendants = new HashSet<>();

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getNmbOfLecture() {
        return nmbOfLecture;
    }

    public Course setNmbOfLecture(Integer nmbOfLecture) {
        this.nmbOfLecture = nmbOfLecture;
        return this;
    }

    public Integer getNmbOfExercise() {
        return nmbOfExercise;
    }

    public Course setNmbOfExercise(Integer nmbOfExercise) {
        this.nmbOfExercise = nmbOfExercise;
        return this;
    }

    public Set<Lecturer> getLecturers() {
        return lecturers;
    }

    public Course setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
        return this;
    }

    public Set<Attendant> getAttendants() {
        return attendants;
    }

    public Course setAttendants(Set<Attendant> attendants) {
        this.attendants = attendants;
        return this;
    }
}
