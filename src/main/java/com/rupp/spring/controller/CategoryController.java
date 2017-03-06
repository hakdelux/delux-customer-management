package com.rupp.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rupp.spring.domain.Customer;
import com.rupp.spring.domain.DCategory;
import com.rupp.spring.domain.ResponseList;
import com.rupp.spring.service.CategoryService;

@Controller
@RequestMapping("categories")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService service;
    

    //@RequestMapping(value = "/v1", method = RequestMethod.GET)
    @GetMapping("/v1/all")
    @ResponseBody
//    public List<DCategory> getDCategories() {
//        logger.debug("====get all categories====");
//        return service.list();
//    }
    public List<Customer> getCustomers(){
    	logger.debug("====get all categories====");
    	return service.list();
    }
    
    @GetMapping("/v1")
    @ResponseBody
//    public ResponseList<DCategory> getPage(@RequestParam(value="pagesize", defaultValue="10") int pagesize,
//            @RequestParam(value = "cursorkey", required = false) String cursorkey) {
//        logger.debug("====get page {} , {} ====", pagesize, cursorkey);
//        return service.getPage(pagesize, cursorkey);
//    }
    public ResponseList<Customer> getPage(@RequestParam(value="pagesize", defaultValue="10") int pagesize,
            @RequestParam(value = "cursorkey", required = false) String cursorkey) {
        logger.debug("====get page {} , {} ====", pagesize, cursorkey);
        return service.getPage(pagesize, cursorkey);
    }

    //@RequestMapping(value = "/v1/{id}", method = RequestMethod.GET)
    @GetMapping("/v1/{id}")
//    public ResponseEntity<DCategory> getDCategory(@PathVariable("id") Long id) {
//
//        logger.debug("====get category detail with id :[{}] ====", id);
//        
//        final DCategory category = service.get(id);
//        if (category == null) {
//            return new ResponseEntity("No DCategory found for ID " + id, HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(category, HttpStatus.OK);
//    }
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {

        logger.debug("====get category detail with id :[{}] ====", id);
        
        final Customer customer = service.get(id);
        if (customer == null) {
            return new ResponseEntity("No DCategory found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    

    //@RequestMapping(value = "/v1", method = RequestMethod.POST)
    @PostMapping(value = "/v1")
//    public ResponseEntity<DCategory> createDCategory(@RequestBody DCategory category) {
//        logger.debug("====create new category object ====");
//        service.create(category);
//
//        return new ResponseEntity<>(category, HttpStatus.OK);
//    }
    public ResponseEntity<Customer> createDCategory(@RequestBody Customer customer) {
        logger.debug("====create new category object ====");
        service.create(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    
    

    //@RequestMapping(value = "/v1/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/v1/{id}")
    public ResponseEntity deleteDCategory(@PathVariable Long id) {
        logger.debug("====delete category detail with id :[{}] ====", id);
        if (null == service.delete(id)) {
            return new ResponseEntity("No DCategory found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);

    }
    //@RequestMapping(value = "/v1/{id}", method = RequestMethod.PUT)
    @PutMapping("/v1/{id}")
//    public ResponseEntity updateDCategory(@PathVariable Long id, @RequestBody DCategory category) {
//        logger.debug("====update category detail with id :[{}] ====", id);
//        category = service.update(id, category);
//
//        if (null == category) {
//            return new ResponseEntity("No DCategory found for ID " + id, HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity(category, HttpStatus.OK);
//    }
    public ResponseEntity updateDCategory(@PathVariable Long id, @RequestBody Customer customer) {
        logger.debug("====update category detail with id :[{}] ====", id);
        customer = service.update(id, customer);

        if (null == customer) {
            return new ResponseEntity("No DCategory found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }
    
    
    @PostMapping("/v1/{id}/json")
//    public ResponseEntity updateByJson(@PathVariable Long id, @RequestBody DCategory category) {
//        logger.debug("====update category detail with id :[{}] ====", id);
//        category = service.update(id, category);
//
//        if (null == category) {
//            return new ResponseEntity("No DCategory found for ID " + id, HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity(category, HttpStatus.OK);
//    }
    public ResponseEntity updateByJson(@PathVariable Long id, @RequestBody Customer customer) {
        logger.debug("====update category detail with id :[{}] ====", id);
        customer = service.update(id, customer);

        if (null == customer) {
            return new ResponseEntity("No DCategory found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }
    
    
    
    @PostMapping("/v1/json")
//    public ResponseEntity createByJson(@RequestBody DCategory category) {
//        logger.debug("====create new category object with json====");
//        service.create(category);
//        return new ResponseEntity(category, HttpStatus.OK);
//    }
    public ResponseEntity createByJson(@RequestBody Customer customer) {
        logger.debug("====create new category object with json====");
        service.create(customer);
        return new ResponseEntity(customer, HttpStatus.OK);
    }
    
    
    
    /**
     * <pre>
     * schema api : Content-Type: application/x-www-form-urlencoded 
     * example json value
     * 
     *   {
     *       primaryKeyName: "id",
     *       tableName: "Country",
     *       primaryKeyType: "long",
     *       columns: {
     *           comingSoon: "boolean",
     *           flagImageUrl: "text",
     *           isoCode: "text",
     *           name: "text",
     *           state: "long",
     *           tcsUrl: "text",
     *           createdDate: "datetime"
     *        }
     *   }
     *   </pre>
     * @param request
     */
    @RequestMapping(value = "v1/schema", method = { RequestMethod.GET })
    public ResponseEntity<Map<String, Object>> getschma(HttpServletRequest request) {
        final Map<String, Object> body = new HashMap<String, Object>();
        final Map<String,String> columns = new HashMap<>();
        
        columns.put("First Name", "text");
        columns.put("Last Name", "text");
        columns.put("Gender", "text");
        columns.put("Email", "text");
        columns.put("DOB", "datetime");
        columns.put("Address", "text");
        columns.put("Phone Number", "text");
//        columns.put("Name", "text");
        columns.put("Created Date", "datetime");
        columns.put("Updated Date", "datetime");
        
        body.put("columns", columns);
        body.put("tableName", "category");
        body.put("primaryKeyName", "id");
        body.put("primaryKeyType", "long");
        
        return new ResponseEntity<Map<String, Object>>(body, HttpStatus.OK);
    }
    
}
