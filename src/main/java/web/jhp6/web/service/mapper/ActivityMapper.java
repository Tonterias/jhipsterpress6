package web.jhp6.web.service.mapper;

import web.jhp6.web.domain.*;
import web.jhp6.web.service.dto.ActivityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Activity and its DTO ActivityDTO.
 */
@Mapper(componentModel = "spring", uses = {CommunityMapper.class, ProfileMapper.class})
public interface ActivityMapper extends EntityMapper<ActivityDTO, Activity> {



    default Activity fromId(Long id) {
        if (id == null) {
            return null;
        }
        Activity activity = new Activity();
        activity.setId(id);
        return activity;
    }
}
