package com.jingrui.service;

import java.util.List;
import com.jingrui.domain.Permission;

public interface PermissionService {
	public List<Permission> getAll();
	public void update(Permission permission);
	public Integer getNormalPermissionId();
}
