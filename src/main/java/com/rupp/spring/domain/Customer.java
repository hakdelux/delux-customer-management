/***/
package com.rupp.spring.domain;

import java.util.Date;

/**
 * map to table test_table (id, message)
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2017
 */
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private Date DOB;
    private String addr;
    private String phone;
    private Date createdDate;
    private Date updatedDate;
    
    public Customer() {
        
    }
//    public Customer(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
    /**
     * @return the id
     */
    
    public Long getId(){
    	return id;
    }
    public void setId(Long id){
    	this.id=id;
    }
    
    public String getFirstName(){
    	return firstName;
    }
    public void setFirstName(String firstName){
    	this.firstName = firstName;
    }
    
    public String getLastName(){
    	return lastName;
    }
    public void setLastName(String lastName){
    	this.lastName= lastName;
    }
    
    public String getGender(){
    	return gender;
    }
    public void setGender(String gender){
    	this.gender=gender;
    }
    
    public String getEmail(){
    	return email;
    }
    public void setEmail(String email){
    	this.email=email;
    }
    
    public Date getDOB(){
    	return DOB;
    }
    public void setDOB(Date DOB){
    	this.DOB=DOB;
    }
    
    public String getAddr(){
    	return addr;
    }
    public void setAddr(String addr){
    	this.addr=addr;
    }
    
    public String getPhone(){
    	return phone;
    }
    public void setPhone(String phone){
    	this.phone=phone;
    }
    
    public Date getCreatedDate(){
    	return createdDate;
    }
    public void setCreatedDate(Date createdDate){
    	this.createdDate=createdDate;
    }
    
    public Date getUpdatedDate(){
    	return updatedDate;
    }
    public void setUpdatedDate(Date updatedDate){
    	this.updatedDate=updatedDate;
    }
    /*
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    */
    
}
