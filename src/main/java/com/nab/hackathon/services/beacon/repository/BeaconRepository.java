package com.nab.hackathon.services.beacon.repository;

import com.nab.hackathon.services.beacon.entity.Beacon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pasapicella on 4/20/17.
 */
public interface BeaconRepository extends JpaRepository <Beacon, Long> {

}
