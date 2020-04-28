package com.mindtree.mobilestore.service;

import java.util.List;

import com.mindtree.mobilestore.entity.Mobile;

public interface MobileService {

	List<Mobile> listAll();

	void save(Mobile mobile);

	Mobile get(long id);

	void delete(long id);

}
