package web.jhp6.web.repository;

import web.jhp6.web.domain.Urllink;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Urllink entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UrllinkRepository extends JpaRepository<Urllink, Long>, JpaSpecificationExecutor<Urllink> {

}
