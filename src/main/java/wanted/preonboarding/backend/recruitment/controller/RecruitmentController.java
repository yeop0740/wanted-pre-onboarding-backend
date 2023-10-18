package wanted.preonboarding.backend.recruitment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wanted.preonboarding.backend.recruitment.CreateRecruitmentRequest;
import wanted.preonboarding.backend.recruitment.UpdateRecruitmentRequest;
import wanted.preonboarding.backend.recruitment.UpdateRecruitmentResponse;
import wanted.preonboarding.backend.recruitment.service.RecruitmentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recruitment")
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createRecruitment(@RequestBody CreateRecruitmentRequest request) {
        recruitmentService.createRecruitment(request);
    }

    @PutMapping("/{recruitmentId}")
    public UpdateRecruitmentResponse updateRecruitment(@PathVariable Long recruitmentId, @RequestBody UpdateRecruitmentRequest request) {
        Long id = recruitmentService.updateRecruitment(recruitmentId, request);
        return new UpdateRecruitmentResponse(id);
    }

    @DeleteMapping("/{recruitmentId}")
    public void deleteRecruitment(@PathVariable Long recruitmentId) {
        recruitmentService.deleteRecruitment(recruitmentId);
    }

}
