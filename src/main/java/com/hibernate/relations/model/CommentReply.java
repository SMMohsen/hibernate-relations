package com.hibernate.relations.model;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class CommentReply {

	
	private String creatorName;
	
	private String content;
}
