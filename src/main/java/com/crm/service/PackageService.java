package com.crm.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.PackageDao;
import com.crm.model.PackageEntity;

@Service
public class PackageService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private PackageDao packageDao;

	public PackageEntity createPackage(PackageEntity packageEntity) throws Exception {
		logger.info("PackageService :: createPackage ");
		return packageDao.createPackage(packageEntity);
	}

	public PackageEntity modifyPackage(PackageEntity packageEntity) throws Exception {
		logger.info("PackageService :: createPackage ");
		return packageDao.modifyPackage(packageEntity);

	}

	public List<PackageEntity> getPackages(String tenantcode) {
		logger.info("PackageService :: getPackages ");
		return packageDao.getPackages(tenantcode);
	}

}
