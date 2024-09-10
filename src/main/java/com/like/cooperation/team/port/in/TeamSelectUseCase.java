package com.like.cooperation.team.port.in;

import com.like.cooperation.team.port.in.dto.TeamSaveDTO;

public interface TeamSelectUseCase {
	TeamSaveDTO select(Long teamId);
}
