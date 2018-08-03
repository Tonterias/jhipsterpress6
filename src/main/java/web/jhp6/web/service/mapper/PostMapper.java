package web.jhp6.web.service.mapper;

import web.jhp6.web.domain.*;
import web.jhp6.web.service.dto.PostDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Post and its DTO PostDTO.
 */
@Mapper(componentModel = "spring", uses = {UrllinkMapper.class, BlogMapper.class, ProfileMapper.class})
public interface PostMapper extends EntityMapper<PostDTO, Post> {

    @Mapping(source = "urllink.id", target = "urllinkId")
    @Mapping(source = "blog.id", target = "blogId")
    @Mapping(source = "blog.title", target = "blogTitle")
    @Mapping(source = "profile.id", target = "profileId")
    PostDTO toDto(Post post);

    @Mapping(source = "urllinkId", target = "urllink")
    @Mapping(target = "comments", ignore = true)
    @Mapping(source = "blogId", target = "blog")
    @Mapping(source = "profileId", target = "profile")
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "topics", ignore = true)
    Post toEntity(PostDTO postDTO);

    default Post fromId(Long id) {
        if (id == null) {
            return null;
        }
        Post post = new Post();
        post.setId(id);
        return post;
    }
}
