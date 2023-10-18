package wanted.preonboarding.backend.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import wanted.preonboarding.backend.common.BaseEntity;
import wanted.preonboarding.backend.recruitment.Recruitment;
import wanted.preonboarding.backend.user.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Application extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long id;

    private String resume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User applicant;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruitment_id")
    private Recruitment recruitment;

    public Application(User applicant, String resume, Recruitment recruitment) {
        this.applicant = applicant;
        this.resume = resume;
        this.recruitment = recruitment;
    }

}
