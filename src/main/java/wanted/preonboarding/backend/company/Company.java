package wanted.preonboarding.backend.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import wanted.preonboarding.backend.common.BaseEntity;
import wanted.preonboarding.backend.recruitment.Recruitment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Company extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    private String name;

    private String country;

    private String area;

    @OneToMany(mappedBy = "company")
    private List<Recruitment> recruitments = new ArrayList<>();

    public Company(String name, String country, String area) {
        this.name = name;
        this.country = country;
        this.area = area;
    }

    public Recruitment recruit(String position, int reward, String description, String skill) {
        Recruitment recruitment = new Recruitment(position, reward, description, skill, this);
        this.recruitments.add(recruitment);
        return recruitment;
    }

}
