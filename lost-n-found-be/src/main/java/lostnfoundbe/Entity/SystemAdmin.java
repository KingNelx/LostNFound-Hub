package lostnfoundbe.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "systemadmin")
@AllArgsConstructor
@NoArgsConstructor
public class SystemAdmin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private @Getter @Setter Long id;

    @Column(name = "first_name", nullable = false)
    private @Getter @Setter String firstName;

    @Column(name = "last_name", nullable = false)
    private @Getter @Setter String lastName;

    @Column(name = "email_address", nullable = false)
    private @Getter @Setter String emailAddress;

    @Column(name = "user_name", nullable = false)
    private @Getter @Setter String userName;

    @Column(name = "password", nullable = false)
    private @Getter @Setter String password;

}
