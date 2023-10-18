package wanted.preonboarding.backend.recruitment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wanted.preonboarding.backend.recruitment.CreateRecruitmentRequest;
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

}
