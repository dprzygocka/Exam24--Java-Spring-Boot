package server.exam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "supervisors")
public class Supervisor {

    private int supervisorId;
    private String supervisorName;
    private String supervisorSurname;
    @JsonBackReference
    private Collection<Student> students;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    @Column(name = "supervisor_id", nullable = false)
    public int getSupervisorId(){
        return supervisorId;
    }
    public void setSupervisorId(int supervisorId){
        this.supervisorId = supervisorId;
    }

    @Basic
    @Column(name = "supervisor_name", nullable = false, length = 45)
    public String getSupervisorName() {
        return supervisorName;
    }
    public void setSupervisorName(String supervisorName) {this.supervisorName = supervisorName;}

    @Basic
    @Column(name = "supervisor_surname", nullable = false, length = 45)
    public String getSupervisorSurname() {
        return supervisorSurname;
    }
    public void setSupervisorSurname(String supervisorSurname) {this.supervisorSurname = supervisorSurname;}


    @OneToMany(mappedBy = "supervisor")
    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public Supervisor(int supervisorId, String supervisorName, String supervisorSurname, Collection<Student> students){
        this.supervisorId = supervisorId;
        this.supervisorName = supervisorName;
        this.supervisorSurname = supervisorSurname;
        this.students = students;
    }
    public Supervisor(){}


}
