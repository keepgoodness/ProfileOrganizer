package org.keepgoodness.ProfileOrganizer.repository;

import org.keepgoodness.ProfileOrganizer.model.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}