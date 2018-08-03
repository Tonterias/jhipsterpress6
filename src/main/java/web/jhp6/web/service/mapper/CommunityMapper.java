package web.jhp6.web.service.mapper;

import web.jhp6.web.domain.*;
import web.jhp6.web.service.dto.CommunityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Community and its DTO CommunityDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface CommunityMapper extends EntityMapper<CommunityDTO, Community> {

    @Mapping(source = "user.id", target = "userId")
    CommunityDTO toDto(Community community);

    @Mapping(target = "blogs", ignore = true)
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "cfolloweds", ignore = true)
    @Mapping(target = "cfollowings", ignore = true)
    @Mapping(target = "blockingusers", ignore = true)
    @Mapping(target = "blockedusers", ignore = true)
    @Mapping(source = "userId", target = "user")
    @Mapping(target = "calbums", ignore = true)
    @Mapping(target = "interests", ignore = true)
    @Mapping(target = "activities", ignore = true)
    @Mapping(target = "celebs", ignore = true)
    Community toEntity(CommunityDTO communityDTO);

    default Community fromId(Long id) {
        if (id == null) {
            return null;
        }
        Community community = new Community();
        community.setId(id);
        return community;
    }
}
