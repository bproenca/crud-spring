package bcp.crud;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;

    private Date dateOne;
    private java.sql.Date dateTwo;
    private LocalDate dateThree;
    private LocalDateTime dateFour;
    private ZonedDateTime dateFive;

    public User() {
    }

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

    public User(String name, String email, Date dateOne, java.sql.Date dateTwo, LocalDate dateThree,
            LocalDateTime dateFour, ZonedDateTime dateFive) {
        this.name = name;
        this.email = email;
        this.dateOne = dateOne;
        this.dateTwo = dateTwo;
        this.dateThree = dateThree;
        this.dateFour = dateFour;
        this.dateFive = dateFive;
    }

    @Override
    public String toString() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 

        return "\nUser [id=" + id + 
                "\n, name=" + name +
                "\n, email=" + email + 
                "\n, dateOne....(java.util.Date)..........." + simpleDateFormat.format(dateOne) + " [" + dateOne + "]" + 
                "\n, dateTwo....(java.sql.Date)............" + simpleDateFormat.format(dateTwo) + " [" + dateTwo + "]" +
                "\n, dateThree..(java.time.LocalDate)......" + dateFormatter.format(dateThree) + "          [" + dateThree + "]" +
                "\n, dateFour...(java.time.LocalDateTime).." + dateTimeFormatter.format(dateFour) + " [" + dateFour + "]" +
                "\n, dateFive...(java.time.ZonedDateTime).." + dateTimeFormatter.format(dateFive) + " [" + dateFive + "]" +
                "\n  {Default TZ" + TimeZone.getDefault()  + "} ]";
    }

    public ZonedDateTime getDateFive() {
        return dateFive;
    }

    public void setDateFive(ZonedDateTime dateFive) {
        this.dateFive = dateFive;
    }

}