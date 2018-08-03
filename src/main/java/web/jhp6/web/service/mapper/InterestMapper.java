package web.jhp6.web.service.mapper;

import web.jhp6.web.domain.*;
import web.jhp6.web.service.dto.InterestDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Interest and its DTO InterestDTO.
 */
@Mapper(componentModel = "spring", uses = {CommunityMapper.class, ProfileMapper.class})
public interface InterestMapper extends EntityMapper<InterestDTO, Interest> {



    default Interest fromId(Long id) {
        if (id == null) {
            return null;
        }
        Interest interest = new Interest();
        interest.setId(id);
        return interest;
    }
}
