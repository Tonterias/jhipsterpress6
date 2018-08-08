package web.jhp6.web.service.dto;

import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import web.jhp6.web.domain.Profile;

/**
 * A DTO for the Follow entity.
 */
public class FollowDTO implements Serializable {

    private Long id;

    private Instant creationDate;

    private Long cfollowedId;

    private Long cfollowingId;

//    private Long followedId;

//    private Long followingId;
    
    private Profile followed;
    
    private Profile following;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCfollowedId() {
        return cfollowedId;
    }

    public void setCfollowedId(Long communityId) {
        this.cfollowedId = communityId;
    }

    public Long getCfollowingId() {
        return cfollowingId;
    }

    public void setCfollowingId(Long communityId) {
        this.cfollowingId = communityId;
    }

	public Profile getFollowing() {
		return following;
	}

	public void setFollowing(Profile following) {
		this.following = following;
	}

	public Profile getFollowed() {
		return followed;
	}

	public void setFollowed(Profile followed) {
		this.followed = followed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cfollowedId == null) ? 0 : cfollowedId.hashCode());
		result = prime * result + ((cfollowingId == null) ? 0 : cfollowingId.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((followed == null) ? 0 : followed.hashCode());
		result = prime * result + ((following == null) ? 0 : following.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FollowDTO other = (FollowDTO) obj;
		if (cfollowedId == null) {
			if (other.cfollowedId != null)
				return false;
		} else if (!cfollowedId.equals(other.cfollowedId))
			return false;
		if (cfollowingId == null) {
			if (other.cfollowingId != null)
				return false;
		} else if (!cfollowingId.equals(other.cfollowingId))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (followed == null) {
			if (other.followed != null)
				return false;
		} else if (!followed.equals(other.followed))
			return false;
		if (following == null) {
			if (other.following != null)
				return false;
		} else if (!following.equals(other.following))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FollowDTO [id=" + id + ", creationDate=" + creationDate + ", cfollowedId=" + cfollowedId
				+ ", cfollowingId=" + cfollowingId + ", followed=" + followed + ", following=" + following + "]";
	}

//    public Long getFollowingId() {
//        return followingId;
//    }
//
//    public void setFollowingId(Long profileId) {
//        this.followingId = profileId;
//    }
}
