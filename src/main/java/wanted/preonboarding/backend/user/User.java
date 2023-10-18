package wanted.preonboarding.backend.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import wanted.preonboarding.backend.application.Application;
import wanted.preonboarding.backend.common.BaseEntity;
import wanted.preonboarding.backend.recruitment.Recruitment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "USERS")
@NoArgsConstructor
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "applicant")
    private List<Application> applications = new ArrayList<>();

    private boolean isActivated;

    public User(String name) {
        this.name = name;
        this.isActivated = true;
    }

    public Application apply(String resume, Recruitment recruitment) {
        Application application = new Application(this, resume, recruitment);
        this.applications.add(application);
        return application;
    }

}
