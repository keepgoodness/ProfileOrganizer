package org.keepgoodness.ProfileOrganizer.repository;

import org.keepgoodness.ProfileOrganizer.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
