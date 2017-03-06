package com.rupp.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rupp.spring.domain.Customer;

import com.rupp.spring.domain.ResponseList;

@Repository("categoryDaoImpl")
public class CategoryDaoImpl implements CategoryDao {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryDaoImpl.class);
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public CategoryDaoImpl(DataSource dataSource) {
        //jdbcTemplate = new JdbcTemplate(DBCP2DataSourceUtils.getDataSource());
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public int count() {
        final String sql = "select count(*) from td_customer";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    //public ResponseList<Customer> getPage(int pagesize, String offset) {
    public ResponseList<Customer> getPage(int pagesize, String offset) {
        if (offset == null) {
            offset = "0";
        }
        final String sql = "select * from td_customer limit " + pagesize + " OFFSET " + offset;
        //List<Customer> list = this.jdbcTemplate.queryForList(sql,Customer.class);
        List<Customer> list = this.jdbcTemplate.query(sql, new RowMapper<Customer>() {

            @Override
            public Customer mapRow(ResultSet rs, int paramInt) throws SQLException {
                final Customer domain = new Customer();
                
	                domain.setId(rs.getLong("cus_id"));
	                domain.setFirstName(rs.getString("cus_firstname"));
	                domain.setLastName(rs.getString("cus_lastname"));
	                domain.setGender(rs.getString("cus_gender"));
	                domain.setEmail(rs.getString("cus_email_address"));
	                domain.setAddr(rs.getString("cus_address"));
	                domain.setPhone(rs.getString("cus_phoneNumber"));
	                domain.setDOB(rs.getDate("cus_DOB"));
	        		domain.setCreatedDate(rs.getDate("date_created"));
	        		domain.setUpdatedDate(rs.getDate("date_updated"));
	                
//                domain.setId(rs.getLong("id"));
//                domain.setName(rs.getString("name"));
//                domain.setCreatedDate(new Date(rs.getTimestamp("createdDate").getTime()));
                
                return domain;
            }
            
        });
        
        return populatePages(list, pagesize, String.valueOf(offset));
    }
    
    protected ResponseList<Customer> populatePages(final Collection<Customer> items, final int pageSize, final String cursorKey) {
        return populatePages(items, pageSize, cursorKey, null);
    }

    protected ResponseList<Customer> populatePages(final Collection<Customer> items, final int pageSize, final String cursorKey, final Integer totalCount) {

        if (items == null || items.isEmpty()) {
            return new ResponseList<Customer>(items);
        }

        int total;
        if (totalCount == null) {
            total = count();
        } else {
            total = totalCount;
        }

        if ("0".equals(cursorKey) && items.size() < pageSize) {
            total = items.size();
        }

        // limit = data.size();
        LOG.debug(" total records count : {} : Integer.parseInt(cursorKey) + items.size() : {} ", total,
                Integer.parseInt(cursorKey) + items.size());
        String nextCursorKey = null;

        if (items.size() == pageSize && Integer.parseInt(cursorKey) + items.size() < total) {
            nextCursorKey = String.format("%s", Integer.parseInt(cursorKey) + items.size());
        }

        LOG.debug("next cursorKey {}", nextCursorKey);

        final ResponseList<Customer> page = new ResponseList<Customer>(items, nextCursorKey);
        page.withTotal(total).withLimit(items.size());

        // populate previous
        if (!"0".equals(cursorKey)) {
            final int previousCursor = Math.abs(Integer.parseInt(cursorKey) - pageSize);
            page.withReverseCursor(String.format("%s", previousCursor));
        }

        return page;
    }
    /**
     * Returns list of categories from dummy database.
     * 
     * @return list of categories
     */

    public List<Customer> list() {
        final String sql = "select * from td_customer";
        //List<Customer> list = this.jdbcTemplate.queryForList(sql,Customer.class);
        List<Customer> list = this.jdbcTemplate.query(sql, new RowMapper<Customer>() {

            @Override
            public Customer mapRow(ResultSet rs, int paramInt) throws SQLException {
                final Customer domain = new Customer();
                
                    domain.setId(rs.getLong("cus_id"));
	                domain.setFirstName(rs.getString("cus_firstname"));
	                domain.setLastName(rs.getString("cus_lastname"));
	                domain.setGender(rs.getString("cus_gender"));
	                domain.setEmail(rs.getString("cus_email_address"));
	                domain.setAddr(rs.getString("cus_address"));
	                domain.setPhone(rs.getString("cus_phoneNumber"));
	                domain.setDOB(rs.getDate("cus_DOB"));
	        		domain.setCreatedDate(rs.getDate("date_created"));
	        		domain.setUpdatedDate(rs.getDate("date_updated"));
	        		
//                domain.setId(rs.getLong("id"));
//                domain.setName(rs.getString("name"));
//                domain.setCreatedDate(new Date(rs.getTimestamp("createdDate").getTime()));
                
                return domain;
            }
            
        });
        return list;
    }

    /**
     * Return Customer object for given id from dummy database. If Customer is not found for id, returns null.
     * 
     * @param id
     *            Customer id
     * @return Customer object for given id
     */
    public Customer get(Long id) {
        final String sql = "select * from td_customer where cus_id = ?";
        
        try {
            //select for object
            final Customer obj = jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Customer>() {

                @Override
                public Customer mapRow(ResultSet rs, int paramInt) throws SQLException {
                    final Customer domain = new Customer();
                    
                    domain.setId(rs.getLong("cus_id"));
                    domain.setFirstName(rs.getString("cus_firstname"));
                    domain.setLastName(rs.getString("cus_lastname"));
                    domain.setGender(rs.getString("cus_gender"));
                    domain.setEmail(rs.getString("cus_email_address"));
                    domain.setAddr(rs.getString("cus_address"));
                    domain.setPhone(rs.getString("cus_phoneNumber"));
                    domain.setDOB(rs.getDate("cus_DOB"));
            		domain.setCreatedDate(rs.getDate("date_created"));
            		domain.setUpdatedDate(rs.getDate("date_updated"));
                    
//                    domain.setId(rs.getLong("id"));
//                    domain.setName(rs.getString("name"));
//                    domain.setCreatedDate(new Date(rs.getTimestamp("createdDate").getTime()));
                    
                    return domain;
                }
            });
            return obj;
        } catch (EmptyResultDataAccessException e) {
            System.out.println("NOT FOUND " + id + " in Table" );
            return null;
        }
    }

    /**
     * Create new Customer in dummy database. Updates the id and insert new Customer in list.
     * 
     * @param Customer
     *            Customer object
     * @return Customer object with updated id
     */
//    public Customer create(Customer Customer) {
//        final String sql = "INSERT INTO category (name) VALUES (?)";
//        jdbcTemplate.update(sql, new Object[] { Customer.getName() });
//        return Customer;
//    }
    
    
    //*****Insert Data from User to Database*****//    
    public Customer create(Customer customer){
    	final String sql = 
		        "INSERT INTO "
		        + "td_customer ("
		        + "cus_firstname, "
		        + "cus_lastname, "
		        + "cus_gender, "
		        + "cus_email_address, "
		        + "cus_DOB, "
		        + "cus_address, "
		        + "cus_phoneNumber, "
		        + "date_created ) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	jdbcTemplate.update(sql, new Object[] { 
    			customer.getFirstName(), 
		        customer.getLastName(), 
		        customer.getGender(), 
		        customer.getEmail(), 
		        customer.getDOB(),
		        customer.getAddr(),
		        customer.getPhone(),
		        customer.getCreatedDate()
		        
    	});
    	return customer;
    }

    /**
     * @param id
     *            the Customer id
     * @return id of deleted Customer object
     */
    public Long delete(Long id) {
        final String sql = "Delete from td_customer where cus_id =?";
        int result = jdbcTemplate.update(sql, new Object[] { id });
        return result == 1 ? id : null;
    }

    /**
     * Update the Customer object for given id in dummy database. If Customer not exists, returns null
     * 
     * @param id
     * @param Customer
     * @return Customer object with id
     */
    public Customer update(Customer customer) {

    	final String sql = 
		        "UPDATE "
		        		+ "td_customer SET "
				        + "cus_firstname = ?, "
				        + "cus_lastname = ?, "
				        + "cus_gender = ?, "
				        + "cus_email_address = ?, "
				        + "cus_DOB = ?, "
				        + "cus_address = ?, "
				        + "cus_phoneNumber = ?, "
				        + "date_updated = ?"
				        + "WHERE cus_id = ?";
    	int result =jdbcTemplate.update(sql, new Object[] { 
    			customer.getFirstName(), 
		        customer.getLastName(), 
		        customer.getGender(), 
		        customer.getEmail(), 
		        customer.getDOB(),
		        customer.getAddr(),
		        customer.getPhone(),
		        customer.getUpdatedDate()
    	});
    	return result == 1 ? customer : null;
    	
    	
    	
    	
        //final String sql = "UPDATE category set name =? where id=?";
        //int result = jdbcTemplate.update(sql, new Object[] { Customer.getName() , Customer.getId()});
        //return result == 1 ? Customer : null;

    }

}
