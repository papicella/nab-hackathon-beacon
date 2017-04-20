package com.nab.hackathon.services.beacon.rest;

import com.nab.hackathon.services.beacon.entity.Beacon;
import com.nab.hackathon.services.beacon.repository.BeaconRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/beacon")
public class BeaconRest
{
    private static Log logger = LogFactory.getLog(BeaconRest.class);

    @Autowired
    private BeaconRepository beaconRepository;

    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Beacon> allBeacons()
    {
        logger.info("Invoking /beacon/all RESTful method");
        return beaconRepository.findAll();
    }

    @RequestMapping(value = "/merchant/{merchantId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Beacon findByMerchantId(@PathVariable Long merchantId)
    {
        logger.info("Invoking /beacon/merchant/{merchantId} RESTful method");
        return beaconRepository.findByMerchantId(merchantId);
    }

    @RequestMapping(value = "/newbeacon", method=RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Beacon create(@RequestBody Beacon beacon)
    {
        logger.info("Invoking /beacon/newbeacon RESTful method");
        return beaconRepository.save(beacon);
    }


    @RequestMapping(value = "/deletebeacon/{beaconId}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long beaconId)
    {
        logger.info("Invoking /beacon/deletebeacon/{beaconId} RESTful method");
        Beacon beacon = beaconRepository.findOne(beaconId);
        beaconRepository.delete(beacon);
        logger.info("Deleted beacon with id " + beaconId);

    }

}
