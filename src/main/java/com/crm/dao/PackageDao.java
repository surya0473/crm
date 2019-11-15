package com.crm.dao;

import java.util.List;

import com.crm.model.PackageEntity;

public interface PackageDao {

	PackageEntity createPackage(PackageEntity packageEntity) throws Exception;

	PackageEntity modifyPackage(PackageEntity packageEntity) throws Exception;

	List<PackageEntity> getPackages(String tenantcode);

}
