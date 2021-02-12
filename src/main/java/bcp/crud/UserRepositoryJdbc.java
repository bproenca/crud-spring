package bcp.crud;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryJdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User save(User user) {

        // Split up the array of whole names into an array of first/last names
        // List<Object[]> splitUpNames = Arrays.asList("1 John Woo", "2 Jeff Dean", "3
        // Josh Bloch", "4 Josh Long").stream()
        // .map(name -> name.split(" ")).collect(Collectors.toList());

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.update(
                "insert into abc_user(id, name, email, dh_date, dh_timestamp, dt_notime_date, dt_notime_timestamp) values (?,?,?,?,?,?,?)",
                user.getId(), user.getName(), user.getEmail(), user.getDhDate(), user.getDhTimestamp(),
                user.getDtNotimeDate(), user.getDtNotimeTimestamp());

        return (User) jdbcTemplate.queryForObject("select * from abc_user where id = ?",
                new BeanPropertyRowMapper<User>(User.class), user.getId());

    }

    public List<User> findByDhDateLessThanEqual(LocalDateTime dhDate) {
        String sql = "select * from abc_user where dh_date <= ?";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), dhDate);
        return users;
    }

    public List<User> findByDhTimestampLessThanEqual(LocalDateTime dhTimestamp) {
        String sql = "select * from abc_user where dh_timestamp <= ?";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), dhTimestamp);
        return users;
    }

    public List<User> findByDtNotimeDateLessThanEqual(LocalDate dtNotimeDate) {
        String sql = "select * from abc_user where dt_notime_date <= ?";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), dtNotimeDate);
        return users;
    }

    public List<User> findByDtNotimeTimestampLessThanEqual(LocalDate dtNotimeTimestamp) {
        String sql = "select * from abc_user where dt_notime_timestamp <= ?";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), dtNotimeTimestamp);
        return users;
    }

}