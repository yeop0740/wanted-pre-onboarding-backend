package wanted.preonboarding.backend.recruitment.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import wanted.preonboarding.backend.company.Company;
import wanted.preonboarding.backend.company.repository.CompanyRepository;
import wanted.preonboarding.backend.recruitment.CreateRecruitmentRequest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RecruitmentServiceTest {

    @Autowired
    RecruitmentService recruitmentService;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EntityManager em;

    @Test
    public void 채용공고_저장_테스트() throws Exception {
        // given
        String company1Name = "wanted";
        String country1 = "한국";
        String area1 = "상도동";
        Company company1 = new Company(company1Name, country1, area1);
        em.persist(company1);
        Long company1Id = company1.getId();

        String position1 = "backend";
        int reward1 = 500000;
        String description1 = "열정맨";
        String skill1 = "java";
        CreateRecruitmentRequest request = new CreateRecruitmentRequest(company1Id, position1, reward1, description1, skill1);
        recruitmentService.createRecruitment(request);

        // when
        em.flush();
        em.clear();
        Company company = companyRepository.findById(company1Id).orElseThrow(RuntimeException::new);

        // then
        Assertions.assertThat(company.getRecruitments().stream()
                .filter(recruitment ->
                        recruitment.getReward() == reward1 &&
                                recruitment.getPosition().equals(position1) &&
                                recruitment.getDescription().equals(description1) &&
                                recruitment.getSkill().equals(skill1))
                .findAny().orElseThrow(RuntimeException::new)).isNotInstanceOf(RuntimeException.class).isNotNull();

    }


}