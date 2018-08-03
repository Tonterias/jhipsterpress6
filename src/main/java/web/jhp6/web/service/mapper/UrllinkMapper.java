package web.jhp6.web.service.mapper;

import web.jhp6.web.domain.*;
import web.jhp6.web.service.dto.UrllinkDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Urllink and its DTO UrllinkDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UrllinkMapper extends EntityMapper<UrllinkDTO, Urllink> {


    @Mapping(target = "post", ignore = true)
    Urllink toEntity(UrllinkDTO urllinkDTO);

    default Urllink fromId(Long id) {
        if (id == null) {
            return null;
        }
        Urllink urllink = new Urllink();
        urllink.setId(id);
        return urllink;
    }
}
