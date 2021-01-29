package server.exam.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "students")
public class Student {
    private int studentId;
    private String studentName;
    private String studentEmail;
    private Supervisor supervisor;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    @Column(name = "student_id", nullable = false)
    public int getStudentId(){ return studentId; }
    public void setStudentId(int studentId){ this.studentId = studentId; }

    @Basic
    @Column(name = "student_name", nullable = false, length = 45)
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {this.studentName = studentName;}

    @Basic
    @Column(name = "student_email", nullable = false, length = 45)
    public String getStudentEmail() {
        return studentEmail;
    }
    public void setStudentEmail(String studentEmail) {this.studentEmail = studentEmail;}

    @ManyToOne
    @JoinColumn(name = "supervisor_id", referencedColumnName = "supervisor_id", nullable = false)
    public Supervisor getSupervisor() {
        return supervisor;
    }
    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Student(int studentId, String studentName, String studentEmail, Supervisor supervisor){
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.supervisor = supervisor;
    }

    public Student(String studentName, String studentEmail, Supervisor supervisor){
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.supervisor = supervisor;
    }
    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", supervisor='" + supervisor.getSupervisorName() + " " + supervisor.getSupervisorSurname() + '\'' +
                '}';
    }
}


