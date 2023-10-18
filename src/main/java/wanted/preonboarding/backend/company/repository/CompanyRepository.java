package wanted.preonboarding.backend.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.preonboarding.backend.company.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
