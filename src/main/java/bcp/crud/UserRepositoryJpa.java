package bcp.crud;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, Long> {
    
    List<User> findByName(String name);

    List<User> findByDhDateLessThanEqual(LocalDateTime dhDate);
    List<User> findByDhTimestampLessThanEqual(LocalDateTime dhTimestamp);
    List<User> findByDtNotimeDateLessThanEqual(LocalDate dtNotimeDate);
    List<User> findByDtNotimeTimestampLessThanEqual(LocalDate dtNotimeTimestamp);
    
}