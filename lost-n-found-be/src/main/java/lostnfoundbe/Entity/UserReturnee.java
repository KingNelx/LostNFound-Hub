package lostnfoundbe.Entity;

import jakarta.persistence.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Lob;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "returnee")
@AllArgsConstructor
@NoArgsConstructor
public class UserReturnee {
    
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

    @Column(name = "found_location", nullable = false)
    private @Getter @Setter String foundLocation;

    @Column(name = "report_date", nullable = false)
    private @Getter @Setter Date reportDate;

    @Lob
    private @Getter @Setter byte[] image;
}
