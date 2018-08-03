package web.jhp6.web.service.mapper;

import web.jhp6.web.domain.*;
import web.jhp6.web.service.dto.FrontpageconfigDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Frontpageconfig and its DTO FrontpageconfigDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FrontpageconfigMapper extends EntityMapper<FrontpageconfigDTO, Frontpageconfig> {



    default Frontpageconfig fromId(Long id) {
        if (id == null) {
            return null;
        }
        Frontpageconfig frontpageconfig = new Frontpageconfig();
        frontpageconfig.setId(id);
        return frontpageconfig;
    }
}
