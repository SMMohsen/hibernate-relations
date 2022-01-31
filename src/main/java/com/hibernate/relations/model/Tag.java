package com.hibernate.relations.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hibernate.relations.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NaturalIdCache
@Entity
@Table(name= "tag")
public class Tag extends BaseEntity implements Serializable {

	
	@NaturalId(mutable = false)
	@Column(name= "tag_name")
	private String tagName;
	
	
	 @ManyToMany(mappedBy = "tags")
	 //@JsonIgnore
	 private Set<Post> posts = new HashSet<>();


	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}


	@Override
	public boolean equals(Object obj) {
		if((obj instanceof Tag))
			return false;
		
		Tag other = (Tag) obj;
		
		return other.getId().equals(this.id);
	}
	 
	 
	
}
