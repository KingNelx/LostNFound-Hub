package lostnfoundbe.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "finder")
@AllArgsConstructor
@NoArgsConstructor
public class UserFinder {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private @Getter @Setter Long id;

    @Column(name = "first_name", nullable = false)
    private @Getter @Setter String firstName;

    @Column(name = "last_name", nullable = false)
    private @Getter @Setter String lastName;

    @Column(name = "gender", nullable = false)
    private @Getter @Setter String gender;

    @Column(name = "contact_information", nullable = false)
    private @Getter @Setter String contactInformation;

    @Column(name = "item_name", nullable = false)
    private @Getter @Setter String itemName;

    @Column(name = "item_description", nullable = false)
    private @Getter @Setter String itemDescription;
    
    @Column(name = "lost_location", nullable = false)
    private @Getter @Setter String lostLocation;

    @Column(name = "date_lost", nullable = false)
    private @Getter @Setter Date dateLost;

    @Lob
    private @Getter @Setter byte[] image;
    
}
