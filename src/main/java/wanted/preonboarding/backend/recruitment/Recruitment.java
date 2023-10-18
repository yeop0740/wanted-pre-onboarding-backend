package wanted.preonboarding.backend.recruitment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import wanted.preonboarding.backend.application.Application;
import wanted.preonboarding.backend.common.BaseEntity;
import wanted.preonboarding.backend.company.Company;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Recruitment extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "recruitment_id")
    private Long id;

    private String position;

    private int reward;

    private String description;

    private String skill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "recruitment")
    private Application application;

    public Recruitment(String position, int reward, String description, String skill, Company company) {
        this.position = position;
        this.reward = reward;
        this.description = description;
        this.skill = skill;
        this.company = company;
    }

    public void update(UpdateRecruitmentRequest request) {
        this.position = request.getPosition();
        this.reward = request.getReward();
        this.description = request.getDescription();
        this.skill = request.getSkill();
    }

}
