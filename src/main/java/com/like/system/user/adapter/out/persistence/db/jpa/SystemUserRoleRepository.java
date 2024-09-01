package com.like.system.user.adapter.out.persistence.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.like.system.user.domain.SystemUserCompanyRole;
import com.like.system.user.domain.SystemUserCompanyRoleId;

public interface SystemUserRoleRepository extends JpaRepository<SystemUserCompanyRole, SystemUserCompanyRoleId> {
}
