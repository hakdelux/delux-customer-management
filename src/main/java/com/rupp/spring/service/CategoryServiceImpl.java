package com.rupp.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rupp.spring.dao.CategoryDao;
import com.rupp.spring.domain.Customer;
import com.rupp.spring.domain.DCategory;
import com.rupp.spring.domain.ResponseList;

@Service("categorySevice")
public class CategoryServiceImpl implements CategoryService {
    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    
    @Autowired
    private CategoryDao dao;
    
//    @Override
//    public List<DCategory> list() {
//        return dao.list();
//    }

    @Override
    public List<Customer> list(){
    	return dao.list();
    }
    
    
//    @Override
//    public DCategory get(Long id) {
//        return dao.get(id);
//    }
    @Override
    public Customer get(Long id){
    	return dao.get(id);
    }

//    @Override
//    public DCategory create(DCategory dCategory) {
//        return dao.create(dCategory);
//    }
    @Override
    public Customer create(Customer customer){
    	return dao.create(customer);
    }

//    @Override
//    public Long delete(Long id) {
//        return dao.delete(id);
//    }
    @Override
    public Long delete(Long id){
    	return dao.delete(id);
    }
    

//    @Override
//    public DCategory update(Long id, DCategory dCategory) {
//        
//        if (dao.get(id) == null) {
//            return null;
//        }
//        dCategory.setId(id);
//        return dao.update(dCategory);
//    }
    @Override
    public Customer update(Long id, Customer customer){
    	if (dao.get(id)== null){
    		return null;
    	}
    	customer.setId(id);
    	return dao.update(customer);
    }
    
    
//    public ResponseList<DCategory> getPage(int pagesize, String cursorkey) {
//        logger.debug(" getPage limit : {} cursorkey : {}", pagesize, cursorkey);
//        return dao.getPage(pagesize, cursorkey);
//    }
    
    public ResponseList<Customer> getPage(int pagesize, String cursorkey) {
      logger.debug(" getPage limit : {} cursorkey : {}", pagesize, cursorkey);
      return dao.getPage(pagesize, cursorkey);
  }
}
