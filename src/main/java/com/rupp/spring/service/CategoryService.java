package com.rupp.spring.service;

import java.util.List;

import com.rupp.spring.domain.Customer;
import com.rupp.spring.domain.DCategory;
import com.rupp.spring.domain.ResponseList;

public interface CategoryService {
//    List<DCategory> list();
//    DCategory get(Long id);
//    DCategory create(DCategory dCategory);
//    Long delete(Long id);
//    DCategory update(Long id, DCategory dCategory);
//    ResponseList<DCategory> getPage(int pagesize, String cursorkey);
	
	List<Customer> list();
	Customer get(Long id);
	Customer create(Customer customer);
	Long delete(Long id);
	Customer update(Long id, Customer customer);
	ResponseList<Customer> getPage(int pagesize, String  cursorkey);
	
	
	
}
