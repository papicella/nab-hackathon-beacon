package com.nab.hackathon.services.beacon.repository;

import com.nab.hackathon.services.beacon.entity.CustomerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistration, CustomerRegistration.CustomerRegistrationId>
{
    @Query("select a from CustomerRegistration a where a.customerRegistrationId.customerId = ?1")
    List<CustomerRegistration> findByCustomerId(Long customerId);
}
