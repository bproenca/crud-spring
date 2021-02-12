package bcp.crud;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "ABC_USER")
public class User {

    @Id
    private long id;
    private String name;
    private String email;
    private LocalDateTime dhDate;
    private LocalDateTime dhTimestamp;
    private LocalDate dtNotimeDate;
    private LocalDate dtNotimeTimestamp;

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

    @Override
    public String toString() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 

        return "\nUser [id=" + id + 
                "\n, name=" + name +
                "\n, email=" + email + 
                "\n, dhDate.............(java.time.LocalDateTime).." + dateTimeFormatter.format(dhDate) + " [" + dhDate + "]" +
                "\n, dhTimestamp........(java.time.LocalDateTime).." + dateTimeFormatter.format(dhTimestamp) + " [" + dhTimestamp + "]" +
                "\n, dtNotimeDate.......(java.time.LocalDate)......" + dateFormatter.format(dtNotimeDate) + " [" + dtNotimeDate + "]" +
                "\n, dtNotimeTimestamp..(java.time.LocalDate)......" + dateFormatter.format(dtNotimeTimestamp) + " [" + dtNotimeTimestamp + "]" +
                "\n  {Default TZ" + TimeZone.getDefault()  + "} ]";
    }

    public LocalDateTime getDhDate() {
        return dhDate;
    }

    public void setDhDate(LocalDateTime dhDate) {
        this.dhDate = dhDate;
    }

    public LocalDateTime getDhTimestamp() {
        return dhTimestamp;
    }

    public void setDhTimestamp(LocalDateTime dhTimestamp) {
        this.dhTimestamp = dhTimestamp;
    }



    public LocalDate getDtNotimeDate() {
        return dtNotimeDate;
    }

    public void setDtNotimeDate(LocalDate dtNotimeDate) {
        this.dtNotimeDate = dtNotimeDate;
    }

    public LocalDate getDtNotimeTimestamp() {
        return dtNotimeTimestamp;
    }

    public void setDtNotimeTimestamp(LocalDate dtNotimeTimestamp) {
        this.dtNotimeTimestamp = dtNotimeTimestamp;
    }

    public User(long id, String name, String email, LocalDateTime dhDate, LocalDateTime dhTimestamp,
            LocalDate dtNotimeDate, LocalDate dtNotimeTimestamp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dhDate = dhDate;
        this.dhTimestamp = dhTimestamp;
        this.dtNotimeDate = dtNotimeDate;
        this.dtNotimeTimestamp = dtNotimeTimestamp;
    }

}