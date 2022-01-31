package com.hibernate.relations.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class PostReactionId implements Serializable {
	
	@Column(name="post_id")
	private Long postId;
	
	@Column(name ="reaction_id")
	private Long reactionId;

	@Override
	public int hashCode() {
		return Objects.hash(postId,reactionId);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PostReactionId))
			return false;
		
		PostReactionId other = (PostReactionId) obj;
		
		return other.postId.equals(this.postId) && other.getReactionId().equals(this.getReactionId());
	}
	

}
