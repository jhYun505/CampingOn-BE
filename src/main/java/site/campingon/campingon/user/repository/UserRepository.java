package site.campingon.campingon.user.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.campingon.campingon.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // user id로 검색
    Optional<User> findByIdAndIsDeletedFalse(Long id);

    // user email로 검색
    Optional<User> findByEmailAndIsDeletedFalse(String email);
}