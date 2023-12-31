package wanted.preonboarding.backend.recruitment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import wanted.preonboarding.backend.recruitment.*;
import wanted.preonboarding.backend.recruitment.service.RecruitmentService;

import java.util.List;

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

    @GetMapping
    public List<RecruitmentDto> findRecruitment(@RequestParam(required = false) String search) {
        if (!StringUtils.hasText(search)) {
            return recruitmentService.findRecruitment();
        }
        return recruitmentService.searchRecruitment(search);
    }

    @GetMapping("/details/{recruitmentId}")
    public RecruitmentDetailsDto findRecruitmentDetails(@PathVariable Long recruitmentId) {
        return recruitmentService.findRecruitmentDetails(recruitmentId);
    }

}
