package wanted.preonboarding.backend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.preonboarding.backend.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
