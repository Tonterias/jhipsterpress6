package web.jhp6.web.repository;

import web.jhp6.web.domain.Community;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Community entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CommunityRepository extends JpaRepository<Community, Long>, JpaSpecificationExecutor<Community> {

    @Query("select community from Community community where community.user.login = ?#{principal.username}")
    List<Community> findByUserIsCurrentUser();

}
