package wanted.preonboarding.backend.recruitment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanted.preonboarding.backend.common.exception.BusinessExceeption;
import wanted.preonboarding.backend.company.Company;
import wanted.preonboarding.backend.company.repository.CompanyRepository;
import wanted.preonboarding.backend.recruitment.CreateRecruitmentRequest;
import wanted.preonboarding.backend.recruitment.Recruitment;
import wanted.preonboarding.backend.recruitment.UpdateRecruitmentRequest;
import wanted.preonboarding.backend.recruitment.repository.RecruitmentRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class RecruitmentService {

    private final CompanyRepository companyRepository;

    private final RecruitmentRepository recruitmentRepository;

    public void createRecruitment(CreateRecruitmentRequest request) {
        Company company = companyRepository.findById(request.getCompanyId()).orElseThrow(() -> new BusinessExceeption("존재하지 않는 엔티티"));
        Recruitment recruitment = new Recruitment(request.getPosition(), request.getReward(), request.getDescription(), request.getSkill(), company);

        recruitmentRepository.save(recruitment);
    }

    public Long updateRecruitment(Long recruitmentId, UpdateRecruitmentRequest request) {
        Recruitment recruitment = recruitmentRepository.findById(recruitmentId).orElseThrow(() -> new BusinessExceeption("존재하지 않는 엔티티"));
        recruitment.update(request);
        return recruitment.getId();
    }

    public void deleteRecruitment(Long recruitmentId) {
        Recruitment recruitment = recruitmentRepository.findById(recruitmentId).orElseThrow(() -> new BusinessExceeption("존재하지 않는 엔티티"));
        recruitmentRepository.delete(recruitment);
    }

}
