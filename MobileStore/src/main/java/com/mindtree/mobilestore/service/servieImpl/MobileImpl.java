package com.mindtree.mobilestore.service.servieImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.mobilestore.entity.Mobile;
import com.mindtree.mobilestore.repository.MobileRepo;
import com.mindtree.mobilestore.service.MobileService;
@Service
public class MobileImpl implements MobileService {
	@Autowired
	MobileRepo mobileRepo;
	@Override
	public List<Mobile> listAll() {
		List<Mobile> listmobile=mobileRepo.findAll();
		return listmobile;
	}

	@Override
	public void save(Mobile mobile) {
		mobileRepo.save(mobile);
		
	}

	@Override
	public Mobile get(long id) {
		Mobile mobile=mobileRepo.findById(id).get();
		return mobile;
	}

	@Override
	public void delete(long id) {
		mobileRepo.deleteById(id);
		
	}

}
