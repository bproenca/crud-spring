package bcp.crud;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @NotBlank(message = "Email is mandatory")
    private String email;

    private Date dateOne;

    private java.sql.Date dateTwo;

    private LocalDate dateThree;

    private LocalDateTime dateFour;

    public User() {}


    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOne() {
        return dateOne;
    }

    public void setDateOne(Date dateOne) {
        this.dateOne = dateOne;
    }

    public java.sql.Date getDateTwo() {
        return dateTwo;
    }

    public void setDateTwo(java.sql.Date dateTwo) {
        this.dateTwo = dateTwo;
    }

    public LocalDate getDateThree() {
        return dateThree;
    }

    public void setDateThree(LocalDate dateThree) {
        this.dateThree = dateThree;
    }

    public LocalDateTime getDateFour() {
        return dateFour;
    }

    public void setDateFour(LocalDateTime dateFour) {
        this.dateFour = dateFour;
    }

    public User(long id, String name,
            String email,
            Date dateOne, java.sql.Date dateTwo,
            LocalDate dateThree,
            LocalDateTime dateFour) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOne = dateOne;
        this.dateTwo = dateTwo;
        this.dateThree = dateThree;
        this.dateFour = dateFour;
    }

    @Override
    public String toString() {
        return "User [dateFour=" + dateFour + ", dateOne=" + dateOne + ", dateThree=" + dateThree + ", dateTwo="
                + dateTwo + ", email=" + email + ", id=" + id + ", name=" + name + "]";
    }

}