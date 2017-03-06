package com.rupp.spring.dao;

import java.util.List;

import com.rupp.spring.domain.Customer;
import com.rupp.spring.domain.DCategory;
import com.rupp.spring.domain.ResponseList;

public interface CategoryDao {

    /**
     * Returns list of categories from dummy database.
     * 
     * @return list of categories
     */
    //List<DCategory> list();

    List<Customer> list();
    
    
    /**
     * Return dCategory object for given id from dummy database. If dCategory is not found for id, returns null.
     * 
     * @param id
     *            dCategory id
     * @return dCategory object for given id
     */
    //DCategory get(Long id);
    Customer get(Long id);
    
    /**
     * Create new dCategory in dummy database. Updates the id and insert new dCategory in list.
     * 
     * @param dCategory
     *            DCategory object
     * @return dCategory object with updated id
     */
    //DCategory create(DCategory dCategory);
    Customer create (Customer customer);
    
    Long delete(Long id);
    
    //DCategory update(DCategory dCategory);
    Customer update(Customer customer);
    
    //ResponseList<DCategory> getPage(int pagesize, String cursorkey);
    ResponseList<Customer> getPage(int pagesize, String cursorkey);
}
