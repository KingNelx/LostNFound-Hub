package lostnfoundbe.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lostnfoundbe.Entity.SystemAdmin;

@Repository
public interface SystemAdminRepo extends JpaRepository<SystemAdmin, Long> {

    Optional<SystemAdmin> findByFirstName(String lastName);

    Optional<SystemAdmin> findByLastName(String lastName);

    Optional<SystemAdmin> findByEmailAddress(String emailAddress);
}
