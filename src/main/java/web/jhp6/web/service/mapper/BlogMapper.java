package web.jhp6.web.service.mapper;

import web.jhp6.web.domain.*;
import web.jhp6.web.service.dto.BlogDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Blog and its DTO BlogDTO.
 */
@Mapper(componentModel = "spring", uses = {CommunityMapper.class})
public interface BlogMapper extends EntityMapper<BlogDTO, Blog> {

    @Mapping(source = "community.id", target = "communityId")
    BlogDTO toDto(Blog blog);

    @Mapping(target = "posts", ignore = true)
    @Mapping(source = "communityId", target = "community")
    Blog toEntity(BlogDTO blogDTO);

    default Blog fromId(Long id) {
        if (id == null) {
            return null;
        }
        Blog blog = new Blog();
        blog.setId(id);
        return blog;
    }
}
