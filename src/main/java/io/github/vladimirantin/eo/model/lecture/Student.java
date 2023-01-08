package io.github.vladimirantin.eo.model.lecture;

import com.github.vladimirantin.core.GlobalVariables;
import com.github.vladimirantin.core.reflection.CoreImpl;
import io.github.vladimirantin.eo.model.Person;
import io.github.vladimirantin.eo.model.lecture.many.Attendant;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA
 * User: vladimir_antin
 * Date: 09.06.2019
 * Time: 17:26
 */
@Entity
@Where(clause = GlobalVariables.WHERE_CLAUSE)
@CoreImpl(type =  {CoreImpl.ImplType.REPO, CoreImpl.ImplType.SERVICE})
public class Student extends Person {

    @NotNull
    @Column(unique = true)
    private String indexNumber;

    @OneToMany(mappedBy = "student")
    private Set<Attendant> attendants = new HashSet<>();

    public String getIndexNumber() {
        return indexNumber;
    }

    public Student setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
        return this;
    }

    public Set<Attendant> getAttendants() {
        return attendants;
    }

    public Student setAttendants(Set<Attendant> attendants) {
        this.attendants = attendants;
        return this;
    }
}
