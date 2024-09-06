package com.like.system.menu.port.out;

import com.like.system.menu.domain.Menu;

public interface MenuSaveDbPort {
	void save(Menu dto);
}
