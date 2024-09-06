package com.like.system.menu.port.out;

import com.like.system.menu.domain.MenuGroup;

public interface MenuGroupSaveDbPort {
	void save(MenuGroup entity);
}
