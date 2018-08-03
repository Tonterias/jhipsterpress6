package web.jhp6.web.repository;

import web.jhp6.web.domain.Frontpageconfig;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Frontpageconfig entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FrontpageconfigRepository extends JpaRepository<Frontpageconfig, Long>, JpaSpecificationExecutor<Frontpageconfig> {

}
