package com.hibernate.relations.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "post_details")
public class PostDetails implements Serializable {

	@Id
	private Long id;

	@Column(name = "creator_name")
	private String creatorName;
	
	@Column(name="likes_count")
	private Integer likesCount;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JsonIgnore
	private Post post;

	@Override
	public int hashCode() {
		return Objects.hash(this.post.getId());
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PostDetails))
			return false;
		
		PostDetails other = (PostDetails) obj;
		return this.getPost().getId().equals(other.getPost().getId());
	}
	
	
}
