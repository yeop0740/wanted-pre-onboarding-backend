package wanted.preonboarding.backend.recruitment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRecruitmentRequest {

    private Long companyId;

    private String position;

    private int reward;

    private String description;

    private String skill;

}
