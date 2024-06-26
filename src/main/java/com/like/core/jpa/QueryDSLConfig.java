package com.like.core.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration
public class QueryDSLConfig {

	@PersistenceContext
	EntityManager em;
	
	@Bean
	JPAQueryFactory queryFactory() {
		return new JPAQueryFactory(em);		
	}
}
