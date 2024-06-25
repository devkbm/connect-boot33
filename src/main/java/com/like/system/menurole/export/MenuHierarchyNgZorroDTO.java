package com.like.system.menurole.export;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.like.system.menu.domain.MenuHierarchy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuHierarchyNgZorroDTO {
	
	/* NzTreeNodeOptions */
	String key;
	
	String title;			
					
	boolean expanded;
	
	boolean selected;
	
	@JsonProperty(value="isLeaf")
	boolean isLeaf;
	
	List<MenuHierarchyNgZorroDTO> children;
	/* NzTreeNodeOptions */
	
	String menuGroupCode;
	
	String parentMenuCode;
	
	String menuType;
	
	Long sequence;
	
	Long level;
	
	String url;
	
	public static MenuHierarchyNgZorroDTO build(MenuHierarchy dto) {
		MenuHierarchyNgZorroDTO rec = new MenuHierarchyNgZorroDTO();
		
		rec.menuGroupCode = dto.getMenuGroupCode();
		rec.parentMenuCode = dto.getParentMenuCode();
		rec.menuType = dto.getMenuType().toString();
		rec.sequence = dto.getSequence();
		rec.level = dto.getLevel();
		rec.url = dto.getAppUrl();
		
		rec.key = dto.getMenuCode();
		rec.title = dto.getMenuName();
		rec.expanded = false;
		rec.selected = false;
		
		rec.isLeaf = dto.isLeaf();
		
		return rec;
	}

	public void setChildren(List<MenuHierarchyNgZorroDTO> children) {
		this.children = children;
	}
	
	public void setIsLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	
}
