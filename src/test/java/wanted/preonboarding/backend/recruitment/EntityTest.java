package wanted.preonboarding.backend.recruitment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import wanted.preonboarding.backend.application.Application;
import wanted.preonboarding.backend.company.Company;
import wanted.preonboarding.backend.user.User;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EntityTest {

    @Autowired
    EntityManager em;

    @Test
    public void 사용자_생성_테스트() throws Exception {
        // given
        String name = "david";
        User user = new User(name);

        // when
        em.persist(user);
        Long expectedId = user.getId();
        em.flush();
        em.clear();

        // then
        User findUser = em.find(User.class, expectedId);
        Assertions.assertThat(expectedId).isEqualTo(findUser.getId());
    }

    @Test
    public void 회사_생성_테스트() throws Exception {
        // given
        String name = "wanted";
        String country = "한국";
        String area = "상도동";

        Company company = new Company(name, country, area);

        // when
        em.persist(company);
        Long expectedId = company.getId();
        em.flush();
        em.clear();

        // then
        Company findCompany = em.find(Company.class, expectedId);
        Assertions.assertThat(company.getId()).isEqualTo(findCompany.getId());
        Assertions.assertThat(company.getName()).isEqualTo(findCompany.getName());
        Assertions.assertThat(company.getCountry()).isEqualTo(findCompany.getCountry());
        Assertions.assertThat(company.getArea()).isEqualTo(findCompany.getArea());

    }
    
    @Test
    public void 채용_공고_생성_테스트() throws Exception {
        // given
        String position = "backend";
        int reward = 500000;
        String description = "열정맨";
        String skill = "java";

        String name = "wanted";
        String country = "한국";
        String area = "상도동";
        Company company = new Company(name, country, area);
        em.persist(company);

        Recruitment recruitment = new Recruitment(position, reward, description, skill, company);
        // when
        em.persist(recruitment);
        Long expectedId = recruitment.getId();
        em.flush();
        em.clear();
        
        // then
        Recruitment findRecruitment = em.find(Recruitment.class, expectedId);
        Assertions.assertThat(findRecruitment.getPosition()).isEqualTo(position);
        Assertions.assertThat(findRecruitment.getReward()).isEqualTo(reward);
        Assertions.assertThat(findRecruitment.getDescription()).isEqualTo(description);
        Assertions.assertThat(findRecruitment.getSkill()).isEqualTo(skill);

        Company findCompany = findRecruitment.getCompany();
        Assertions.assertThat(findCompany.getName()).isEqualTo(name);
        Assertions.assertThat(findCompany.getCountry()).isEqualTo(country);
        Assertions.assertThat(findCompany.getArea()).isEqualTo(area);
    }

    @Test
    public void 회사_채용공고_조회_테스트() throws Exception {
        // given
        String position1 = "backend";
        int reward1 = 500000;
        String description1 = "열정맨";
        String skill1 = "java";

        String position2 = "frontend";
        int reward2 = 700000;
        String description2 = "열정가득";
        String skill2 = "js";

        String name = "wanted";
        String country = "한국";
        String area = "상도동";
        Company company = new Company(name, country, area);
        em.persist(company);

        Recruitment recruitment1 = new Recruitment(position1, reward1, description1, skill1, company);
        Recruitment recruitment2 = new Recruitment(position2, reward2, description2, skill2, company);

        List<Recruitment> expectedRecruitments = List.of(recruitment1, recruitment2);
        int expectedSize = expectedRecruitments.size();

        em.persist(recruitment1);
        em.persist(recruitment2);

        // when
        Long expectedId1 = recruitment1.getId();
        Long expectedId2 = recruitment2.getId();
        Long companyId = company.getId();
        em.flush();
        em.clear();

        Company findCompany = em.find(Company.class, companyId);
        List<Recruitment> recruitments = findCompany.getRecruitments();

        // then
        Assertions.assertThat(recruitments.size()).isEqualTo(expectedSize);
    }

    @Test
    public void 공고_지원_생성_테스트() throws Exception {
        // given
        String name = "david";
        User user = new User(name);
        em.persist(user);

        String position1 = "backend";
        int reward1 = 500000;
        String description1 = "열정맨";
        String skill1 = "java";

        String position2 = "frontend";
        int reward2 = 700000;
        String description2 = "열정가득";
        String skill2 = "js";

        String companyName = "wanted";
        String country = "한국";
        String area = "상도동";
        Company company = new Company(companyName, country, area);
        em.persist(company);

        Recruitment recruitment1 = new Recruitment(position1, reward1, description1, skill1, company);
        Recruitment recruitment2 = new Recruitment(position2, reward2, description2, skill2, company);
        em.persist(recruitment1);
        em.persist(recruitment2);

        String resume = "열정 가득 백엔드 개발자 입니다.";
        Application application = new Application(user, recruitment1);
        em.persist(application);

        Long expectedId = application.getId();

        // when
        em.flush();
        em.clear();
        Application expectedApplication = em.find(Application.class, expectedId);

        // then
        Assertions.assertThat(expectedApplication.getApplicant().getName()).isEqualTo(user.getName());
        Assertions.assertThat(expectedApplication.getRecruitment().getCompany().getName()).isEqualTo(companyName);
        Assertions.assertThat(expectedApplication.getRecruitment().getPosition()).isEqualTo(position1);
    }

    @Test
    public void 지원_공고_테스트() throws Exception {
        // given
        String name = "david";
        User user = new User(name);
        em.persist(user);

        String position1 = "backend";
        int reward1 = 500000;
        String description1 = "열정맨";
        String skill1 = "java";

        String position2 = "frontend";
        int reward2 = 700000;
        String description2 = "열정가득";
        String skill2 = "js";

        String company1Name = "wanted";
        String country1 = "한국";
        String area1 = "상도동";
        Company company1 = new Company(company1Name, country1, area1);
        em.persist(company1);

        String company2Name = "sangdo";
        String country2 = "한국";
        String area2 = "사당로";
        Company company2 = new Company(company2Name, country2, area2);
        em.persist(company2);

        Recruitment recruitment1 = new Recruitment(position1, reward1, description1, skill1, company1);
        Recruitment recruitment2 = new Recruitment(position2, reward2, description2, skill2, company2);
        em.persist(recruitment1);
        em.persist(recruitment2);

        String resume = "열정 가득 백엔드 개발자 입니다.";
        Application application1 = new Application(user, recruitment1);
        em.persist(application1);

        Application application2 = new Application(user, recruitment2);
        em.persist(application2);
        List<Application> expectedApplicants = List.of(application1, application2);

        Long expectedId = user.getId();

        // when
        em.flush();
        em.clear();
        User findUser = em.find(User.class, expectedId);

        // then
        Assertions.assertThat(findUser.getName()).isEqualTo(name);
        Assertions.assertThat(findUser.getApplications().size()).isEqualTo(expectedApplicants.size());
    }

}