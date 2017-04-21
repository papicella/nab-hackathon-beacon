package com.nab.hackathon.services.beacon.repository;

import com.nab.hackathon.services.beacon.entity.Beacon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeaconRepository extends JpaRepository <Beacon, String>
{
    Beacon findByMerchantId(Long merchantId);
}
