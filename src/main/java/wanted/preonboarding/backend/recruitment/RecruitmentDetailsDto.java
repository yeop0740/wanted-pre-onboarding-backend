package wanted.preonboarding.backend.recruitment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wanted.preonboarding.backend.company.Company;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentDetailsDto {

    private Long recruitmentId;

    private String companyName;

    private String country;

    private String area;

    private String position;

    private int reward;

    private String skill;

    private String description;

    private List<Long> recruitments;

    public static RecruitmentDetailsDto from(Recruitment recruitment) {
        Company company = recruitment.getCompany();
        return new RecruitmentDetailsDto(recruitment.getId(),
                company.getName(),
                company.getCountry(),
                company.getArea(),
                recruitment.getPosition(),
                recruitment.getReward(),
                recruitment.getSkill(),
                recruitment.getDescription(),
                company.getRecruitments().stream()
                        .map(Recruitment::getId)
                        .filter(id -> !id.equals(recruitment.getId()))
                        .collect(Collectors.toList()));
    }
}
