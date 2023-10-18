package wanted.preonboarding.backend.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanted.preonboarding.backend.application.Application;
import wanted.preonboarding.backend.application.CreateApplicationRequest;
import wanted.preonboarding.backend.application.repository.ApplicationRepository;
import wanted.preonboarding.backend.common.exception.BusinessExceeption;
import wanted.preonboarding.backend.recruitment.Recruitment;
import wanted.preonboarding.backend.recruitment.repository.RecruitmentRepository;
import wanted.preonboarding.backend.user.User;
import wanted.preonboarding.backend.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    private final UserRepository userRepository;

    private final RecruitmentRepository recruitmentRepository;

    public void createApplication(CreateApplicationRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new BusinessExceeption("존재하지 않는 엔티티"));
        Recruitment recruitment = recruitmentRepository.findById(request.getRecruitmentId()).orElseThrow(() -> new BusinessExceeption("존재하지 않는 엔티티"));
        applicationRepository.findByApplicantAndRecruitment(user, recruitment)
                .ifPresentOrElse(
                        application -> {
                            throw new BusinessExceeption("이미 지원한 공고입니다.");
                        },
                        () -> {
                            applicationRepository.save(user.apply(recruitment));
                        });
    }

}