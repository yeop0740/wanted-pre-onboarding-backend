package wanted.preonboarding.backend.recruitment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wanted.preonboarding.backend.company.Company;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentDto {

    private Long recruitmentId;

    private String companyName;

    private String country;

    private String area;

    private String position;

    private int reward;

    private String skill;

    public static RecruitmentDto from(Recruitment recruitment) {
        Company company = recruitment.getCompany();
        return new RecruitmentDto(recruitment.getId(),
                company.getName(),
                company.getCountry(),
                company.getArea(),
                recruitment.getPosition(),
                recruitment.getReward(),
                recruitment.getSkill());
    }

}
