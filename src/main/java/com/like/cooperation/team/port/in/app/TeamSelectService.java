package com.like.cooperation.team.port.in.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.team.port.in.TeamSelectUseCase;
import com.like.cooperation.team.port.in.dto.TeamSaveDTO;
import com.like.cooperation.team.port.out.TeamCommandDbPort;

@Transactional
@Service
public class TeamSelectService implements TeamSelectUseCase {

	TeamCommandDbPort dbPort;
	
	TeamSelectService(TeamCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public TeamSaveDTO select(Long teamId) {
		return TeamSaveDTO.toDTO(this.dbPort.select(teamId));
	}

}
