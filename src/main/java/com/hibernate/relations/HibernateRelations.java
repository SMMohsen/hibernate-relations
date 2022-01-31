package com.hibernate.relations;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.hibernate.relations.common.PresistenceManger;

@SpringBootApplication
public class HibernateRelations {

	public static void main(String[] args) {
		SpringApplication.run(HibernateRelations.class, args);
	}


}
