package com.example.user_details_service.Repository;

import com.example.user_details_service.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
