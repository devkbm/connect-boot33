package com.like.system.menu.adapter.out.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.like.system.menu.domain.MenuGroup;
import com.like.system.menu.domain.MenuGroupId;

public interface MenuGroupJpaRepository extends JpaRepository<MenuGroup, MenuGroupId>, ListQuerydslPredicateExecutor<MenuGroup> {

}
