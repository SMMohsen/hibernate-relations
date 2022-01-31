package com.hibernate.relations.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "post_comment")
public class PostComment implements Serializable {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "comment_content")
	private String content;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	//@JsonIgnore
	private Post post;
	
	@ElementCollection
	private List<CommentReply> replys = new ArrayList<>();
	
	
	
	
}
