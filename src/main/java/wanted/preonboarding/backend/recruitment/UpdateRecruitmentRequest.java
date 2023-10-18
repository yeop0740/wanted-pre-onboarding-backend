package wanted.preonboarding.backend.recruitment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRecruitmentRequest {

    @NotEmpty
    private String position;

    @NotEmpty
    private Integer reward;

    @NotEmpty
    private String description;

    @NotEmpty
    private String skill;

}
