package wanted.preonboarding.backend.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.preonboarding.backend.recruitment.Recruitment;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {

}
