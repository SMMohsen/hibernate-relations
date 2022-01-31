package com.hibernate.relations.common;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable{

	@Id
	@GeneratedValue
	protected Long id;
	
}
