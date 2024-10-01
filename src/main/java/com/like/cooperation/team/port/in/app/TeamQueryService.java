package com.like.cooperation.team.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.team.domain.Team;
import com.like.cooperation.team.domain.TeamMember;
import com.like.cooperation.team.port.in.TeamQueryUseCase;
import com.like.cooperation.team.port.in.dto.TeamQueryDTO;
import com.like.cooperation.team.port.out.TeamQueryRepository;
import com.like.system.user.export.SystemUserDTO;
import com.like.system.user.export.SystemUserDTOSelectUseCase;
import com.like.system.user.port.in.SystemUserQueryUseCase;
import com.like.system.user.port.in.dto.SystemUserQueryDTO;
import com.like.system.user.port.in.dto.SystemUserSaveDTO;

@Transactional(readOnly=true)
@Service
public class TeamQueryService implements TeamQueryUseCase {

	private TeamQueryRepository teamQueryRepository;
	private SystemUserDTOSelectUseCase userQueryService;
	
	public TeamQueryService(TeamQueryRepository teamQueryRepository
						   ,SystemUserDTOSelectUseCase userQueryService) {
		this.teamQueryRepository = teamQueryRepository;
		this.userQueryService = userQueryService;
	}
		
	@Override
	public List<Team> selectTeamList(TeamQueryDTO dto) {
		return teamQueryRepository.getTeamList(dto);
	}

	@Override
	public List<TeamMember> selectTeamMemeberList(Long id) {
		return teamQueryRepository.getTeamMemberList(id);
	}

	/*
	@Override
	public List<SystemUserDTO> selectAllMemberList(SystemUserQueryDTO dto) {
		//return userQueryService.selectList(dto);
		return null;
	}	
	*/
}