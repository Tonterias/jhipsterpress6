package web.jhp6.web.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;

import web.jhp6.web.domain.Profile;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Lob;

/**
 * A DTO for the Post entity.
 */
public class PostDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant creationDate;

    private Instant publicationDate;

    @NotNull
    @Size(min = 2, max = 100)
    private String headline;

    @Size(min = 2, max = 1000)
    private String leadtext;

    @NotNull
    @Size(min = 2, max = 65000)
    private String bodytext;

    @Size(min = 2, max = 1000)
    private String quote;

    @Size(min = 2, max = 2000)
    private String conclusion;

    @Lob
    private byte[] image;
    private String imageContentType;

    private Long urllinkId;

    private Long blogId;

    private String blogTitle;

    private Profile profile;
    
    private Set<CommentDTO> comments;
    
    private Set<CustomTagDTO> tags;

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

    public Instant getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Instant publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getLeadtext() {
        return leadtext;
    }

    public void setLeadtext(String leadtext) {
        this.leadtext = leadtext;
    }

    public String getBodytext() {
        return bodytext;
    }

    public void setBodytext(String bodytext) {
        this.bodytext = bodytext;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public Long getUrllinkId() {
        return urllinkId;
    }

    public void setUrllinkId(Long urllinkId) {
        this.urllinkId = urllinkId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDTO> comments) {
		this.comments = comments;
	}

	public Set<CustomTagDTO> getTags() {
		return tags;
	}

	public void setTags(Set<CustomTagDTO> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blogId == null) ? 0 : blogId.hashCode());
		result = prime * result + ((blogTitle == null) ? 0 : blogTitle.hashCode());
		result = prime * result + ((bodytext == null) ? 0 : bodytext.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((conclusion == null) ? 0 : conclusion.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((headline == null) ? 0 : headline.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((imageContentType == null) ? 0 : imageContentType.hashCode());
		result = prime * result + ((leadtext == null) ? 0 : leadtext.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + ((publicationDate == null) ? 0 : publicationDate.hashCode());
		result = prime * result + ((quote == null) ? 0 : quote.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((urllinkId == null) ? 0 : urllinkId.hashCode());
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
		PostDTO other = (PostDTO) obj;
		if (blogId == null) {
			if (other.blogId != null)
				return false;
		} else if (!blogId.equals(other.blogId))
			return false;
		if (blogTitle == null) {
			if (other.blogTitle != null)
				return false;
		} else if (!blogTitle.equals(other.blogTitle))
			return false;
		if (bodytext == null) {
			if (other.bodytext != null)
				return false;
		} else if (!bodytext.equals(other.bodytext))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (conclusion == null) {
			if (other.conclusion != null)
				return false;
		} else if (!conclusion.equals(other.conclusion))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (headline == null) {
			if (other.headline != null)
				return false;
		} else if (!headline.equals(other.headline))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (imageContentType == null) {
			if (other.imageContentType != null)
				return false;
		} else if (!imageContentType.equals(other.imageContentType))
			return false;
		if (leadtext == null) {
			if (other.leadtext != null)
				return false;
		} else if (!leadtext.equals(other.leadtext))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (publicationDate == null) {
			if (other.publicationDate != null)
				return false;
		} else if (!publicationDate.equals(other.publicationDate))
			return false;
		if (quote == null) {
			if (other.quote != null)
				return false;
		} else if (!quote.equals(other.quote))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (urllinkId == null) {
			if (other.urllinkId != null)
				return false;
		} else if (!urllinkId.equals(other.urllinkId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostDTO [id=" + id + ", creationDate=" + creationDate + ", publicationDate=" + publicationDate
				+ ", headline=" + headline + ", leadtext=" + leadtext + ", bodytext=" + bodytext + ", quote=" + quote
				+ ", conclusion=" + conclusion + ", image=" + Arrays.toString(image) + ", imageContentType="
				+ imageContentType + ", urllinkId=" + urllinkId + ", blogId=" + blogId + ", blogTitle=" + blogTitle
				+ ", profile=" + profile + ", comments=" + comments + ", tags=" + tags + "]";
	}
}
