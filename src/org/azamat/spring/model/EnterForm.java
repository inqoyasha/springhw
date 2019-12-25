package org.azamat.spring.model;


import org.azamat.spring.annotation.IsValidEmail;
import org.azamat.spring.annotation.IsValidFirstName;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class EnterForm {

    private String lastName;
    @IsValidFirstName
    private String firstName;
    private String patronymic;
    private Double salary;
    @IsValidEmail
    private String email;
    private String job;
    private String filename;

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public String getFilename() { return filename; }
    public void setFilename(String filename) {
        this.filename = filename;
    }


    @Override
    public String toString() {
        return "EnterForm{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnterForm enterForm = (EnterForm) o;
        return Objects.equals(lastName, enterForm.lastName) &&
                Objects.equals(firstName, enterForm.firstName);
//                Objects.equals(patronymic, enterForm.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, salary, email, job, filename);
    }
}
