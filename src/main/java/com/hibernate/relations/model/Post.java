package com.hibernate.relations.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hibernate.relations.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "post")
@Table(name = "post")
public class Post extends BaseEntity implements Serializable {


    @Column(name = "content")
    private String content;

    @Column(name="is_read")
    private Character isRead;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @OneToMany(mappedBy = "post" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    List<PostComment> comments = new ArrayList<>();
    
    
    @OneToOne(mappedBy = "post" , cascade = CascadeType.ALL, fetch = FetchType.LAZY,optional = false)
    private PostDetails postDetails;
    
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
        @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();
    
    @OneToMany(mappedBy = "post" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private Set<PostReaction> postReactions = new HashSet<>();
    
    public void addComments(List<PostComment> postComment) {
    	this.comments.addAll(postComment);
    	postComment.forEach(p -> p.setPost(this));
    }
    
    public void removeComment(PostComment postComment) {
    	this.comments.remove(postComment);
    	postComment.setPost(null);
    }
    
    public void addPostDetails(PostDetails postDetials) {
    	this.postDetails = postDetials;
    	postDetials.setPost(this);
    }
    
    public void addTags(List<Tag> tags) {
    	this.tags.addAll(tags);
    	tags.forEach(t -> t.getPosts().add(this));
    }
    
    public void removeTags(List<Tag> tags) {
    	this.tags.removeAll(tags);
    	tags.forEach(t -> t.getPosts().remove(this));
    }
    
    public void addReactions(List<PostReaction> reactions) {
    	this.getPostReactions().addAll(reactions);
    	reactions.forEach(r -> r.setPost(this));
    }

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Post))
			return false;
		
		Post other = (Post) obj;
		
		return id != null && id.equals(((Post) obj).getId());
	}
    
    
   
}
