package wanted.preonboarding.backend.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.preonboarding.backend.application.Application;
import wanted.preonboarding.backend.recruitment.Recruitment;
import wanted.preonboarding.backend.user.User;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Optional<Application> findByApplicantAndRecruitment(User applicant, Recruitment recruitment);

}
