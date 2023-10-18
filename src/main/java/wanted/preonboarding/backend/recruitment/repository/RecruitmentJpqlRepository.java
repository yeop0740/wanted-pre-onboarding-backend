package wanted.preonboarding.backend.recruitment.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import wanted.preonboarding.backend.recruitment.Recruitment;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor
public class RecruitmentJpqlRepository {

    private final EntityManager em;

    public List<Recruitment> findByKeyword(String search) {
        return em.createQuery("select r" +
                " from Recruitment r" +
                " join r.company c" +
                " where c.name like :search" +
                " or r.description like :search" +
                " or r.skill like :search" +
                " or r.position like :search", Recruitment.class)
                .setParameter("search", "%" + search + "%")
                .getResultList();
    }

}
