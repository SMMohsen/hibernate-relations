package com.hibernate.relations.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hibernate.relations.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reaction")
public class Reaction extends BaseEntity implements Serializable {

	
	@Column(name = "reaction_type")
	@NaturalId
	private String reactionType;
	
	@OneToMany(mappedBy = "reaction" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JsonIgnore
	private List<PostReaction> postReactions = new ArrayList<>();

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Reaction))
			return false;
		
		Reaction other = (Reaction) obj;
		
		return other.getReactionType().equals(this.reactionType);
	}
	
	
	
}
