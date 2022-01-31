package com.hibernate.relations.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="post_reaction")
public class PostReaction implements Serializable {
	
	@EmbeddedId
	private PostReactionId id;
	
	@Column(name = "color")
	private String color;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@MapsId("postId")
	@JsonIgnore
	private Post post;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@MapsId("reactionId")
	private Reaction reaction;

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PostReaction))
			return false;
		
		PostReaction other = (PostReaction) obj;
		
		return other.getId().equals(this.id);
	}
	
	
	

}
