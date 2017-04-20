package com.nab.hackathon.services.beacon.rest;

import com.nab.hackathon.services.beacon.entity.CustomerRegistration;
import com.nab.hackathon.services.beacon.repository.CustomerRegistrationRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/custreg")
public class CustomerRegistrationRest
{
    private static Log logger = LogFactory.getLog(CustomerRegistrationRest.class);

    @Autowired
    private CustomerRegistrationRepository customerRegistrationRepository;

    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerRegistration> allCustomerRegistration()
    {
        logger.info("Invoking /custreg/all RESTful method");
        return customerRegistrationRepository.findAll();
    }

    @RequestMapping(value = "/newcustreg", method=RequestMethod.POST)
    public CustomerRegistration create(@RequestBody CustomerRegistration customerRegistration)
    {
        logger.info("Invoking /custreg/newcustreg RESTful method");
        return customerRegistrationRepository.save(customerRegistration);
    }

    @RequestMapping(value = "/deletecustreg/{beaconId}/{customerId}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Long beaconId,
                       @PathVariable Long customerId)
    {
        logger.info("Invoking /custreg/deletecustreg/{beaconId}/{customerId} RESTful method");

        CustomerRegistration.CustomerRegistrationId customerRegistrationId = new CustomerRegistration.CustomerRegistrationId();

        customerRegistrationId.setBeaconId(beaconId);
        customerRegistrationId.setCustomerId(customerId);

        customerRegistrationRepository.delete(customerRegistrationId);

        logger.info("Deleted beacon with id " + beaconId);


    }

    @RequestMapping(value = "/allregbycustomer/{customerId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerRegistration> allCustomerRegistrationByCustomerId
            (@PathVariable Long customerId)
    {
        logger.info("Invoking /custreg/all RESTful method");
        return customerRegistrationRepository.findByCustomerId(customerId);
    }
}
