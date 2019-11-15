package com.crm.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.crm.dao.PackageDao;
import com.crm.model.PackageEntity;
import com.crm.util.DaoUtil;

@Repository
public class PackageDaoImpl extends DaoUtil implements PackageDao {

	private Logger logger = Logger.getLogger(this.getClass());
	/*
	 * @Autowired private SessionFactory sessionFactory;
	 */

	@Override
	public PackageEntity createPackage(PackageEntity packageEntity) throws Exception {
		logger.info("PackageDaoImpl :: createPackage");
		packageEntity.setSno(BigInteger.valueOf(saveAnyEntity(packageEntity)));
		return packageEntity;
	}

	@Override
	public PackageEntity modifyPackage(PackageEntity packageEntity) throws Exception {
		logger.info("PackageDaoImpl :: modifyPackage");
		updateAnyEntity(packageEntity);
		return packageEntity;
	}

	@Override
	public List<PackageEntity> getPackages(String tenantcode) {
		logger.info("PackageDaoImpl :: getPackages");
		return getAnyEntityList(PackageEntity.class, "username", tenantcode);
	}

}
